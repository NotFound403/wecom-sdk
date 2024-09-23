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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 添加客户的来源
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum AddWays {
    /**
     * 未知来源
     */
    UNKNOWN(0),
    /**
     * 扫描二维码
     */
    QR_CODE_SCANNED(1),
    /**
     * 搜索手机号.
     */
    MOBILE_SEARCHED(2),
    /**
     * 名片分享
     */
    BUSINESS_CARD_SHARED(3),
    /**
     * 群聊
     */
    GROUP_CHAT(4),
    /**
     * 手机通讯录
     */
    DIAL_BOOK(5),
    /**
     * 微信联系人
     */
    WECHAT_LIST(6),
    /**
     * 安装第三方应用时自动添加的客服人员.
     */
    VIA_CS_WHEN_APP_INSTALLING(8),
    /**
     * 搜索邮箱
     */
    EMAIL_SEARCH(9),
    /**
     * 视频号添加
     */
    WECHAT_CHANNEL(10),
    /**
     * 通过日程参与人添加
     */
    CALENDAR(11),
    /**
     * 通过会议参与人添加
     */
    MEETING(12),
    /**
     * 添加微信好友对应的企业微信
     */
    WORK_WECHAT_FRIEND(13),
    /**
     * 通过智慧硬件专属客服添加
     */
    SMART_CUSTOMER_SERVICE(14),
    /**
     * 通过上门服务客服添加
     */
    SITE_CUSTOMER_SERVICE(15),
    /**
     * 通过获客链接添加
     */
    CUSTOMER_ACQUISITION_LINK(16),
    /**
     * 通过定制开发添加
     *
     * @since 1.2.6
     */
    CUSTOMER_DEV(17),
    /**
     * 通过需求回复添加
     *
     * @since 1.2.6
     */
    REQ_REPLY(18),
    /**
     * 通过第三方服务售前客服添加
     *
     * @since 1.2.8
     */
    THIRD_PRE_SALES_SERVICER(21),
    /**
     * 通过接受微信账号收到的好友申请添加
     *
     * @since 1.2.8
     */
    WECHAT_FRIEND(24),
    /**
     * 内部成员共享
     */
    INTERNAL_SHARED(201),
    /**
     * 管理员/负责人分配
     */
    ALLOCATION(202);

    private final int type;

    AddWays(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize add ways.
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static AddWays deserialize(int type) {
        return Arrays.stream(AddWays.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
