package cn.felord;

import cn.felord.api.ContactsApi;
import cn.felord.api.JsSdkTicketApi;
import cn.felord.api.WebhookApi;
import cn.felord.api.contactbook.DepartmentApi;
import cn.felord.api.contactbook.UserApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.department.DeptRequest;
import cn.felord.domain.contactbook.user.UserInfoRequest;
import cn.felord.domain.jssdk.JSignature;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.WebhookNewsBody;
import cn.felord.domain.webhook.WebhookTextBody;
import lombok.SneakyThrows;

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
    @SneakyThrows
    public static void main(String[] args) {
        Agent agent = new Agent("wwa70dc5b6e56936e1",
                "Y7R73gG_xSgbNmFR32x2AmOdxdH0pcn4HVNpjbhfybs","");

        JsSdkTicketApi jsSdkTicketApi = new JsSdkTicketApi().agent(agent);


        JSignature jSignature = jsSdkTicketApi.agentTicket("https://felord.cn");

        System.out.println("jSignature = " + jSignature);


// 3zwpcJy82HOuOj9twJFkfBJFp8CP7UVx9K4NxDDXc06x8JksF7i9PR95jHJ8_iaEJ
//        TagApi tagApi = new TagApi(agent);
//
//        TagUserResponse tags = tagApi.getTagUsers(2);
//        System.out.println("tags = " + tags);

//        DepartmentApi departmentApi = new DepartmentApi(agent);
//        GenericResponse<List<DeptRequest>> deptRequestListResponse = departmentApi.deptList("2");
//        System.out.println("deptRequestListResponse = " + deptRequestListResponse);
//        UserApi userApi = new UserApi(agent);
//        GenericResponse<Integer> activeStat = userApi.getActiveStat(LocalDate.now());
//        System.out.println("activeStat = " + activeStat);
//        ListResponse<SimpleUser> deptUsers = userApi.getDeptUsers("2", DeptUserFetchType.THIS);
//        System.out.println("deptUsers = " + deptUsers);
//        GenericResponse<String> joinQrcode = userApi.getJoinQrcode(UserQrcodeSize.SIZE_399);
//        System.out.println("joinQrcode = " + joinQrcode);
//        UserInfoResponse x334454655 = userApi.getUser("x334454655");
//        System.out.println("x334454655 = " + x334454655);
    }


    public static void creatDept() {
        Agent agent = new Agent("wwa70dc5b6e56936e1",
                "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo","");
        DepartmentApi departmentApi = new DepartmentApi().agent(agent);
        DeptRequest deptRequest = new DeptRequest();
        deptRequest.setNameEn("NMC");
        deptRequest.setParentid(1);
        deptRequest.setName("新媒体中心");

        GenericResponse<String> dept = departmentApi.createDept(deptRequest);
        System.out.println("dept = " + dept);
    }

    public static void creatUser() {
        Agent agent = new Agent("wwa70dc5b6e56936e1",
                "DsO2JAHSzn4u7Oj-Gxc9wrzO9lkARRCD2OFkuJ6-WEo","");
        UserApi userApi = new UserApi().agent(agent);

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
                "");


        ContactsApi contactsApi = new ContactsApi().agent(agent);

        GenericResponse<List<String>> contactList = contactsApi.getContactList("XiaFangFang");

        System.out.println("contactList = " + contactList);
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
