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
 * 日期值类型
 *
 * @author dax
 * @since 2024 /9/2
 */
public enum FilterDateTimeType {

    /**
     * 具体时间
     */
    DATE_TIME_TYPE_DETAIL_DATE,
    /**
     * 具体时间范围
     */
    DATE_TIME_TYPE_DETAIL_DATE_RANGE,
    /**
     * 今天
     */
    DATE_TIME_TYPE_TODAY,
    /**
     * 明天
     */
    DATE_TIME_TYPE_TOMORROW,
    /**
     * 昨天
     */
    DATE_TIME_TYPE_YESTERDAY,
    /**
     * 本周
     */
    DATE_TIME_TYPE_CURRENT_WEEK,
    /**
     * 上周
     */
    DATE_TIME_TYPE_LAST_WEEK,
    /**
     * 本月
     */
    DATE_TIME_TYPE_CURRENT_MONTH,
    /**
     * 过去 7 天内
     */
    DATE_TIME_TYPE_THE_PAST_7_DAYS,
    /**
     * 接下来 7 天内
     */
    DATE_TIME_TYPE_THE_NEXT_7_DAYS,
    /**
     * 上月
     */
    DATE_TIME_TYPE_LAST_MONTH,
    /**
     * 过去 30 天内
     */
    DATE_TIME_TYPE_THE_PAST_30_DAYS,
    /**
     * 接下来 30 天内
     */
    DATE_TIME_TYPE_THE_NEXT_30_DAYS
}
