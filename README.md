<div align="center" style="margin-bottom: 10px">
    <a target="_blank" href="https://mvnrepository.com/artifact/cn.felord/wecom-sdk">
     	<img src="wechat-sdk.svg" height="50%" width="50%" alt="wecom-sdk"/>
    </a>
</div>
<p align="center">
    <a target="_blank" href="https://github.com/NotFound403/wecom-sdk/blob/release/LICENSE">
     	<img alt="" src="https://img.shields.io/github/license/NotFound403/wecom-sdk"/>
    </a>
    <a target="_blank" href="https://felord.cn">
     	<img alt="" src="https://img.shields.io/badge/java-8-red"/>
    </a>   
    <a target="_blank" href="https://spring.io">
     	<img alt="" src="https://img.shields.io/badge/spring%20boot-2.4%2B-brightgreen"/>
    </a>   
    <a target="_blank" href="https://mvnrepository.com/artifact/cn.felord/wecom-sdk">
     	<img alt="" src="https://img.shields.io/maven-central/v/cn.felord/wecom-sdk.svg?style=flat-square"/>
    </a>   
    <a target="_blank" href="https://github.com/NotFound403/wecom-sdk">
     	<img alt="" src="https://img.shields.io/github/stars/NotFound403/wecom-sdk?style=social"/>
    </a>    
    <a target="_blank" href="https://gitee.com/felord/wecom-sdk/stargazers">
     	<img alt="" src="https://gitee.com/felord/wecom-sdk/badge/star.svg?theme=white"/>
    </a>    
    <a target="_blank" href="https://work.weixin.qq.com/kfid/kfc9d9d759f27f087e1">
     	<img alt="点击立即微信咨询" src="https://img.shields.io/badge/%E7%82%B9%E5%87%BB-%E5%BE%AE%E4%BF%A1%E5%92%A8%E8%AF%A2-brightgreen"/>
    </a>    
    <a target="_blank" href="http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=jteebwBcvUDnEIjP6Kef3HfucjoJtk3h&authKey=%2F6P%2FtQ6TOYDO1iRmtCcqNm4dMOXdqWHQ91cuNt9V3XtDy78orcy8cUlpOhwv3yCG&noverify=0&group_code=4390822">
     	<img alt="点击加入QQ交流群" src="https://img.shields.io/badge/QQ%E4%BA%A4%E6%B5%81%E7%BE%A4-4390822-ff69b4"/>
    </a>
</p>


<p align="center">📢如果你感觉这个项目不错，请点击项目右上角的⭐以鼓励作者，谢谢🎉。</p>

## 🏆简介

[wecom-sdk](https://gitee.com/felord/wecom-sdk)是开源的企业微信开放API的Java实现，是目前最完整的企业微信Java
SDK。历经三年迭代，目前已经实现了企业微信相关接口近200个，配置简单、API友好、开发人员不需要很高的学习成本就能快速接入企业微信。

## 🔥特性

- 支持多企业微信同时配置作业
- 目前实现企业微信接口 200 多个，能满足大部分场景的需求
- 全参数封装，入参、出参高度语义化封装，再也不担心组织参数、解析参数的问题
- 实现统一回调，所有回调事件可集中异步处理，开发者只需要关心业务逻辑的处理
- 由 SDK 接管 AccessToken 生命周期，开发者无需关心 Token 的管理。

## 🔥技术栈

- OkHttp
- Retrofit
- Rxjava
- Jackson2
- XStream

## 🔥使用方法

目前自建应用可轻松适配，服务商、代开发暂不开源。

## 🔥Maven中央仓库坐标

- 普通版本

```xml
<dependency>
  <groupId>cn.felord</groupId>
  <artifactId>wecom-sdk</artifactId>
  <version>1.1.1.RC</version>
</dependency>
```

- rxjava 版本

```xml

<dependency>
  <groupId>cn.felord</groupId>
  <artifactId>rx-wecom-sdk</artifactId>
  <version>1.1.1.RC</version>
</dependency>
```

## 🔥入门

**Spring Boot**
例子参见 [samples/spring-boot-sample](https://gitee.com/felord/wecom-sdk/tree/release/samples/spring-boot-sample)。
> 相关概念请参考[QUICKSTART](QUICKSTART.md)

## 🔥API实现进度

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
- [x] 微信客服
  - [x] 客服账号管理
  - [x] 接待人员管理
  - [x] 会话分配与消息收发
- [x] 身份验证
- [x] 应用管理
- [x] 消息推送
- [x] 素材管理
  - [x] 上传临时素材
  - [x] 上传图片
- [x] OA
  - [x] 文档
  - [x] 日程
  - [x] 微盘
  - [x] 审批
- [x] 企业支付
  - [x] 企业红包
  - [x] 向员工付款
  - [x] 对外收款
  - [ ] 创建对外收款账户
- 企业互联
- 会话内容存档
- 电子发票
- 家校沟通
- 家校应用
- 政民沟通

## 特别鸣谢

<div align="center" style="margin-bottom: 10px">
    <a target="_blank" href="https://www.jetbrains.com/">
     	<img src="jb_beam.png" height="300" width="300" alt="jetbrains"/>
    </a>
</div>

