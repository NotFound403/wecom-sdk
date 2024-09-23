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
 * 会员信息类目半自定义名称，
 * 当开发者变更这类类目信息的value值时，可以选择触发系统模板消息通知用户
 *
 * @author dax
 * @since 2024/8/18 16:42
 */
public enum MemberCardFieldType {

    /**
     * 等级
     */
    FIELD_NAME_TYPE_LEVEL,
    /**
     * 优惠券
     */
    FIELD_NAME_TYPE_COUPON,
    /**
     * 印花
     */
    FIELD_NAME_TYPE_STAMP,
    /**
     * 折扣
     */
    FIELD_NAME_TYPE_DISCOUNT,
    /**
     * 里程
     */
    FIELD_NAME_TYPE_MILEAGE,
    /**
     * 集点
     */
    FIELD_NAME_TYPE_SET_POINTS,
    /**
     * 次数
     */
    FIELD_NAME_TYPE_TIMS
}
