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

package cn.felord.mp.domain.card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * 推荐内容结构体
 */
@ToString
@RequiredArgsConstructor
@Getter
public class UrlCell {
    /**
     * 送券的card_id列表，不支持普通券和朋友的券混合使用，最多填写10个card_id
     */
    private List<String> cardIdList;
    /**
     * 推荐位展示的截止时间
     */
    private Instant endTime;
    /**
     * 文本内容
     */
    private String text;
    /**
     * 跳转链接，
     * 与card_id_list互斥，若设置了跳转url，用户点击模板消息详情后将跳转至该链接领券
     */
    private String url;
    /**
     * 跳转链接对应的小程序appid，
     * 与card_id_list互斥，若设置了，用户点击模板消息详情后将跳转至该小程序领券
     */
    private String appBrandId;
    /**
     * 跳转链接对应的小程序路径，
     * 与card_id_list互斥，若设置了，用户点击模板消息详情后将跳转至该小程序领券
     */
    private String appBrandPass;

    public UrlCell setCardIdList(List<String> cardIdList) {
        this.cardIdList = cardIdList;
        return this;
    }

    /**
     * End time url cell.
     *
     * @param endTime the end time
     * @return the url cell
     */
    public UrlCell endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Text url cell.
     *
     * @param text the text
     * @return the url cell
     */
    public UrlCell text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Url url cell.
     *
     * @param url the url
     * @return the url cell
     */
    public UrlCell url(String url) {
        this.url = url;
        this.appBrandId = null;
        this.appBrandPass = null;
        return this;
    }

    /**
     * App brand id url cell.
     *
     * @param appBrandId   the app brand id
     * @param appBrandPass the app brand pass
     * @return the url cell
     */
    public UrlCell appBrand(String appBrandId, String appBrandPass) {
        this.appBrandId = appBrandId;
        this.appBrandPass = appBrandPass;
        this.url = null;
        return this;
    }

}