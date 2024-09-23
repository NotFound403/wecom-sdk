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
 * 直播的类型
 *
 * @author felord.cn
 * @since 1.1.3
 */
public enum LivingType {

    /**
     * 通用直播
     */
    GENERAL(0),
    /**
     * 小班课
     */
    SMALL(1),
    /**
     * 大班课
     */
    LARGE(2),
    /**
     * 企业培训
     */
    CORP_TRAINING(3),
    /**
     * 活动直播
     */
    LIVE_STREAMING(4);

    private final int type;

    LivingType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize business type.
     *
     * @param type the type
     * @return the business type
     */
    @JsonCreator
    public static LivingType deserialize(int type) {
        return Arrays.stream(LivingType.values())
                .filter(businessType -> businessType.type == type)
                .findFirst()
                .orElse(null);
    }
}
