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

package cn.felord.domain.agent;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Agent menu btns.
 *
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class AgentMenuBtns {
    private final List<AgentMenuBtn> button;

    /**
     * Instantiates a new Agent menu btns.
     *
     * @param button the button
     */
    AgentMenuBtns(List<AgentMenuBtn> button) {
        this.button = button;
    }

    /**
     * From agent menu btns.
     *
     * @param button the button
     * @return the agent menu btns
     */
    public static AgentMenuBtns from(List<AgentMenuBtn> button) {
        return new AgentMenuBtns(button);
    }
}
