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

package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.ToString;

/**
 * 可见范围
 *
 * <ul>
 *     <li>若只指定sender_list，则可见的客户范围为该部分执行者的客户，目前执行者支持传userid与部门id列表，注意不在应用可见范围内的执行者会被忽略。</li>
 *     <li>若只指定external_contact_list，即指定了可见该朋友圈的目标客户（通过客户标签指定），此时会将该发表任务推给这些目标客户的应用可见范围内的跟进人。</li>
 *     <li>若同时指定sender_list以及external_contact_list，会将该发表任务推送给sender_list指定的且在应用可见范围内的执行者，执行者发表后仅external_contact_list指定的客户可见。</li>
 *     <li>若未指定visible_range，则可见客户的范围为该应用可见范围内执行者的客户，执行者为应用可见范围内所有成员。</li>
 *     <li>若指定external_contact_list列表，则该条朋友圈为部分可见；否则为公开</li>
 * </ul>
 *
 * @author dax
 * @since 2021 /7/25 15:30
 */
@ToString
@Getter
public class VisibleRange {
    private final MomentSenderList senderList;
    private final MomentExternalContactList externalContactList;


    /**
     * Instantiates a new Visible range.
     *
     * @param externalContactList the external contact list
     */
    public VisibleRange(MomentExternalContactList externalContactList) {
        this(null, externalContactList);
    }

    /**
     * Instantiates a new Visible range.
     *
     * @param senderList the sender list
     */
    public VisibleRange(MomentSenderList senderList) {
        this(senderList, null);
    }

    /**
     * Instantiates a new Visible range.
     *
     * @param senderList          the sender list
     * @param externalContactList the external contact list
     */
    public VisibleRange(MomentSenderList senderList, MomentExternalContactList externalContactList) {
        this.senderList = senderList;
        this.externalContactList = externalContactList;
    }
}
