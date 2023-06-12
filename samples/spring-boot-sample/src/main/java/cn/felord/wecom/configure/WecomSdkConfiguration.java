package cn.felord.wecom.configure;

import cn.felord.WeComTokenCacheable;
import cn.felord.api.WorkWeChatApi;
import cn.felord.callbacks.CallbackCrypto;
import cn.felord.callbacks.CallbackCryptoBuilder;
import cn.felord.callbacks.CallbackSettings;
import cn.felord.callbacks.CallbackSettingsService;
import cn.felord.domain.callback.CallbackEventBody;
import cn.felord.enumeration.CallbackEvent;
import cn.felord.wecom.cache.EhcacheWeComTokenCacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * Wecom Sdk 配置
 *
 * @author dax
 * @since 2023 /5/30
 */
@Configuration(proxyBeanMethods = false)
public class WecomSdkConfiguration {

    /**
     * 企微token，ticket 缓存中继，这里使用ehcache作为例子，你可以无缝替换为redis等缓存中间件
     *
     * @return the we com token cacheable
     */
    @Bean
    WeComTokenCacheable weComTokenCacheable() {
        return new EhcacheWeComTokenCacheable();
    }

    /**
     * 初始化 企微API客户端，这个是平常我们发起调用的入口
     * <p>
     * 例子参见 test 测试包下的 SpringBootWecomSdkTests
     *
     * @param weComTokenCacheable the we com token cacheable
     * @return the work we chat api
     */
    @Bean
    WorkWeChatApi workWeChatApi(WeComTokenCacheable weComTokenCacheable) {
        return new WorkWeChatApi(weComTokenCacheable);
    }

    /**
     * 回调配置
     *
     * @return the callback crypto
     */
    @Bean
    public CallbackCrypto callbackCrypto() {
        return new CallbackCryptoBuilder(new Consumer<CallbackEventBody>() {
            // 消费 被解密的回调消息 已达到动态处理企微事件业务的能力  这里还有其它高级操作 自行去看底层实现
            @Override
            public void accept(CallbackEventBody callbackEventBody) {
                // 获取事件类型  建议每个类型的处理逻辑抽成接口   统一实现
                CallbackEvent event = callbackEventBody.getEvent();

            }
        })
                .build(new CallbackSettingsService() {
                    // 这里你可以通过实现该接口来持久化 根据 企微应用id 和企业id 查询对应应用的回调 token  encodingAesKey 等回调参数，
                    @Override
                    public CallbackSettings loadAuthentication(String agentId, String corpId) {
                        return new CallbackSettings("", "", "");
                    }
                });
    }




}
