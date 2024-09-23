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
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 创建获客链接参数
 *
 * @author dax
 * @since 2024/5/30
 */
@ToString
@Getter
@RequiredArgsConstructor
public class AcquisitionLinkCreateRequest {
    private final String linkName;
    private AcquisitionLinkRange range;
    private Boolean skipVerify;


    /**
     * Range acquisition link create request.
     *
     * @param userList       the user list
     * @param departmentList the department list
     * @return the acquisition link update request
     */
    public AcquisitionLinkCreateRequest range(Set<String> userList, List<Long> departmentList) {
        this.range = new AcquisitionLinkRange(userList, departmentList);
        return this;
    }

    /**
     * Range acquisition link create request.
     *
     * @param userList the user list
     * @return the acquisition link update request
     */
    public AcquisitionLinkCreateRequest range(Set<String> userList) {
        this.range = new AcquisitionLinkRange(userList, Collections.emptyList());
        return this;
    }

    /**
     * Range acquisition link create request.
     *
     * @param departmentList the department list
     * @return the acquisition link update request
     */
    public AcquisitionLinkCreateRequest range(List<Long> departmentList) {
        this.range = new AcquisitionLinkRange(Collections.emptySet(), departmentList);
        return this;
    }

    /**
     * Skip verify acquisition link update request.
     *
     * @param skipVerify the skip verify
     * @return the acquisition link update request
     */
    public AcquisitionLinkCreateRequest skipVerify(boolean skipVerify) {
        this.skipVerify = skipVerify;
        return this;
    }
}
