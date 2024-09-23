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

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * 卡片来源样式信息
 *
 * @author felord.cn
 * @since 2021/9/3 14:27
 */
@Data
public class CardSource {
    private String iconUrl;
    private String desc;
    private DescColor descColor;

    /**
     * 来源文字颜色
     */
    public enum DescColor {
        /**
         * Grey.
         */
        GREY(0),
        /**
         * Black.
         */
        BLACK(1),
        /**
         * Red.
         */
        RED(2),
        /**
         * Green.
         */
        GREEN(3);

        private final int color;

        DescColor(int color) {
            this.color = color;
        }

        /**
         * Gets color.
         *
         * @return the color
         */
        @JsonValue
        public int getColor() {
            return color;
        }
    }
}
