package cn.felord;

import cn.felord.api.WebhookApi;
import cn.felord.domain.AccessTokenResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.WebhookTextBody;
import cn.felord.enumeration.MsgType;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

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

        WebhookApi webhookApi = new WebhookApi("e824f396-4325-4671-b7cf-15bf69f85ece");


        WebhookTextBody body = new WebhookTextBody();
        WebhookTextBody.WebhookText webhookText = new WebhookTextBody.WebhookText();
        webhookText.setContent("hello world");
        webhookText.setMentionedList(Collections.singletonList("@all"));
        body.setText(webhookText);

        WebhookMarkdownBody webhookMarkdownBody = new WebhookMarkdownBody();
        WebhookMarkdownBody.WebhookMarkdown markdown = new WebhookMarkdownBody.WebhookMarkdown();

        String a = "实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n " +
                ">类型:<font color=\"comment\">用户反馈</font> \n " +
                ">普通用户反馈:<font color=\"comment\">117例</font> \n " +
                ">VIP用户反馈:<font color=\"comment\">15例</font>";

        markdown.setContent(a);
        webhookMarkdownBody.setMarkdown(markdown);


        WeComResponse emptyBodyResponse = webhookApi.sendText(webhookMarkdownBody);
        System.out.println("post = " + emptyBodyResponse);
    }
}
