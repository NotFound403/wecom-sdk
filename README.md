[![Maven Central Repo Deployment](https://github.com/NotFound403/wecom-sdk/actions/workflows/main.yml/badge.svg)](https://github.com/NotFound403/wecom-sdk/actions/workflows/main.yml)
## 使用方法
目前自建应用大部分功能可以适配，其它模式未适配。
## 坐标
```xml
            <dependency>
                <groupId>cn.felord</groupId>
                <artifactId>wecom-sdk</artifactId>
                <version>${wecom.sdk.version}</version>
            </dependency>
```
### 实现缓存接口

需要实现标记缓存接口`cn.felord.WeComCacheable`的接口，分别用来存储**access_token**，**企业jsapi_ticket**，**应用jsapi_ticket**
> 具体缓存策略根据企业微信文档自行实现。

### API入口类

`WorkWeChatApi`

> 目前暂时不支持第三方开发

## API实现进度

- 获取企业微信API域名IP段
  - [x] 获取企业微信API域名IP段
- 自建应用与第三方应用的对接
  - [x] 自建应用与第三方应用的对接
- 通讯录管理
  - [x] 成员管理
  - [x] 部门管理
  - [x] 标签管理
  - [x] 异步导入接口
  - [x] 通讯录回调通知
  - [x] 互联企业
  - [ ] 异步导出接口
- 客户联系
  - [x] 企业服务人员管理
  - [x] 客户管理
  - [x] 客户标签管理
  - [x] 在职继承
  - [x] 离职继承
  - [x] 客户群管理
  - [x] 联系我与客户入群方式
  - [x] 客户朋友圈
  - [x] 消息推送
  - [x] 统计管理
  - [x] 变更回调
  - [x] 管理商品图册
  - [x] 管理聊天敏感词
  - [x] 上传附件资源
- [ ] 微信客服
  - [x] 客服账号管理
  - [x] 接待人员管理
  - [ ] 会话分配与消息收发
- [x] 身份验证
- [x] 应用管理
- [x] 消息推送
- [x] 素材管理
  - [x] 上传临时素材
  - [x] 上传图片
- [x] OA
- [x] 效率工具
- 企业支付
- 企业互联
- 会话内容存档
- 电子发票
- 家校沟通
- 家校应用
- 政民沟通
