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
package cn.felord.payment.wechat.enumeration;

/**
 * code展示模式
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
public enum BusiFavorCodeDisplayMode {
    /**
     * 不展示code
     */
    NOT_SHOW,
    /**
     * 一维码（条形码）
     */
    BARCODE,
    /**
     * 二维码
     */
    QRCODE
}
