package cn.felord;

import cn.felord.api.ContactsApi;
import cn.felord.api.WebhookApi;
import cn.felord.api.contactbook.ContactBookAgent;
import cn.felord.api.contactbook.DepartmentApi;
import cn.felord.api.contactbook.UserApi;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.domain.contactbook.department.CreateDeptRequest;
import cn.felord.domain.contactbook.department.CreateDeptResponse;
import cn.felord.domain.contactbook.user.QrcodeResponse;
import cn.felord.domain.contactbook.user.UserInfoRequest;
import cn.felord.domain.contactbook.user.UserInfoResponse;
import cn.felord.domain.customer.ExternalContactResponse;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.WebhookNewsBody;
import cn.felord.domain.webhook.WebhookTextBody;
import cn.felord.enumeration.UserQrcodeSize;
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
        ContactBookAgent agent = new ContactBookAgent("wwa70dc5b6e56936e1",
                "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo", "");
        UserApi userApi = new UserApi(agent);
        QrcodeResponse joinQrcode = userApi.getJoinQrcode(UserQrcodeSize.SIZE_399);
        System.out.println("joinQrcode = " + joinQrcode);
//        UserInfoResponse x334454655 = userApi.getUser("x334454655");
//        System.out.println("x334454655 = " + x334454655);
    }


    public static void creatDept() {
        ContactBookAgent agent = new ContactBookAgent("wwa70dc5b6e56936e1",
                "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo", "");
        DepartmentApi departmentApi = new DepartmentApi(agent);

        CreateDeptRequest createDeptRequest = new CreateDeptRequest();
        createDeptRequest.setNameEn("NMC");
        createDeptRequest.setParentid(1);
        createDeptRequest.setName("新媒体中心");

        CreateDeptResponse dept = departmentApi.createDept(createDeptRequest);
        System.out.println("dept = " + dept);
    }

    public static void creatUser() {
        ContactBookAgent agent = new ContactBookAgent("wwa70dc5b6e56936e1",
                "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo", "");
        UserApi userApi = new UserApi(agent);

        UserInfoRequest request = new UserInfoRequest();

        request.setUserid("x334454655");
        request.setName("张三");
        request.setDepartment(Collections.singletonList(2));
        request.setEmail("felord@qq.com");

        WeComResponse user = userApi.createUser(request);

        System.out.println("user = " + user);
    }


    public static void contactsApi() {


        Agent agent = new Agent("wwa70dc5b6e56936e1",
                "nVtCCnhlJ0tIMdNMQ0BkheQQVvvy1lHoQBISuREyi-4",
                "", "", "");


        ContactsApi contactsApi = new ContactsApi(agent);

        ExternalContactResponse contactList = contactsApi.getContactList("XiaFangFang");

        System.out.println("contactList = " + contactList);
    }

    /**
     * Token.
     */
    public static void token() {
        WeComClient accessTokenResponseWeComClient = new WeComClient();


        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint(WeComDomain.CGI_BIN))
                .queryParam("corpid", "wwa70dc5b6e56936e1")
                .queryParam("corpsecret", "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo")
                .build();
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
