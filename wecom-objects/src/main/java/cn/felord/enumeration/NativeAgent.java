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

package cn.felord.enumeration;

/**
 * 企微内置应用
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
    EXTERNAL("2000003", "外部联系人"),
    /**
     * 会话内容存档
     */
    MSG_AUDIT("2000004", "外部联系人"),
    /**
     * 公告
     */
    ANNOUNCEMENT("3010001", "公告"),
    /**
     * 公费电话
     */
    TELEPHONE("3010007", "公费电话"),
    /**
     * 打卡
     */
    ATTENDANCE("3010011", "打卡"),
    /**
     * 审批
     */
    APPROVAL("3010040", "审批"),
    /**
     * 汇报
     */
    WORKNOTE("3010041", "汇报"),
    /**
     * 企业支付
     */
    PAY("3010046", "企业支付"),
    /**
     * 日程
     */
    SCHEDULE("3010084", "日程"),
    /**
     * 健康上报
     */
    HEALTH_REPORT("3010094", "健康上报"),
    /**
     * 直播
     */
    CORP_LIVE("3010097", "直播"),
    /**
     * 对外收款
     */
    CORP_COLLECT_BILL("3010115", "对外收款"),
    /**
     * 会议室
     */
    MEETING_ROOM("3010116", "会议室"),
    /**
     * 微信客服
     */
    SERVICER("3010151", "微信客服"),
    /**
     * 上下游
     */
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
