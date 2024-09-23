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

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ContactScene;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/9/19 13:51
 */
@Data
public class GroupChatWayResponse {
    private String configId;
    private ContactScene scene;
    private String remark;
    private BoolEnum autoCreateRoom;
    private String roomBaseName;
    private String qrCode;
    private Integer roomBaseId;
    private List<String> chatIdList;
    private String state;
}
