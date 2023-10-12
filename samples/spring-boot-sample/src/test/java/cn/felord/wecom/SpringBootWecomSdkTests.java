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
import cn.felord.api.CallCenterManager;
import cn.felord.api.ContactBookManager;
import cn.felord.api.ExternalContactUserApi;
import cn.felord.api.FileManagerApi;
import cn.felord.api.FormApi;
import cn.felord.api.KfAccountApi;
import cn.felord.api.KfSessionApi;
import cn.felord.api.MediaApi;
import cn.felord.api.ScheduleApi;
import cn.felord.api.UserApi;
import cn.felord.api.WorkWeChatApi;
import cn.felord.callback.CallbackSettings;
import cn.felord.callbacks.CallbackCrypto;
import cn.felord.callbacks.CallbackCryptoBuilder;
import cn.felord.callbacks.CallbackEventBody;
import cn.felord.callbacks.CallbackXmlBody;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.MultipartResource;
import cn.felord.domain.WeComResponse;
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
import cn.felord.domain.callcenter.ClickMsgMenuContent;
import cn.felord.domain.callcenter.EnterSessionKfEvent;
import cn.felord.domain.callcenter.EventKfMessage;
import cn.felord.domain.callcenter.ImageKfMessageRequest;
import cn.felord.domain.callcenter.KfAccountAddRequest;
import cn.felord.domain.callcenter.KfMessage;
import cn.felord.domain.callcenter.KfMsgMenu;
import cn.felord.domain.callcenter.MenuKfEventMessageRequest;
import cn.felord.domain.callcenter.SyncMsgRequest;
import cn.felord.domain.callcenter.SyncMsgResponse;
import cn.felord.domain.callcenter.TextMsgMenuContent;
import cn.felord.domain.callcenter.ViewMsgMenuContent;
import cn.felord.domain.common.TemplateId;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.user.SimpleUser;
import cn.felord.domain.externalcontact.MiniprogramMsgAttachment;
import cn.felord.domain.externalcontact.MsgTemplateRequest;
import cn.felord.domain.externalcontact.MsgTemplateResponse;
import cn.felord.domain.media.MediaResponse;
import cn.felord.domain.message.MessageBodyBuilders;
import cn.felord.domain.message.MessageResponse;
import cn.felord.domain.message.TemplateCardBuilders;
import cn.felord.domain.message.TemplateCardMessageBody;
import cn.felord.domain.message.TextMessageTemplateCard;
import cn.felord.domain.oa.Reminders;
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.domain.oa.ScheduleRequestBody;
import cn.felord.domain.webhook.WebhookArticle;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.domain.webhook.WebhookImageBody;
import cn.felord.domain.webhook.WebhookMarkdownBody;
import cn.felord.domain.webhook.WebhookNewsBody;
import cn.felord.domain.webhook.WebhookTextBody;
import cn.felord.domain.webhook.card.AtStaffHorizontalContent;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.TextHorizontalContent;
import cn.felord.domain.webhook.card.UrlCardAction;
import cn.felord.domain.webhook.card.UrlJump;
import cn.felord.domain.wedoc.form.AnswerReplyItem;
import cn.felord.domain.wedoc.form.FormAnswerRequest;
import cn.felord.domain.wedrive.BufferSource;
import cn.felord.enumeration.AnswerReplyItemType;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.DateRangeType;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.enumeration.NativeAgent;
import cn.felord.enumeration.RemindBeforeEventSecs;
import cn.felord.xml.XStreamXmlReader;
import okhttp3.MediaType;
import okio.BufferedSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     *
     * @throws IOException the io exception
     */
    @Test
    void webHooks() throws IOException {
// 发 markdown
        WebhookBody markdownBody = WebhookMarkdownBody.from("这里为markdown消息");
// 发纯文本
        WebhookBody textBody = WebhookTextBody.from("这里为纯文本");
// 发图文
        WebhookArticle article = new WebhookArticle("这里为标题", "这里为图文链接")
                .picurl("这里为封面图链接")
                .description("这里为摘要信息");
        WebhookBody newsBody = WebhookNewsBody.from(Collections.singletonList(article));
//  从base64发图片
        String base64 = "图片base64";
        String md5 = "图片base64的md5";
        WebhookBody imageBody1 = WebhookImageBody.from(base64, md5);
//  从流发送图片
        String path = "C:\\Users\\Administrator\\Desktop\\0.png";
        InputStream inputStream = Files.newInputStream(Paths.get(path));
        WebhookBody imageBody2 = WebhookImageBody.from(inputStream);
        WeComResponse weComResponse = WorkWeChatApi.webhookApi().send("机器人key", markdownBody);
        Assertions.assertTrue(weComResponse.isSuccessful());
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
     * 客户群发和客户群群发
     * <p>
     * 给微信客户推送小程序促销消息
     */
    @Test
    void sendToUsers() {

        // 引导文案 要尽量吸引眼球
        String context = "🎉🎉🎉10元生鲜拼团最后一天\n" +
                "👉现在下单，福利多多，有几率获得以下礼品一份\n" +
                "🎁新鲜小台芒一斤\n" +
                "🎁西红柿一斤\n" +
                "快来点击小程序拼团吧😀";

        // 标题长度 64
        String title = "企微客户生鲜福利最后一天啦";
        // 小程序appid
        String appid = "xxxxxxxxxxxxxxxx";
        // 临时素材上传
        String picMeidaId = "3UF5V8DXrsjsSsvDE9HXDGcxoHZ78MPX-mS6aAaASPew7cgPGXtWcarAdWDdu0NRf";

        // 小程序活动页面
        String page = "store/pages/hots/detail.html?sku=xd233243&state=QWPT2342";
        MiniprogramMsgAttachment o = new MiniprogramMsgAttachment(title, appid, picMeidaId, page);

        MsgTemplateRequest request = MsgTemplateRequest.single("员工企微id", context, Collections.singletonList(o));

        AgentDetails nativedAgent = DefaultAgent.nativeAgent("企业id", "外部联系人密钥", NativeAgent.EXTERNAL);
        MsgTemplateResponse msgTemplateResponse = workWeChatApi.externalContactManager(nativedAgent)
                .messageApi()
                .addMsgTemplate(request);
        Assertions.assertTrue(msgTemplateResponse.isSuccessful());
    }

    /**
     * 企业微信创建日程
     */
    @Test
    void schedule() {

        AgentDetails agentDetails = new DefaultAgent("企业ID", "应用密钥，该应用需要关联到日程功能", "应用id");

        Instant now = Instant.now();
        Instant startTime = now.plus(10, ChronoUnit.MINUTES);
        Instant endTime = now.plus(40, ChronoUnit.MINUTES);
        ScheduleRequestBody schedule = new ScheduleRequestBody(startTime, endTime)
                .summary("wecom-sdk 项目需求评审")
                .description("对下半年新需求的评审研讨")
                .location("xxx市xxx区xxx路28号A座703")
                .attendees(Arrays.asList("参与人1 USERID", "参与人2 USERID", "参与人3 USERID"))
                .reminders(new Reminders()
                        .remind(RemindBeforeEventSecs.MIN_5)
                        .timezone(8));
        ScheduleAddRequest request = new ScheduleAddRequest(schedule);

        ScheduleApi scheduleApi = workWeChatApi.scheduleApi(agentDetails);

        GenericResponse<String> genericResponse = scheduleApi.add(request);
        Assertions.assertTrue(genericResponse.isSuccessful());
    }

    /**
     * 企微客服
     */
    @Test
    public void kf() {
        AgentDetails testKf = DefaultAgent.nativeAgent("企业ID", "客服应用密钥", NativeAgent.SERVICER);

        CallCenterManager callCenterManager = workWeChatApi.callCenterManager(testKf);
//        客服账号
        KfAccountApi kfAccountApi = callCenterManager
                .kfAccountApi();
        KfAccountAddRequest accountAddRequest = new KfAccountAddRequest("测试客服", "客服应用调用上传图片API上传头像");
//        API创建客服账号
//        GenericResponse<String> response = kfAccountApi.addKfAccount(accountAddRequest);
//        String openKfid = response.getData();
//        创建客服场景链接   带场景值
//        KfAccountLinkRequest accountLinkRequest = new KfAccountLinkRequest(openKfid, "ABC");
//        GenericResponse<String> genericResponse = kfAccountApi.addContactWay(accountLinkRequest
//        客服链接  可以拼接自定义参数 具体看文档
//        String kfUrl = genericResponse.getData();

//        客服会话
        KfSessionApi kfSessionApi = callCenterManager.kfSessionApi();
//        同步消息 用上面的客服链接 测试    注意配置接待人员
        SyncMsgRequest request = new SyncMsgRequest();
//        token 获取参见企微文档
        request.setToken("ENC2cGwv5Ey4XSeotohu7Ad5W3MmscXKEfQfi5qgkuMVMyP");
        request.setOpenKfid("传入openKfid");
        SyncMsgResponse syncMsgResponse = kfSessionApi.syncMsg(request);
        List<KfMessage> msgList = syncMsgResponse.getMsgList();
//        取最新的一条  这里的机制我没有深入
        EventKfMessage kfMessage = (EventKfMessage) msgList.get(msgList.size() - 1);
        EnterSessionKfEvent event = (EnterSessionKfEvent) kfMessage.getEvent();
//        获取欢迎码  有效期很短
        String welcomeCode = event.getWelcomeCode();

//        发送事件消息 发送欢迎语 带菜单 带链接 纯文本  具体机制都需要结合文档对接
        KfMsgMenu msgmenu = new KfMsgMenu()
                .headContent("您对本次服务是否满意呢? ")
                .list(Arrays.asList(new ClickMsgMenuContent("1", "满意"),
                        new ClickMsgMenuContent("2", "不满意"),
                        new ViewMsgMenuContent("https://baidu.com", "点击自助查询"),
                        new TextMsgMenuContent("纯文本")
                ))
                .tailContent("结束语");


        MenuKfEventMessageRequest eventMessageRequest = new MenuKfEventMessageRequest(welcomeCode, msgmenu);
//        发送事件消息
        GenericResponse<String> stringGenericResponse = kfSessionApi.sendEventMsg(eventMessageRequest);

//        发送图片消息给接待用户  需要在智能助手接待状态  对接GPT之类的大模型非常有用
        ImageKfMessageRequest kfMessageRequest = new ImageKfMessageRequest("客户id", "客服id", "图片素材 mediaid");
    }

    /**
     * 企业微信发起审批
     */
    @Test
    void approval() {
        // 审批应用
        AgentDetails nativeAgent = DefaultAgent.nativeAgent("企业ID", "审批应用密钥", NativeAgent.APPROVAL);
        ApprovalApi approvalApi = workWeChatApi.approvalApi(nativeAgent);
        // 模板
        String templateId = "C4UEh71DAPh775HPfXipikZ5eAGosskDibU8hkfxJ";
        // 查询模板配置  可以用缓存优化性能 避免直接查询企业微信
        ApprovalTmpDetailResponse templateDetail = approvalApi.getTemplateDetail(new TemplateId(templateId));
        Assertions.assertTrue(templateDetail.isSuccessful());
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
        Assertions.assertTrue(approvalDetail.isSuccessful());

    }

    /**
     * 收集表难点演示
     * <p>
     * 下载收集表中的文件素材
     *
     * @throws IOException the io exception
     */
    @Test
    public void formFiledownload() throws IOException {
//           关联文档功能的自建引用
        AgentDetails agentDetailsWithDocAuth = new DefaultAgent("企业ID", "应用密钥，该应用需要关联到文档功能", "应用id");
        FormApi formApi = workWeChatApi.wedocApi(agentDetailsWithDocAuth).formApi();
//             关联微盘功能的自建应用
        AgentDetails agentDetailsWithWeDriveAuth = new DefaultAgent("企业ID", "应用密钥，该应用需要关联到微盘功能", "应用id");
        FileManagerApi fileManagerApi = workWeChatApi.weDriveApi(agentDetailsWithWeDriveAuth).fileManagerApi();
//       收集表的周期id，用于获取答案列表和具体的回答
        String repeatedId = "";
//         答案id
        long answerId = 1L;
        FormAnswerRequest answerRequest = new FormAnswerRequest(repeatedId, Collections.singleton(answerId));

        BufferSource bufferSource = formApi.getFormAnswer(answerRequest)
                .getAnswer()
                .getAnswerList()
//                可能有多个 这里只取一个
                .get(0)
                .getReply()
                .getItems()
                .stream()
                .filter(answerReplyItem ->
                        Objects.equals(answerReplyItem.getItemType(), AnswerReplyItemType.FILE))
                .map(AnswerReplyItem::getFileExtendReply)
                .flatMap(Collection::stream)
//                可能有多个 这里只取一个
                .findFirst()
                .map(answerFileExtendReply ->
//                        answerFileExtendReply.getName()  文件名称 带扩展名
                        fileManagerApi.downloadByFileId(answerFileExtendReply.getFileid()))
                .orElseThrow(() -> new RuntimeException("调用表单查询异常"));
//        文件答案都会带文件名
//        String filename = answerFileExtendReply.getName();
        BufferedSource source = bufferSource.getSource();
        MediaType contentType = bufferSource.getContentType();
        long contentLength = bufferSource.getContentLength();
        byte[] bytes = FileCopyUtils.copyToByteArray(source.inputStream());
    }

    /**
     * 上传临时素材
     * <p>
     * 其它上传类似
     *
     * @throws IOException the io exception
     */
    @Test
    void uploadMedia() throws IOException {

        AgentDetails agentDetails = new DefaultAgent("企业ID", "应用密钥", "应用id");
        MediaApi mediaApi = workWeChatApi.mediaApi(agentDetails);
        InputStream inputStream = Files.newInputStream(Paths.get("C:\\Users\\Administrator\\Pictures\\wecom.png"));
        MultipartResource resource = new MultipartResource("wecom.png", inputStream);
        MediaResponse mediaResponse = mediaApi.uploadMedia(MediaTypeEnum.IMAGE, resource);
        Assertions.assertTrue(mediaResponse.isSuccessful());
    }

    /**
     * 外部联系人API相关演示
     */
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

        Assertions.assertFalse(total.isEmpty());
    }


    /**
     * 通常情况下不需要知道如何解密回调，除非你遇到了一些异常情况
     * <p>
     * 实际运用请参考{@link cn.felord.wecom.api.CallbackController}
     */
    @Test
    void callback() {
        // 自己去日志里抓回调xml
        String xml = "<xml>\n" +
                "    <ToUserName><![CDATA[这里一般是企业ID，也不一定⚠️⚠️⚠️⚠️]]></ToUserName>\n" +
                "    <Encrypt>\n" +
                "        <![CDATA[这里是响应体的加密信息，需要解密👀]]></Encrypt>\n" +
                "    <AgentID><![CDATA[这里一般是应用ID 但是有的会返回0或者空⚠️⚠️⚠️⚠️]]></AgentID>\n" +
                "</xml>";
        XStreamXmlReader xStreamXmlReader = XStreamXmlReader.INSTANCE;
        CallbackXmlBody xmlBody = xStreamXmlReader.read(xml, CallbackXmlBody.class);
        System.out.println("xmlBody = " + xmlBody);
        String corpId = "企业ID，建议携带在回调url路径中";
        String agentId = "应用ID，建议携带在回调url路径中";
        // 签名 时间戳  nonce 是一套 自己去日志里抓
        String msgSignature = "0011440776ad38f2e032f517d715bd2d041e8cc5";
        // 自己去日志里抓
        String timeStamp = "1692174444";
        // 自己去日志里抓
        String nonce = "1691813434";
        // 构建回调处理对象
        CallbackCrypto callbackCrypto = new CallbackCryptoBuilder(System.out::println)
                .build((agentid, corpid) ->
                        new CallbackSettings("企业微信管理后台回调中的token",
                                "企业微信管理后台回调中的encodingAesKey",
                                "企业ID，自建应用会校验"));
        // 解密xml密文
        String xmlbody = callbackCrypto.decryptMsg(agentId,
                corpId,
                msgSignature,
                timeStamp, nonce, xmlBody.getEncrypt());
        System.out.println("xmlbody = " + xmlbody);
        // 转换为事件对象消费
        CallbackEventBody eventBody = xStreamXmlReader.read(xmlbody, CallbackEventBody.class);
        System.out.println("eventBody = " + eventBody);
    }

}
