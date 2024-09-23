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
 * The enum Sheet field type.
 *
 * @author dax
 * @since 2024 /9/4
 */
public enum SheetFieldType {

    /**
     * 文本
     */
    FIELD_TYPE_TEXT,
    /**
     * 数字
     */
    FIELD_TYPE_NUMBER,
    /**
     * 复选框
     */
    FIELD_TYPE_CHECKBOX,
    /**
     * 日期
     */
    FIELD_TYPE_DATE_TIME,
    /**
     * 图片
     */
    FIELD_TYPE_IMAGE,
    /**
     * 文件
     */
    FIELD_TYPE_ATTACHMENT,
    /**
     * 成员
     */
    FIELD_TYPE_USER,
    /**
     * 超链接
     */
    FIELD_TYPE_URL,
    /**
     * 多选
     */
    FIELD_TYPE_SELECT,
    /**
     * 创建人
     */
    FIELD_TYPE_CREATED_USER,
    /**
     * 最后编辑人
     */
    FIELD_TYPE_MODIFIED_USER,
    /**
     * 创建时间
     */
    FIELD_TYPE_CREATED_TIME,
    /**
     * 最后编辑时间
     */
    FIELD_TYPE_MODIFIED_TIME,
    /**
     * 进度
     */
    FIELD_TYPE_PROGRESS,
    /**
     * 电话
     */
    FIELD_TYPE_PHONE_NUMBER,
    /**
     * 邮件
     */
    FIELD_TYPE_EMAIL,
    /**
     * 单选
     */
    FIELD_TYPE_SINGLE_SELECT,
    /**
     * 关联
     */
    FIELD_TYPE_REFERENCE,
    /**
     * 地理位置
     */
    FIELD_TYPE_LOCATION,
    /**
     * 货币
     */
    FIELD_TYPE_CURRENCY,
    /**
     * 群
     */
    FIELD_TYPE_WWGROUP,
    /**
     * 自动编号
     */
    FIELD_TYPE_AUTONUMBER
}
