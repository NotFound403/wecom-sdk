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
 * The enum Msg origin.
 *
 * @author n1
 * @since 2021 /6/16 14:39
 */
public enum KfMsgOrigin {

    /**
     * Wechat customer kf msg origin.
     */
    WECHAT_CUSTOMER(3),
    /**
     * System kf msg origin.
     */
    SYSTEM(4),
    /**
     * Work wechat servicer kf msg origin.
     */
    WORK_WECHAT_SERVICER(5);

    private final int origin;

    KfMsgOrigin(int origin) {
        this.origin = origin;
    }

    /**
     * Gets origin.
     *
     * @return the origin
     */
    @JsonValue
    public int getOrigin() {
        return origin;
    }

    /**
     * Deserialize range origin.
     *
     * @param origin the origin
     * @return the range origin
     */
    @JsonCreator
    public static KfMsgOrigin deserialize(int origin) {
        return Arrays.stream(KfMsgOrigin.values())
                .filter(kfMsgOrigin -> kfMsgOrigin.origin == origin)
                .findFirst()
                .orElse(null);
    }
}
