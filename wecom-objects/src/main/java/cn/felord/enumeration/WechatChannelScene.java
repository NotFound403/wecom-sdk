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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Add ways.
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum WechatChannelScene {

    /**
     * 视频号主页
     */
    HOME_PAGE(1),

    /**
     * 视频号直播间商品列表页
     */
    LIVE_ROOM_PRODUCTS_PAGE(2),

    /**
     * 视频号商品橱窗页
     */
    PRODUCT_SHOWCASE_PAGE(3),
    /**
     * 视频号小店商品详情页
     */
    SHOP_PRODUCT_DETAIL_PAGE(4),
    /**
     * 视频号小店订单页
     */
    SHOP_ORDER_PAGE(5);

    private final int scene;

    WechatChannelScene(int scene) {
        this.scene = scene;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getScene() {
        return scene;
    }

    /**
     * Deserialize add ways.
     *
     * @param scene the scene
     * @return the add ways
     */
    @JsonCreator
    public static WechatChannelScene deserialize(int scene) {
        return Arrays.stream(WechatChannelScene.values())
                .filter(channelScene -> channelScene.scene == scene)
                .findFirst()
                .orElse(null);
    }
}
