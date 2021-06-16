package cn.felord;

import cn.felord.api.ContactsApi;
import cn.felord.api.WebhookApi;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.domain.customer.ExternalContactResponse;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.WebhookNewsBody;
import cn.felord.domain.webhook.WebhookTextBody;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Test.
 *
 * @author n1
 * @since 2021 /6/16 11:48
 */
public class Test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       sendHook();
    }


    public static void contactsApi() {
        ContactsApi contactsApi = new ContactsApi();

        ExternalContactResponse contactList = contactsApi.getContactList(" ");

        System.out.println("contactList = " + contactList);
    }

    /**
     * Token.
     */
    public static void token() {
        WeComClient accessTokenResponseWeComClient = new WeComClient();


        String webhook = WeComEndpoint.GET_TOKEN.endpoint(WeComDomain.CGI_BIN);

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(webhook).queryParam("corpid", "wwa70dc5b6e56936e1").queryParam("corpsecret", "Y7R73gG_xSgbNmFR32x2AmOdxdH0pcn4HVNpjbhfybs").build();
        AccessTokenResponse weComResponse = accessTokenResponseWeComClient.get(uriComponents.toUri(), AccessTokenResponse.class);

        System.out.println("weComResponse = " + weComResponse);
    }

    /**
     * Send hook.
     */
    public static void sendHook() {

        WebhookApi webhookApi = new WebhookApi();


        WebhookTextBody body = new WebhookTextBody();
        WebhookTextBody.WebhookText webhookText = new WebhookTextBody.WebhookText();
        webhookText.setContent("hello world");
        webhookText.setMentionedList(Collections.singletonList("@all"));
        body.setText(webhookText);

        WebhookMarkdownBody webhookMarkdownBody = new WebhookMarkdownBody();
        WebhookMarkdownBody.WebhookMarkdown markdown = new WebhookMarkdownBody.WebhookMarkdown();

        String a = "实时新增用户反馈<font color=\"warning\">{0}</font>，请相关同事注意。\n " +
                "> 类型:<font color=\"comment\">用户反馈</font> \n " +
                "> 普通用户反馈:<font color=\"comment\">{1}</font> \n " +
                "> VIP用户反馈:<font color=\"info\">{2}</font>";
        String content = MessageFormat.format(a, "233次", "123次", "12次");
        markdown.setContent(content);
        webhookMarkdownBody.setMarkdown(markdown);

        WebhookNewsBody webhookNewsBody = new WebhookNewsBody();

        WebhookNewsBody.WebhookNews news = new WebhookNewsBody.WebhookNews();

        List<WebhookNewsBody.WebhookArticle> articles = new ArrayList<>();

        WebhookNewsBody.WebhookArticle webhookArticle = new WebhookNewsBody.WebhookArticle();
        webhookArticle.setDescription("中秋节礼品领取");
        webhookArticle.setTitle("今年中秋节公司有豪礼相送");
        webhookArticle.setUrl("felord.cn");
        webhookArticle.setPicurl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");

        articles.add(webhookArticle);
        news.setArticles(articles);


        webhookNewsBody.setNews(news);


        WeComResponse emptyBodyResponse = webhookApi.send("e824f396-4325-4671-b7cf-15bf69f85ece", webhookNewsBody);
        System.out.println("post = " + emptyBodyResponse);
    }
}
