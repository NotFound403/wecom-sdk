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

import cn.felord.enumeration.ContactScene;
import cn.felord.enumeration.ContactType;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/8 14:42
 */
@Data
public class ContactWayBodyDetail {
    private String configId;
    private ContactType type;
    private ContactScene scene;
    private Integer style;
    private String remark;
    private Boolean skipVerify;
    private String state;
    private String unionid;
    private List<String> user;
    private List<Integer> party;
    private Boolean isTemp;
    private Duration expiresIn;
    private Duration chatExpiresIn;
    private Boolean isExclusive;
    private Conclusions conclusions;
}
