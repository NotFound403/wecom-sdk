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
     * 单选配置选项
     *
     * @param options the options
     * @return the selector config
     */
    public static SelectorConfig single(List<CtrlOption> options) {

        return single(options, null);
    }

    /**
     * 单选配置选项，并关联选项
     *
     * @param options     the options
     * @param opRelations the op relations
     * @return the selector config
     */
    public static SelectorConfig single(List<CtrlOption> options, List<OpRelation> opRelations) {
        Wrapper wrapper = new Wrapper(SelectType.SINGLE, options, opRelations, null);
        return new SelectorConfig(wrapper);
    }

    /**
     * 单选关联外部选项，此时手动配置和关联控件失效
     * <p>
     * 配置后，点击控件将跳转至该页面{@code externalUrl}进行选择，<a href="https://developer.work.weixin.qq.com/document/42297">相关文档</a>
     *
     * @param externalUrl the external url
     * @return the selector config
     */
    public static SelectorConfig single(String externalUrl) {
        Wrapper wrapper = new Wrapper(SelectType.SINGLE, null, null, new ExternalOption(true, externalUrl));
        return new SelectorConfig(wrapper);
    }

    /**
     * 多选配置选项
     *
     * @param options the options
     * @return the selector config
     */
    public static SelectorConfig multiple(List<CtrlOption> options) {
        return multiple(options, null);
    }

    /**
     * 多选配置选项，并关联选项
     *
     * @param options     the options
     * @param opRelations the op relations
     * @return the selector config
     */
    public static SelectorConfig multiple(List<CtrlOption> options, List<OpRelation> opRelations) {
        Wrapper wrapper = new Wrapper(SelectType.MULTI, options, opRelations, null);
        return new SelectorConfig(wrapper);
    }

    /**
     * 多选关联外部选项，此时手动配置和关联控件失效
     * <p>
     * 配置后，点击控件将跳转至该页面{@code externalUrl}进行选择，<a href="https://developer.work.weixin.qq.com/document/42297">相关文档</a>
     *
     * @param externalUrl the external url
     * @return the selector config
     */
    public static SelectorConfig multiple(String externalUrl) {
        Wrapper wrapper = new Wrapper(SelectType.MULTI, null, null, new ExternalOption(true, externalUrl));
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
        /**
         * 选择类型
         */
        private final SelectType type;
        /**
         * 选项
         */
        private final List<CtrlOption> options;
        /**
         * 关联控件
         */
        private final List<OpRelation> opRelations;
        /**
         * 关联外部选项
         */
        private final ExternalOption externalOption;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type           the type
         * @param options        the options
         * @param opRelations    the op relations
         * @param externalOption the external option
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") SelectType type,
                @JsonProperty("options") List<CtrlOption> options,
                @JsonProperty("op_relations") List<OpRelation> opRelations,
                @JsonProperty("external_option") ExternalOption externalOption) {
            this.type = type;
            this.options = options;
            this.opRelations = opRelations;
            this.externalOption = externalOption;
        }
    }
}
