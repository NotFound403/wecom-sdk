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

package cn.felord.domain.approval;

import cn.felord.enumeration.SelectType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Selector config.
 *
 * @author dax
 * @since 2023 /5/25 16:22
 */
@ToString
@Getter
public class SelectorConfig implements ControlConfig {
    private final Wrapper selector;

    /**
     * Instantiates a new Selector config.
     *
     * @param selector the selector
     */
    @JsonCreator
    SelectorConfig(@JsonProperty("selector") Wrapper selector) {
        this.selector = selector;
    }

    /**
     * 单选
     *
     * @param options the options
     * @return the selector config
     */
    public static SelectorConfig single(List<CtrlOption> options) {
        Wrapper wrapper = new Wrapper(SelectType.SINGLE, options);
        return new SelectorConfig(wrapper);
    }

    /**
     * 多选
     *
     * @param options the options
     * @return the selector config
     */
    public static SelectorConfig multiple(List<CtrlOption> options) {
        Wrapper wrapper = new Wrapper(SelectType.MULTI, options);
        return new SelectorConfig(wrapper);
    }

    /**
     * 从选项中生成填充值
     *
     * @param keys the keys
     * @return the selector value
     */
    public SelectorValue fromKey(List<String> keys) {
        List<SelectorKey> selectorKeys = this.selector
                .options
                .stream()
                .map(CtrlOption::getKey)
                .filter(keys::contains)
                .map(SelectorKey::new)
                .collect(Collectors.toList());
        SelectorValue.Wrapper wrapper = new SelectorValue.Wrapper(this.selector.type, selectorKeys);
        return new SelectorValue(wrapper);
    }


    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final SelectType type;
        private final List<CtrlOption> options;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type    the type
         * @param options the options
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") SelectType type, @JsonProperty("options") List<CtrlOption> options) {
            this.type = type;
            this.options = options;
        }
    }
}
