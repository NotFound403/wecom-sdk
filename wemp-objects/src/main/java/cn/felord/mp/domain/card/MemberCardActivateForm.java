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

package cn.felord.mp.domain.card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The type Member card activate form.
 */
@ToString
@RequiredArgsConstructor
@Getter
public class MemberCardActivateForm {
    private final String cardId;
    private ServiceStatement serviceStatement;
    private BindOldCard bindOldCard;
    private ActivateForm requiredForm;
    private ActivateForm optionalForm;


    /**
     * Service statement member card activate form.
     *
     * @param serviceStatement the service statement
     * @return the member card activate form
     */
    public MemberCardActivateForm serviceStatement(ServiceStatement serviceStatement) {
        this.serviceStatement = serviceStatement;
        return this;
    }

    /**
     * Bind old card member card activate form.
     *
     * @param bindOldCard the bind old card
     * @return the member card activate form
     */
    public MemberCardActivateForm bindOldCard(BindOldCard bindOldCard) {
        this.bindOldCard = bindOldCard;
        return this;
    }

    /**
     * Required form member card activate form.
     *
     * @param requiredForm the required form
     * @return the member card activate form
     */
    public MemberCardActivateForm requiredForm(ActivateForm requiredForm) {
        this.requiredForm = requiredForm;
        return this;
    }

    /**
     * Optional form member card activate form.
     *
     * @param optionalForm the optional form
     * @return the member card activate form
     */
    public MemberCardActivateForm optionalForm(ActivateForm optionalForm) {
        this.optionalForm = optionalForm;
        return this;
    }
}
