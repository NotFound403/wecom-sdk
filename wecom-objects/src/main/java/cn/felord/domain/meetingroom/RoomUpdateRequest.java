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

import java.util.ArrayList;
import java.util.List;

/**
 * The type Room update request.
 *
 * @author dax
 * @since 2024/11/30
 */
@ToString
@Getter
public class RoomUpdateRequest {
    private final Integer meetingroomId;
    /**
     * 会议室名称，最多30个字符
     */
    private String name;
    /**
     * 会议室所能容纳的人数
     */
    private Integer capacity;
    /**
     * 会议室所在城市
     */
    private String city;
    /**
     * 会议室所在楼宇
     */
    private String building;
    /**
     * 会议室所在楼层
     */
    private String floor;
    /**
     * 会议室支持的设备列表
     */
    private List<EquipmentType> equipment;
    /**
     * 会议室所在经纬度
     */
    private Coordinate coordinate;
    /**
     * 会议室的使用范围
     */
    private Range range;

    /**
     * Instantiates a new Room update request.
     *
     * @param meetingroomId the meetingroom id
     */
    public RoomUpdateRequest(int meetingroomId) {
        this.meetingroomId = meetingroomId;
    }

    /**
     * Name room update request.
     *
     * @param name the name
     * @return the room update request
     */
    public RoomUpdateRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * City room update request.
     *
     * @param city the city
     * @return the room update request
     */
    public RoomUpdateRequest city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Capacity room update request.
     *
     * @param capacity the capacity
     * @return the room update request
     */
    public RoomUpdateRequest capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * Building room update request.
     *
     * @param building the building
     * @return the room update request
     */
    public RoomUpdateRequest building(String building) {
        this.building = building;
        return this;
    }

    /**
     * Floor room update request.
     *
     * @param floor the floor
     * @return the room update request
     */
    public RoomUpdateRequest floor(String floor) {
        this.floor = floor;
        return this;
    }

    /**
     * Equipment room update request.
     *
     * @param equipment the equipment
     * @return the room update request
     */
    public RoomUpdateRequest equipment(List<EquipmentType> equipment) {
        this.equipment = equipment;
        return this;
    }

    /**
     * Coordinate room update request.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the room update request
     */
    public RoomUpdateRequest coordinate(String latitude, String longitude) {
        this.coordinate = new Coordinate(latitude, longitude);
        return this;
    }

    /**
     * Range room update request.
     *
     * @param departmentList the department list
     * @return the room update request
     */
    public RoomUpdateRequest range(List<Integer> departmentList) {
        this.range = new Range(departmentList, null);
        return this;
    }


    /**
     * Range room update request.
     *
     * @param userList the user list
     * @return the room update request
     */
    public RoomUpdateRequest range(ArrayList<String> userList) {
        this.range = new Range(null, userList);
        return this;
    }


    /**
     * Range room update request.
     *
     * @param departmentList the department list
     * @param userList       the user list
     * @return the room update request
     */
    public RoomUpdateRequest range(List<Integer> departmentList, List<String> userList) {
        this.range = new Range(departmentList, userList);
        return this;
    }
}
