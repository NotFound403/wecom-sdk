/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.msgaudit;

import lombok.Data;

/**
 * The type Room id.
 *
 * @author dax
 * @since 2023 /12/2
 */
@Data
public class RoomId {
    private final String roomid;

    /**
     * Instantiates a new Room id.
     *
     * @param roomid the roomid
     */
    RoomId(String roomid) {
        this.roomid = roomid;
    }

    /**
     * From room id.
     *
     * @param roomid the roomid
     * @return the room id
     */
    public static RoomId from(String roomid) {
        return new RoomId(roomid);
    }
}