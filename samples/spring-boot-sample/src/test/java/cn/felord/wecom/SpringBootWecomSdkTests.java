/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.wecom;

import cn.felord.AgentDetails;
import cn.felord.DefaultAgent;
import cn.felord.WeComTokenCacheable;
import cn.felord.api.ApprovalApi;
import cn.felord.api.ContactBookManager;
import cn.felord.api.ExternalContactUserApi;
import cn.felord.api.UserApi;
import cn.felord.api.WorkWeChatApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.approval.ApprovalApplyRequest;
import cn.felord.domain.approval.ApprovalDetail;
import cn.felord.domain.approval.ApprovalSpNo;
import cn.felord.domain.approval.ApprovalTitle;
import cn.felord.domain.approval.ApprovalTmpDetailResponse;
import cn.felord.domain.approval.Approver;
import cn.felord.domain.approval.ContactValue;
import cn.felord.domain.approval.ContentDataValue;
import cn.felord.domain.approval.ControlConfig;
import cn.felord.domain.approval.DateRangeValue;
import cn.felord.domain.approval.DateValue;
import cn.felord.domain.approval.FormulaValue;
import cn.felord.domain.approval.ListContentDataValue;
import cn.felord.domain.approval.LocationValue;
import cn.felord.domain.approval.MoneyValue;
import cn.felord.domain.approval.NumberValue;
import cn.felord.domain.approval.PhoneNumberValue;
import cn.felord.domain.approval.RelatedApprovalValue;
import cn.felord.domain.approval.SelectorValue;
import cn.felord.domain.approval.Summary;
import cn.felord.domain.approval.TextValue;
import cn.felord.domain.approval.TmpControl;
import cn.felord.domain.common.TemplateId;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.user.SimpleUser;
import cn.felord.domain.externalcontact.ContentText;
import cn.felord.domain.externalcontact.MiniprogramMsgAttachment;
import cn.felord.domain.externalcontact.MsgTemplateRequest;
import cn.felord.domain.externalcontact.MsgTemplateResponse;
import cn.felord.domain.message.MessageBodyBuilders;
import cn.felord.domain.message.MessageResponse;
import cn.felord.domain.message.TemplateCardBuilders;
import cn.felord.domain.message.TemplateCardMessageBody;
import cn.felord.domain.message.TextMessageTemplateCard;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.card.AtStaffHorizontalContent;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.TextHorizontalContent;
import cn.felord.domain.webhook.card.UrlCardAction;
import cn.felord.domain.webhook.card.UrlJump;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ChatType;
import cn.felord.enumeration.DateRangeType;
import cn.felord.enumeration.NativeAgent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
     * 比较复杂的应用文本卡片模版消息，其它卡片模版使用{@link TemplateCardBuilders}构建
     */
    @Test
    void sendAgentMsg() {
        CardSource source = new CardSource();
        source.setDesc("XXX系统通知");
        source.setDescColor(CardSource.DescColor.GREY);
        source.setIconUrl("这里替换方形系统小logo链接");
        MainTitle mainTitle = new MainTitle("主标题", "次标题");

        TextHorizontalContent no = new TextHorizontalContent("订单编号", "xxxxxxxxxxxxxxxxxxxx");
        TextHorizontalContent address = new TextHorizontalContent("订单地址", "大王庄二郎庙");
        // 使用ID转录
        TextHorizontalContent orgName = new TextHorizontalContent("公司名称", "$departmentName=" + 1 + "$");
        // 员工组件 使用ID转录
        AtStaffHorizontalContent staff = AtStaffHorizontalContent.withTransUserId("推送人员", "这里放企微成员的userid");
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        TextHorizontalContent time = new TextHorizontalContent("推送日期", now);

        TextMessageTemplateCard textMessageTemplateCard = TemplateCardBuilders.textMessageTemplateCardBuilder(new UrlCardAction("这里放面板路径"))
                .source(source)
                .mainTitle(mainTitle)
                .horizontalContentList(Arrays.asList(no, address, orgName, staff, time))
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
        MessageResponse send = workWeChatApi.agentApi(defaultAgent)
                .agentMessageApi()
                .send(cardMessageBody);
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
        MiniprogramMsgAttachment o = new MiniprogramMsgAttachment(title, appid, picMeidaId, page);
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


    @Test
    void approval() {
        // 审批应用
        AgentDetails nativeAgent = DefaultAgent.nativeAgent("", "", NativeAgent.APPROVAL);
        ApprovalApi approvalApi = workWeChatApi.approvalApi(nativeAgent);
        // 模板
        String templateId = "C4UEh71DAPh775HPfXipikZ5eAGosskDibU8hkfxJ";
        // 查询模板配置  可以用缓存优化性能 避免直接查询企业微信
        ApprovalTmpDetailResponse templateDetail = approvalApi.getTemplateDetail(new TemplateId(templateId));
        System.out.println("templateDetail = " + templateDetail);

        // 根据模板配置渲染数据

        List<TmpControl<? extends ControlConfig>> controls = templateDetail.getTemplateContent()
                .getControls();
        Instant now = Instant.now();
        Instant minus = now.minus(1, ChronoUnit.DAYS);
        // 按模板顺序排列 不填写用null占位  必须保证参数和模板一一对应
        List<ContentDataValue> dataValues = Arrays.asList(
                // 部门组件
                ContactValue.depts(Collections.singletonList(1L)),
                // 文本组件
                TextValue.from("A3223423"),
                // 文本组件
                TextValue.from("MODEL123"),
                // 数字组件
                NumberValue.from(123),
                // 员工组件
                ContactValue.users(Collections.singletonList("3958")),
                // 多选组件 option-1694425966006 为选项key  从模板配置中获取
                SelectorValue.multiple(Collections.singletonList("option-1694425966006")),
                // 多行文本组件
                TextValue.from("哈哈哈哈哈hhhhj\n" +
                        "把你你你你你干活健健康康HGH地地道道的反反复复反反复复橙V就睡觉许许多多的"),
                // 货币组件
                MoneyValue.from(12),
                // 公式组件仅仅占位
                FormulaValue.create(),
                // 日期组件
                DateValue.date(now),
                // 日期+时间
                DateValue.dateTime(now),
                // 时长组件
                new DateRangeValue(DateRangeType.HALF_DAY, minus, now),
                // 单选
                SelectorValue.single("option-1694586803563"),
                // 多选
                SelectorValue.multiple(Arrays.asList("option-1694586805670", "option-1694586805670")),
                // 位置
                new LocationValue("30.867621", "111.676726", "大润发", "xx省xx市xx区xxx路112号", Instant.now()),
                // 审批
                RelatedApprovalValue.from(Collections.singletonList("202309130010")),
                // 明细
                new ListContentDataValue(Collections.singletonList(TextValue.from("321423"))),
                // 说明文字控件不显示在审批详情中，故value为空
                TextValue.nullValue(),
                // 国内手机号   +86 + 手机号
                PhoneNumberValue.zhCN("182xxxxxxxxx")
        );

        // 审批人 两个节点
        List<Approver> approver = Arrays.asList(
                new Approver("123"), new Approver("123")
        );
        // 摘要
        List<Summary> summaryList = Collections.singletonList(new Summary(Collections.singletonList(ApprovalTitle.zhCN("测试模板"))));
        //        审批人模式：0-通过接口指定审批人、抄送人（此时approver、notifyer等参数可用）;
//        1-使用此模板在管理后台设置的审批流程(需要保证审批流程中没有“申请人自选”节点)，支持条件审批。
        // 这里使用 0
        ApprovalApplyRequest request = ApprovalApplyRequest.approverMode(
                "1233",
                templateId,
                approver,
                controls,
                dataValues,
                summaryList
        );

        GenericResponse<String> apply = approvalApi.applyEvent(request);

        // 按照审批号查询详情
        GenericResponse<ApprovalDetail> approvalDetail = approvalApi.getApprovalDetail(new ApprovalSpNo(apply.getData()));
        System.out.println("approvalDetail = " + approvalDetail);

    }


    @Test
    void exUsers() {
//        84061
//        错误说明:
//        不存在外部联系人的关系
//        排查方法:
//        接口调用成功的必要条件是客户存在于服务人员的外部联系人好友列表中，有以下情况会导致报84061错误：
//        1) 如果客户删除了服务人员，此时是还存在单向好友关系，可以调用客户联系相关接口。反之，如果是服务人员删除了客户，则不再存在好友关系，无法调用接口。
//        2) 服务人员开启了免验证的情况下，客户可以跟服务人员进行会话，但是此时并没有真正添加为好友关系，需要服务人员添加好友后才可以调用接口。

        // 外部联系人相关API
        // 外部联系人应用  也可以使用拥有外部联系人能力的自建应用
        AgentDetails externalAgent = DefaultAgent.nativeAgent("你的企微企业ID", "应用密钥", NativeAgent.EXTERNAL);

        ExternalContactUserApi externalContactUserApi = workWeChatApi.externalContactManager(externalAgent).externalContactUserApi();

        // 同步助手应用  也可以使用拥有通讯录能力的自建应用
        AgentDetails contractAgent = DefaultAgent.nativeAgent("你的企微企业ID", "应用密钥", NativeAgent.CONTACT);
        // 通讯录相关API
        ContactBookManager contactBookManager = workWeChatApi.contactBookManager(contractAgent);
        // 企业成员相关API
        UserApi userApi = contactBookManager.userApi();
        Set<String> total = contactBookManager.departmentApi()
                // 获取所有部门
                .deptList()
                .getData()
                .parallelStream()
                // 查询部门拿到部门ID
                .map(DeptInfo::getId)
                // 根据部门ID 获取部门员工
                .map(userApi::getDeptUsers)
                .map(GenericResponse::getData)
                .flatMap(Collection::stream)
                //  获取部门员工ID
                .map(SimpleUser::getUserid)
                // 查询员工名下的外部联系人
                .map(userid -> {
                    try {
                        return externalContactUserApi.listByUserId(userid);
                    } catch (Exception e) {
                        // 非成功返回均会抛出WecomException异常
                        // TODO   84061 异常   自行处理逻辑
                        System.out.println("e = " + e.getMessage());
                        return null;
                    }
                })
                // 过滤空值
                .filter(Objects::nonNull)
                // 超展开
                .map(GenericResponse::getData)
                .flatMap(Collection::stream)
                // 这里只取100个  避免过大占用内存
                .limit(100)
                // 去重 得到去重外部联系人的ID集合
                .collect(Collectors.toSet());

        System.out.println("total = " + total);
    }
}
