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

package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:08
 */
@Getter
public class AppImageTextArea extends ImageTextArea {
    private final String appid;
    private final String pagepath;

    public AppImageTextArea(String imageUrl, String appid, String pagepath) {
        super(ClickEventType.MINIPROGRAM, imageUrl);
        this.appid = appid;
        this.pagepath = pagepath;
    }
}
