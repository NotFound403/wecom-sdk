package cn.felord.wecom;

import cn.felord.AgentDetails;
import cn.felord.DefaultAgent;
import cn.felord.WeComTokenCacheable;
import cn.felord.api.WorkWeChatApi;
import cn.felord.domain.externalcontact.*;
import cn.felord.domain.message.*;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.card.*;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ChatType;
import cn.felord.enumeration.NativeAgent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

/**
 * The type Spring boot wecom sdk tests.
 */
@SpringBootTest
class SpringBootWecomSdkTests {
    /**
     * The We com token cacheable.
     */
    @Autowired
    WeComTokenCacheable weComTokenCacheable;
    @Autowired
    private WorkWeChatApi workWeChatApi;

    /**
     * 企微机器人
     */
    @Test
    void webHooks() {
        // 发 markdown
        WebhookBody body = new WebhookMarkdownBody(new ContentText("这里为markdown消息"));
        // 发纯文本
//        body = new WebhookTextBody(new WebhookTextBody.WebhookText("这里为纯文本"));
// 发图文
//        WebhookNewsBody.WebhookNews news = new WebhookNewsBody.WebhookNews();
//        WebhookNewsBody.WebhookArticle article = new WebhookNewsBody.WebhookArticle();
//        article.setPicurl("这里为封面图链接");
//        article.setUrl("这里为图文链接");
//        article.setTitle("这里为标题");
//        article.setDescription("这里为摘要信息");
//        news.setArticles(Collections.singletonList(article));
//        body = new WebhookNewsBody(news);

        WorkWeChatApi.webhookApi().send("机器人key", body);
    }

    /**
     * 比较复杂的应用文本卡片模版消息
     */
    @Test
    void sendAgentMsg() {
        CardSource source = new CardSource();
        source.setDesc("XXX系统通知");
        source.setDescColor(CardSource.DescColor.GREY);
        source.setIconUrl("这里替换方形系统小logo链接");
        MainTitle mainTitle = new MainTitle("主标题", "次标题");

        TextHorizontalContent jcNo = new TextHorizontalContent("订单编号", "xxxxxxxxxxxxxxxxxxxx");
        TextHorizontalContent car = new TextHorizontalContent("订单地址", "大王庄二郎庙");
        // 使用ID转录
        TextHorizontalContent jcOrg = new TextHorizontalContent("公司名称", "$departmentName=" + 1 + "$");
        // 员工组件 使用ID转录
        AtStaffHorizontalContent staff = AtStaffHorizontalContent.withTransUserId("推送人员", "这里放企微成员的userid");
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        TextHorizontalContent time = new TextHorizontalContent("推送日期", now);

        TextMessageTemplateCard textMessageTemplateCard = TemplateCardBuilders.textMessageTemplateCardBuilder(new UrlCardAction("这里放面板路径"))
                .source(source)
                .mainTitle(mainTitle)
                .horizontalContentList(Arrays.asList(jcNo, car, jcOrg, staff, time))
                .jumpList(Collections.singletonList(new UrlJump("查看详情", "https://baidu.com")))
                .build();

        TemplateCardMessageBody<TextMessageTemplateCard> cardMessageBody = MessageBodyBuilders.templateCardMessageBodyBuilder(textMessageTemplateCard)
                .touser("发送的目标成员，多个使用|隔开")
                // 开启ID转录  不然上面的组件会报错
                .enableIdTrans(BoolEnum.TRUE)
                // 开启重复检查
                .enableDuplicateCheck(BoolEnum.TRUE)
                .build();

        DefaultAgent defaultAgent = new DefaultAgent("企微企业id", "企微应用密钥", "企微应用id");
        MessageResponse send = workWeChatApi.agentMessageApi(defaultAgent).send(cardMessageBody);
        Assertions.assertTrue(send.isSuccessful());
    }


    /**
     * 给客户推送小程序促销消息
     */
    @Test
    void sendToUsers() {
        MsgTemplateRequest request = new MsgTemplateRequest(ChatType.SINGLE);
        // 这里会推送给该员工，员工执行后会下发给他添加的所有外部联系人  需要遵循企微的推送规则
        request.setSender("员工企微id");
        // 引导文案 要尽量吸引眼球
        String context = "🎉🎉🎉10元生鲜拼团最后一天\n" +
                "👉现在下单，福利多多，有几率获得以下礼品一份\n" +
                "🎁新鲜小台芒一斤\n" +
                "🎁西红柿一斤\n" +
                "快来点击小程序拼团吧😀";
        ContentText text = new ContentText(context);
        // 引导文案 要尽量吸引眼球
        request.setText(text);
        // 标题长度 64
        String title = "企微客户生鲜福利最后一天啦";
        // 小程序appid
        String appid = "xxxxxxxxxxxxxxxx";
        // 临时素材上传
        String picMeidaId = "3UF5V8DXrsjsSsvDE9HXDGcxoHZ78MPX-mS6aAaASPew7cgPGXtWcarAdWDdu0NRf";

        // 小程序活动页面
        String page = "store/pages/hots/detail.html?sku=xd233243&state=QWPT2342";
        Miniprogram miniprogram = new Miniprogram(title, appid, picMeidaId, page);
        MiniprogramMsgAttachment o = new MiniprogramMsgAttachment(miniprogram);
        request.setAttachments(Collections.singletonList(o));
        AgentDetails nativedAgent = DefaultAgent.nativeAgent("企业id", "外部联系人密钥", NativeAgent.EXTERNAL);
        MsgTemplateResponse msgTemplateResponse = workWeChatApi.externalContactManager(nativedAgent)
                .messageApi()
                .addMsgTemplate(request);
        System.out.println("msgTemplateResponse = " + msgTemplateResponse);
    }


    /**
     * 缓存测试
     */
    @Test
    void tokenCache() {
        String token = "xxxxxxxxxxxxxxxxx";
        weComTokenCacheable.putAccessToken("a", "b", token);
        String accessToken = weComTokenCacheable.getAccessToken("a", "b");
        Assertions.assertEquals(token, accessToken);
    }
}
