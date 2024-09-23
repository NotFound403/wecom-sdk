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

import cn.felord.enumeration.ContactCtrlMode;
import cn.felord.enumeration.SelectType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Contact config.
 *
 * @author dax
 * @since 2024/5/25 16:31
 */
@ToString
@Getter
public class ContactConfig implements ControlConfig {
    private final Wrapper contact;

    /**
     * Instantiates a new Contact config.
     *
     * @param contact the contact
     */
    @JsonCreator
    ContactConfig(@JsonProperty("contact") Wrapper contact) {
        this.contact = contact;
    }

    /**
     * From contact config.
     *
     * @param selectType      the select type
     * @param contactCtrlMode the contact ctrl mode
     * @return the contact config
     */
    public static ContactConfig from(SelectType selectType, ContactCtrlMode contactCtrlMode) {
        return new ContactConfig(new Wrapper(selectType, contactCtrlMode));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final SelectType type;
        private final ContactCtrlMode mode;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type the type
         * @param mode the mode
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") SelectType type, @JsonProperty("mode") ContactCtrlMode mode) {
            this.type = type;
            this.mode = mode;
        }
    }
}
