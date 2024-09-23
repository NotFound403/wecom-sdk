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

package cn.felord.domain.approval;

import cn.felord.enumeration.SelectType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Selector config.
 *
 * @author dax
 * @since 2024/5/25 16:22
 */
@ToString
@Getter
public class SelectorValue implements ContentDataValue {
    private final Wrapper selector;

    /**
     * Instantiates a new Selector config.
     *
     * @param selector the selector
     */
    @JsonCreator
    SelectorValue(@JsonProperty("selector") Wrapper selector) {
        this.selector = selector;
    }

    /**
     * Single selector config.
     *
     * @param optionKey the option key
     * @return the selector config
     */
    public static SelectorValue single(String optionKey) {
        Wrapper wrapper = new Wrapper(SelectType.SINGLE, Collections.singletonList(new SelectorKey(optionKey)));
        return new SelectorValue(wrapper);
    }

    /**
     * Multiple selector config.
     *
     * @param optionKeys the option keys
     * @return the selector config
     */
    public static SelectorValue multiple(List<String> optionKeys) {
        Wrapper wrapper = new Wrapper(SelectType.MULTI, optionKeys.stream()
                .map(SelectorKey::new)
                .collect(Collectors.toList()));
        return new SelectorValue(wrapper);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final SelectType type;
        private final List<SelectorKey> options;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type    the type
         * @param options the options
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") SelectType type, @JsonProperty("options") List<SelectorKey> options) {
            this.type = type;
            this.options = options;
        }
    }
}
