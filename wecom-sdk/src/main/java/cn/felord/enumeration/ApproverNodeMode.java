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

package cn.felord.enumeration;

import cn.felord.callbacks.CallbackNumberEnum;
import cn.felord.callbacks.NumberEnumConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
@XStreamConverter(NumberEnumConverter.class)
public enum ApproverNodeMode implements CallbackNumberEnum {
    OR(1),
    ALL(2);

    private final int mode;

    ApproverNodeMode(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getType() {
        return mode;
    }

    @JsonCreator
    public static ApproverNodeMode deserialize(int mode) {
        return Arrays.stream(ApproverNodeMode.values())
                .filter(contactType -> contactType.mode == mode)
                .findFirst()
                .orElse(null);
    }

}
