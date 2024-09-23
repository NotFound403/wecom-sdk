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

import cn.felord.enumeration.MomentInteractionType;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * Deserialized by {@code InteractionUserJsonDeserializer}
 *
 * @author dax
 * @since 2021/10/20 15:22
 */
@Getter
@ToString
public class InteractionUser {
    private String virtualUserid;
    private Instant createTime;
    private MomentInteractionType type;

    @JsonAlias({"external_userid"})
    public void setExternalUserid(String externalUserid) {
        this.virtualUserid = externalUserid;
        this.type = MomentInteractionType.EXTERNAL;
    }

    @JsonAlias({"userid"})
    public void setUserid(String userid) {
        this.virtualUserid = userid;
        this.type = MomentInteractionType.INTERNAL;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }
}
