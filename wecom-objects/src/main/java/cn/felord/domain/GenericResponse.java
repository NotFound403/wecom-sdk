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

package cn.felord.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 对于类似该结构的进行统一泛型封装
 *
 * @author n1
 * @since 2021/6/17 19:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GenericResponse<T> extends WeComResponse {
    @JsonAlias({"openid",
            "id",
            "button",
            "userid",
            "join_qrcode",
            "userlist",
            "user_info",
            "follow_user",
            "department_id",
            "department_list",
            "department",
            "active_cnt",
            "tagid",
            "taglist",
            "jobid",
            "ip_list",
            "external_userid",
            "contact_way",
            "strategy_id",
            "tag_group",
            "chat_id",
            "failed_chat_list",
            "join_way",
            "config_id",
            "group_chat",
            "template_id",
            "product_id",
            "rule_id",
            "rule_list",
            "rule",
            "url",
            "account_list",
            "msg_code",
            "open_kfid",
            "schedule_id",
            "cal_id",
            "formid",
            "form_info",
            "info",
            "data",
            "prepay_id",
            "pay_sign",
            "link",
            "results",
            "result",
            "share_url",
            "doc_base_info",
            "error_description",
            "open_wx_pay_media_id",
            "sp_no",
            "field_info",
            "group_list",
            "intent_id",
            "record",
            "device_list",
            "external_userid_info",
            "pending_id",
            "chains",
            "groups",
            "user_custom_id",
            "rule_ids",
            "rule_info",
            "livingid",
            "living_code",
            "living_info",
            "meetingroom_id",
            "ids",
            "view",
            "fields",
            "records",
            "agreeinfo",
            "properties",
            "lists"
    })
    private T data;
}
