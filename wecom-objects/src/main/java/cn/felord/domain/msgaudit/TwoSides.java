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

package cn.felord.domain.msgaudit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The TwoSides
 *
 * @author dax
 * @since 2024/12/1
 */
@ToString
@Getter
public class TwoSides {
    /**
     * 内部成员
     */
    private final String userid;
    /**
     * 内部成员对应的外部联系人exteranal_user_id
     */
    private final String exteranalopenid;

    /**
     * Instantiates a new Two sides.
     *
     * @param userid          the userid
     * @param exteranalopenid the exteranalopenid
     */
    @JsonCreator
    TwoSides(@JsonProperty("userid") String userid,
             @JsonProperty("exteranalopenid") String exteranalopenid) {
        this.userid = userid;
        this.exteranalopenid = exteranalopenid;
    }

    /**
     * Between two sides.
     *
     * @param userid          the userid
     * @param exteranalUserId the exteranal user id
     * @return the two sides
     */
    public static TwoSides between(String userid, String exteranalUserId) {
        return new TwoSides(userid, exteranalUserId);
    }
}
