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
 * @author dax
 * @since 2023/7/3 16:31
 */
public enum RealSignState {
    /**
     * 不可签约。该状态下，暂不支持超级管理员签约。一般为申请单处于已驳回、已冻结、机器校验中状态，无法签约
     */
    NOT_SIGNABLE(0),
    /**
     * 未签约。该状态下，电商平台可查询获取签约链接，引导二级商户的超级管理员完成签约
     */
    UNSIGNED(1),
    /**
     * 已签约。指二级商户的超级管理员已完成签约。注意：若申请单被驳回，商户修改了商户主体名称、法人名称、超级管理员信息、主体类型等信息，则需重新签约
     */
    SIGNED(2);


    private final int state;

    RealSignState(int state) {
        this.state = state;
    }


    /**
     * Gets state.
     *
     * @return the state
     */
    @JsonValue
    public int getState() {
        return state;
    }

    /**
     * Deserialize realSignState
     *
     * @param state the state
     * @return the kf service state
     */
    @JsonCreator
    public static RealSignState deserialize(int state) {
        return Arrays.stream(RealSignState.values())
                .filter(realSignState -> realSignState.state == state)
                .findFirst()
                .orElse(null);
    }
}
