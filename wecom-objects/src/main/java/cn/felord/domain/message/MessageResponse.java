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

package cn.felord.domain.message;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Message response.
 *
 * @author felord
 * @since 2021 /11/22 11:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponse extends WeComResponse {
    private String invaliduser;
    private String invalidparty;
    private String invalidtag;
    private String unlicenseduser;
    private String msgid;
    private String responseCode;

    /**
     * To invaliduser list list.
     *
     * @return the list
     */
    public List<String> toInvaliduserList() {
        return toList(invaliduser);
    }

    /**
     * To invalidparty list list.
     *
     * @return the list
     */
    public List<String> toInvalidpartyList() {
        return toList(invalidparty);
    }

    /**
     * To invalidtag list list.
     *
     * @return the list
     */
    public List<String> toInvalidtagList() {
        return toList(invalidtag);
    }

    /**
     * To unlicenseduser list list.
     *
     * @return the list
     */
    public List<String> toUnlicenseduserList() {
        return toList(unlicenseduser);
    }


    private List<String> toList(String listStr) {
        return Optional.ofNullable(listStr)
                .map(s ->
                        Arrays.stream(listStr.split("\\|"))
                                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

    }
}
