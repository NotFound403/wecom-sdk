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
 * 筛选值判断操作类型
 *
 * @author dax
 * @since 2024 /9/2
 */
public enum FilterOperator {

    /**
     * 未知
     */
    OPERATOR_UNKNOWN,

    /**
     * 等于
     */
    OPERATOR_IS,

    /**
     * 不等于
     */
    OPERATOR_IS_NOT,

    /**
     * 包含
     */
    OPERATOR_CONTAINS,

    /**
     * 不包含
     */
    OPERATOR_DOES_NOT_CONTAIN,

    /**
     * 大于
     */
    OPERATOR_IS_GREATER,

    /**
     * 大于或等于
     */
    OPERATOR_IS_GREATER_OR_EQUAL,

    /**
     * 小于
     */
    OPERATOR_IS_LESS,

    /**
     * 小于或等于
     */
    OPERATOR_IS_LESS_OR_EQUAL,

    /**
     * 为空
     */
    OPERATOR_IS_EMPTY,
    /**
     * 不为空
     */
    OPERATOR_IS_NOT_EMPTY
}
