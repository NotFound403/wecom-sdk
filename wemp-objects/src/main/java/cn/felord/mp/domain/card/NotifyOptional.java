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

package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 控制原生消息结构体，包含各字段的消息控制字段
 *
 * @author dax
 * @since 2024/8/18 11:15
 */
@Data
public class NotifyOptional {
    /**
     * 积分变动时是否触发系统模板消息，默认为true
     */
    private Boolean isNotifyBonus;
    /**
     * 余额变动时是否触发系统模板消息，默认为true
     */
    private Boolean isNotifyBalance;
    /**
     * 自定义group1变动时是否触发系统模板消息，默认为false。
     */
    private Boolean isNotifyCustomField1;
    /**
     * 自定义group2变动时是否触发系统模板消息，默认为false。
     */
    private Boolean isNotifyCustomField2;
    /**
     * 自定义group3变动时是否触发系统模板消息，默认为false。
     */
    private Boolean isNotifyCustomField3;

    /**
     * Notify bonus notify optional.
     *
     * @param isNotifyBonus the is notify bonus
     * @return the notify optional
     */
    public NotifyOptional notifyBonus(boolean isNotifyBonus) {
        this.isNotifyBonus = isNotifyBonus;
        return this;
    }

    /**
     * Notify balance notify optional.
     *
     * @param isNotifyBalance the is notify balance
     * @return the notify optional
     */
    public NotifyOptional notifyBalance(boolean isNotifyBalance) {
        this.isNotifyBalance = isNotifyBalance;
        return this;
    }

    /**
     * Notify custom field 1 notify optional.
     *
     * @param isNotifyCustomField1 the is notify custom field 1
     * @return the notify optional
     */
    public NotifyOptional notifyCustomField1(boolean isNotifyCustomField1) {
        this.isNotifyCustomField1 = isNotifyCustomField1;
        return this;
    }

    /**
     * Notify custom field 2 notify optional.
     *
     * @param isNotifyCustomField2 the is notify custom field 2
     * @return the notify optional
     */
    public NotifyOptional notifyCustomField2(boolean isNotifyCustomField2) {
        this.isNotifyCustomField2 = isNotifyCustomField2;
        return this;
    }

    /**
     * Notify custom field 3 notify optional.
     *
     * @param isNotifyCustomField3 the is notify custom field 3
     * @return the notify optional
     */
    public NotifyOptional notifyCustomField3(boolean isNotifyCustomField3) {
        this.isNotifyCustomField3 = isNotifyCustomField3;
        return this;
    }
}
