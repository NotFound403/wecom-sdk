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

package cn.felord.domain.meetingroom;

import cn.felord.enumeration.EquipmentType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type RoomListRequest.
 *
 * @author dax
 * @since 2021 /7/12 19:23
 */
@ToString
@Getter
public class RoomListRequest {
    private String city;
    private String floor;
    private String building;
    private List<EquipmentType> equipment;

    /**
     * City room list request.
     *
     * @param city the city
     * @return the room list request
     */
    public RoomListRequest city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Equipment room list request.
     *
     * @param equipment the equipment
     * @return the room list request
     */
    public RoomListRequest equipment(List<EquipmentType> equipment) {
        this.equipment = equipment;
        return this;
    }

    /**
     * Floor room list request.
     *
     * @param floor the floor
     * @return the room list request
     */
    public RoomListRequest floor(String floor) {
        this.floor = floor;
        return this;
    }

    /**
     * Building room list request.
     *
     * @param building the building
     * @return the room list request
     */
    public RoomListRequest building(String building) {
        this.building = building;
        return this;
    }
}
