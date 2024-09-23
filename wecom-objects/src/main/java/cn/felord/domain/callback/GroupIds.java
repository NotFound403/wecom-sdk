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

package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * The type Group ids.
 *
 * @author dax
 * @since 2024/10/13
 */
@ToString
@Getter
public class GroupIds {
    @XStreamImplicit(itemFieldName = "GroupId")
    private final List<Integer> groupIds;

    /**
     * Instantiates a new Group ids.
     *
     * @param groupIds the group ids
     */
    public GroupIds(Integer... groupIds) {
        this.groupIds = Arrays.asList(groupIds);
    }
}
