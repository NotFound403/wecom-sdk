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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 卡券来源
 *
 * @author dax
 * @since 2024/8/5
 */
public enum CondSource {


    /**
     * 0为公众平台创建的卡券数据
     */
    MP(0),

    /**
     * 1是API创建的卡券数据
     */
    API(1);

    private final int type;

    CondSource(int type) {
        this.type = type;
    }

    /**
     * Deserialize CondSource.
     *
     * @param type the type
     * @return the contact type
     */
    @JsonCreator
    public static CondSource deserialize(int type) {
        return Arrays.stream(CondSource.values())
                .filter(countLimitType -> countLimitType.type == type)
                .findFirst()
                .orElse(null);
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

}
