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

import cn.felord.payment.wechat.enumeration.CouponBgColor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 商家券样式信息.
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class DisplayPatternInfo {

    /**
     * 背景颜色
     */
    private CouponBgColor backgroundColor;
    /**
     * 商户logo
     * <ol>
     *     <li>商户logo大小需为120像素*120像素</li>
     *     <li>支持JPG、JPEG、PNG格式，且图片小于1M</li>
     * </ol>
     * 仅支持通过 <a target= "_blank" href= "https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/chapter3_1.shtml">图片上传API</a> 接口获取的图片URL地址。
     */
    private String merchantLogoUrl;
    /**
     * 券详情图片
     * <ol>
     *     <li>需为850像素*350像素</li>
     *     <li>图片大小不超过2M</li>
     *     <li>支持JPG/PNG格式</li>
     * </ol>
     * 仅支持通过 <a target= "_blank" href= "https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/chapter3_1.shtml">图片上传API</a> 接口获取的图片URL地址。
     */
    private String couponImageUrl;
    /**
     * 使用须知
     * <p>
     * 用于说明详细的活动规则，会展示在代金券详情页。
     * <p>
     * 示例值：xxx门店可用
     */
    private String description;
    /**
     * 商户名称,字数上限为16个
     */
    private String merchantName;
    /**
     * 视频号信息
     */
    private WechatChannelInfo finderInfo;


    /**
     * Instantiates a new Display pattern info.
     *
     * @param backgroundColor the background color
     * @param merchantLogoUrl the merchant logo url
     * @param couponImageUrl  the coupon image url
     * @param description     the description
     * @param merchantName    the merchant name
     * @param finderInfo      the finder info
     */
    @JsonCreator
    DisplayPatternInfo(@JsonProperty("background_color") CouponBgColor backgroundColor,
                       @JsonProperty("merchant_logo_url") String merchantLogoUrl,
                       @JsonProperty("coupon_image_url") String couponImageUrl,
                       @JsonProperty("DESCRIPTION") String description,
                       @JsonProperty("merchant_name") String merchantName,
                       @JsonProperty("finder_info") WechatChannelInfo finderInfo) {
        this.backgroundColor = backgroundColor;
        this.merchantLogoUrl = merchantLogoUrl;
        this.couponImageUrl = couponImageUrl;
        this.description = description;
        this.merchantName = merchantName;
        this.finderInfo = finderInfo;
    }

    /**
     * Background color display pattern info.
     *
     * @param backgroundColor the background color
     * @return the display pattern info
     */
    public DisplayPatternInfo backgroundColor(CouponBgColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Merchant logo url display pattern info.
     *
     * @param merchantLogoUrl the merchant logo url
     * @return the display pattern info
     */
    public DisplayPatternInfo merchantLogoUrl(String merchantLogoUrl) {
        this.merchantLogoUrl = merchantLogoUrl;
        return this;
    }

    /**
     * Coupon image url display pattern info.
     *
     * @param couponImageUrl the coupon image url
     * @return the display pattern info
     */
    public DisplayPatternInfo couponImageUrl(String couponImageUrl) {
        this.couponImageUrl = couponImageUrl;
        return this;
    }

    /**
     * Description display pattern info.
     *
     * @param description the description
     * @return the display pattern info
     */
    public DisplayPatternInfo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Merchant name display pattern info.
     *
     * @param merchantName the merchant name
     * @return the display pattern info
     */
    public DisplayPatternInfo merchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    /**
     * Finder info display pattern info.
     *
     * @param finderInfo the finder info
     * @return the display pattern info
     */
    public DisplayPatternInfo finderInfo(WechatChannelInfo finderInfo) {
        this.finderInfo = finderInfo;
        return this;
    }
}
