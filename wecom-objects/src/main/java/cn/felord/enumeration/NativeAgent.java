/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.enumeration;

/**
 * 企微内置应用
 * <p>
 * 企业管理后台API设置中，新增「可调用接口的应用」设置项，经企业设置的自建应用可调用对应基础应用和功能的接口。
 * <p>
 * 自建应用需先设置可信IP才可成功设置为可调用接口的应用，2023年12月1日0点前已设置的未配置可信IP的自建应用暂不受影响
 * <p>
 * 目前除通讯录同步助手之外已经过时，基础应用的id已经不对外暴露
 *
 * @author dax
 * @since 2021 /12/9 14:12
 */
public enum NativeAgent {
    /**
     * 通讯录同步助手
     */
    CONTACT("2000002", "通讯录同步助手"),
    /**
     * 外部联系人
     */
    @Deprecated
    EXTERNAL("2000003", "外部联系人"),
    /**
     * 会话内容存档
     */
    @Deprecated
    MSG_AUDIT("2000004", "会话内容存档"),
    /**
     * 公告
     */
    @Deprecated
    ANNOUNCEMENT("3010001", "公告"),
    /**
     * 公费电话
     */
    @Deprecated
    TELEPHONE("3010007", "公费电话"),
    /**
     * 打卡
     */
    @Deprecated
    ATTENDANCE("3010011", "打卡"),
    /**
     * 审批
     */
    @Deprecated
    APPROVAL("3010040", "审批"),
    /**
     * 汇报
     */
    @Deprecated
    WORKNOTE("3010041", "汇报"),
    /**
     * 企业支付
     */
    @Deprecated
    PAY("3010046", "企业支付"),
    /**
     * 日程
     * <p>
     *
     * @deprecated 日程的secret已经不对外暴漏
     */
    @Deprecated
    SCHEDULE("3010084", "日程"),
    /**
     * 人事助手
     *
     * @since 1.1.6
     */
    @Deprecated
    STAFF_MANAGER("3010185", "人事助手"),
    /**
     * 健康上报
     */
    @Deprecated
    HEALTH_REPORT("3010094", "健康上报"),
    /**
     * 直播
     */
    @Deprecated
    CORP_LIVE("3010097", "直播"),
    /**
     * 对外收款
     */
    @Deprecated
    CORP_COLLECT_BILL("3010115", "对外收款"),
    /**
     * 会议室
     */
    @Deprecated
    MEETING_ROOM("3010116", "会议室"),
    /**
     * 微信客服
     */
    @Deprecated
    SERVICER("3010151", "微信客服"),
    /**
     * 上下游
     */
    @Deprecated
    CORP_CHAIN("3010168", "上下游");

    private final String agentId;
    private final String name;

    NativeAgent(String agentId, String name) {
        this.agentId = agentId;
        this.name = name;
    }

    /**
     * Gets agent id.
     *
     * @return the agent id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
