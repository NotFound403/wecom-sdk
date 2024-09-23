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

package cn.felord.mp.enumeration;

/**
 * The enum Date info type.
 *
 * @author dax
 * @since 2024/8/18 18:05
 */
public enum DateInfoType {
    /**
     * 永久有效类型
     */
    DATE_TYPE_PERMANENT,
    /**
     * 固定时间范围
     */
    DATE_TYPE_FIX_TIME_RANGE,
    /**
     * 固定期限范围
     */
    DATE_TYPE_FIX_TERM_RANGE,
    /**
     * 固定期限
     */
    DATE_TYPE_FIX_TERM
}
