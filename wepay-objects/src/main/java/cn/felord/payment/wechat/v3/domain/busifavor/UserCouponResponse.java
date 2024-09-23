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

package cn.felord.payment.wechat.v3.domain.busifavor;

import cn.felord.payment.wechat.enumeration.CouponState;
import cn.felord.payment.wechat.enumeration.StockType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author dax
 * @since 2023/8/25
 */
@Data
public class UserCouponResponse {
    /**
     * 商家券批次名称,[1,21]
     */
    private String stockName;
    /**
     * 批次归属商户号
     */
    private String belongMerchant;
    /**
     * 批次备注,[1,20],选填
     */
    private String comment;
    /**
     * 适用商品范围
     * <p>
     * 用来描述批次在哪些商品可用，会显示在微信卡包中。字数上限为15个，一个中文汉字/英文字母/数字均占用一个字数。
     */
    private String goodsName;
    /**
     * 批次类型
     */
    private StockType stockType;
    /**
     * 核销规则
     */
    private CouponUseRule couponUseRule;
    /**
     * 自定义入口
     */
    private CustomEntrance customEntrance;
    /**
     * 样式信息
     */
    private DisplayPatternInfo displayPatternInfo;
    /**
     * 券的唯一标识
     */
    private String couponCode;
    /**
     * 商家券状态
     */
    private CouponState couponState;
    /**
     * 批次唯一标识
     */
    private String stockId;
    /**
     * 是否允许转赠
     */
    private Boolean transferable;
    /**
     * 是否允许分享领券链接
     */
    private Boolean shareable;
    /**
     * 发券请求单号
     * <p>
     * 发券时传入的唯一凭证
     */
    private String sendRequestNo;
    /**
     * 核销请求单号
     */
    private String useRequestNo;
    /**
     * 券可使用开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime availableStartTime;
    /**
     * 券过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime expireTime;
    /**
     * 券领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime receiveTime;

    /**
     * 券核销时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime useTime;
}
