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
 * 卡券码型
 *
 * @author dax
 * @since 2024/8/18 15:05
 */
public enum CardCodeType {
    /**
     * 文本
     */
    CODE_TYPE_TEXT,
    /**
     * 一维码
     */
    CODE_TYPE_BARCODE,
    /**
     * 二维码
     */
    CODE_TYPE_QRCODE,
    /**
     * 二维码无code显示
     */
    CODE_TYPE_ONLY_QRCODE,
    /**
     * 一维码无code显示
     */
    CODE_TYPE_ONLY_BARCODE,
    /**
     * 不显示code和条形码类型
     */
    CODE_TYPE_NONE
}
