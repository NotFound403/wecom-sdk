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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 审批模板控件类型
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum ApprovalCtrlType {
    /**
     * 文本
     */
    TEXT("Text"),
    /**
     * 多行文本
     */
    TEXTAREA("Textarea"),
    /**
     * 数字
     */
    NUMBER("Number"),
    /**
     * 金额
     */
    MONEY("Money"),
    /**
     * 日期、日期+时间
     */
    DATE("Date"),
    /**
     * 单选、多选
     */
    SELECTOR("Selector"),
    /**
     * 成员、部门
     */
    CONTACT("Contact"),
    /**
     * 说明文字
     */
    TIPS("Tips"),
    /**
     * 附件
     */
    FILE("File"),
    /**
     * 明细
     */
    TABLE("Table"),
    /**
     * 假勤控件
     */
    ATTENDANCE("Attendance"),
    /**
     * 请假控件
     */
    VACATION("Vacation"),
    /**
     * 位置
     */
    LOCATION("Location"),
    /**
     * 关联审批单
     */
    RELATED_APPROVAL("RelatedApproval"),
    /**
     * 公式
     */
    FORMULA("Formula"),
    /**
     * 时长
     */
    DATE_RANGE("DateRange");

    private final String type;

    ApprovalCtrlType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }


    /**
     * Deserialize approval ctrl type.
     *
     * @param type the type
     * @return the approval ctrl type
     */
    @JsonCreator
    public static ApprovalCtrlType deserialize(String type) {
        return Arrays.stream(ApprovalCtrlType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
