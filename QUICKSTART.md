## 概念

步骤是不是非常简单，基本都是在组装参数。可能里面有几个概念大家会有疑惑，接下来我们对里面的一些重要概念进行一些说明。

### 实现缓存接口

需要实现标记缓存接口`cn.felord.WeComCacheable`的接口，分别用来存储**access_token**，**企业jsapi_ticket**，**应用jsapi_ticket
**
> 具体缓存策略根据企业微信文档自行实现。

### 应用抽象 AgentDetails

`cn.felord.AgentDetails` 是对应用的抽象描述，包含了企业ID`corpId`，应用ID`agentId`以及密钥`secret`
，绝大多数接口的调用会用到它，默认实现是`DefaultAgent`。如果是自建应用你可以这样初始化：

```java
AgentDetails agent=new DefaultAgent("企业ID","应用密钥","应用ID");
```

如果是内置应用，比如外部联系人应用：

```java
AgentDetails external=DefaultAgent.nativeAgent("企业ID","应用密钥",NativeAgent.EXTERNAL);
```

通常这些应用参数会存入数据库，然后我们需要通过**企业ID**和**应用ID**实现应用配置检索服务（可以增加缓存来降低数据库的检索压力）：

``` 
  (corpId,agentId)->AgentDetails
```

### 缓存中继

`WeComTokenCacheable`定义企业微信所需要的`AccessToken`、`corpticket`和`agentticket`中继缓存。这里我使用了Spring
Cache实现，你可以自由选择，但是要自行保证中继服务器数据一致性。

```java
public static class RedisWeComCacheable implements WeComTokenCacheable {
  private static final String QYWX_TOKEN_CACHE = "token::qywx";
  private static final String QYWX_CORP_TICKET_CACHE = "ticket::qywx::corp";
  private static final String QYWX_AGENT_TICKET_CACHE = "ticket::qywx::agent";

  @CachePut(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String putAccessToken(@NotNull String corpId, @NotNull String agentId, @NotNull String accessToken) {
    return accessToken;
  }

  @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String getAccessToken(@NotNull String corpId, @NotNull String agentId) {
    return null;
  }

  @CachePut(value = {QYWX_CORP_TICKET_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String putCorpTicket(@NotNull String corpId, @NotNull String agentId, @NotNull String corpTicket) {
    return corpTicket;
  }

  @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String getCorpTicket(@NotNull String corpId, @NotNull String agentId) {
    return null;
  }

  @CachePut(value = {QYWX_AGENT_TICKET_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String putAgentTicket(@NotNull String corpId, @NotNull String agentId, @NotNull String agentTicket) {
    return agentTicket;
  }

  @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
  @Override
  public String getAgentTicket(@NotNull String corpId, @NotNull String agentId) {
    return null;
  }
}
```

### API入口类

`WorkWeChatApi`是企业微信API的唯一入口，推荐注入**Spring IoC**
,然后就可以通过它的一系列方法来实现企业微信提供的功能了。例如通过手机号查询成员的企业微信userid:

```java
AgentDetails agent=DefaultAgent.nativeAgent("企业ID","通讯录secret",NativeAgent.CONTACT);

        GenericResponse<String> userIdByMobile=wecom.contactBookManager(agent)
        .userApi()
        .getUserIdByMobile("这里为手机号");
        String userId=userIdByMobile.getData();

```

### 回调

回调的处理通过`CallbackCrypto`来负责，它屏蔽了验签、解密、异步处理等技术难点，你可以通过`CallbackCryptoBuilder`
构建`CallbackCrypto`，并把`CallbackCrypto`注入Spring IoC。

#### CallbackCryptoBuilder

`CallbackCryptoBuilder`有几个关键点：

- `XmlReader`  XML解析的抽象，框架默认提供了XStream实现，不喜欢的可以重新实现注入。
- `Consumer<CallbackEventBody>` 消费事件函数，用来处理回调数据。
- `CallbackSettingsService` 企业微信回调配置检索，用来检索回调的配置参数。
- `ExecutorService` 回调处理线程池，回调数据的处理是异步的，这里默认提供了一个名字为`WECOM-CALLBACK-THREAD-POOL`
  的线程池，你也可以自定义一个符合你实际配置的线程池。

参考示例：

```java
@Bean
public CallbackCrypto callbackCrypto(IEventRecordService eventRecordService,
        IWeCallbackSettingsService callbackSettingsService){
        return new CallbackCryptoBuilder(eventRecordService::handleCallbackEvent)
        .build(callbackSettingsService::getByAgentIdAndCorpId);
        }
```

#### 回调示例

通用回调参考示例：

```java

@RestController
@RequestMapping("/wecom/callback")
public class CallbackController {
  /**
   * The Callback crypto.
   */
  @Autowired
  CallbackCrypto callbackCrypto;

  /**
   * 验证回调URL
   *
   * @param msgSignature the msg signature
   * @param timestamp    the timestamp
   * @param nonce        the nonce
   * @param echostr      the echostr
   * @param corpId       the corp id
   * @param agentId      the agent id
   * @return the long
   */
  @GetMapping("/{corpId}/{agentId}")
  public String verifyUrl(@RequestParam("msg_signature") String msgSignature,
                          @RequestParam String timestamp,
                          @RequestParam String nonce,
                          @RequestParam String echostr,
                          @PathVariable String corpId,
                          @PathVariable String agentId) {
    return callbackCrypto.decryptMsg(agentId, corpId, msgSignature, timestamp, nonce, echostr);
  }

  /**
   * 消费回调数据
   *
   * @param msgSignature the msg signature
   * @param timestamp    the timestamp
   * @param nonce        the nonce
   * @param xmlBody      the xml body
   * @param corpId       the corp id
   * @param agentId      the agent id
   * @return the string
   */
  @PostMapping("/{corpId}/{agentId}")
  public String consume(@RequestParam("msg_signature") String msgSignature,
                        @RequestParam String timestamp,
                        @RequestParam String nonce,
                        @RequestBody String xmlBody,
                        @PathVariable String corpId,
                        @PathVariable String agentId) {
    return callbackCrypto
            .accept(agentId, corpId, msgSignature, timestamp, nonce, xmlBody);
  }

}
```
