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
 * The type Room create request.
 *
 * @author dax
 * @since 2021 /7/12 19:23
 */
@ToString
@Getter
public class RoomCreateRequest {
    /**
     * 会议室名称，最多30个字符
     */
    private final String name;
    /**
     * 会议室所能容纳的人数
     */
    private final Integer capacity;
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
     * Instantiates a new Room create request.
     *
     * @param name     the name
     * @param capacity the capacity
     */
    public RoomCreateRequest(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    /**
     * City room create request.
     *
     * @param city the city
     * @return the room create request
     */
    public RoomCreateRequest city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Building room create request.
     *
     * @param building the building
     * @return the room create request
     */
    public RoomCreateRequest building(String building) {
        this.building = building;
        return this;
    }

    /**
     * Floor room create request.
     *
     * @param floor the floor
     * @return the room create request
     */
    public RoomCreateRequest floor(String floor) {
        this.floor = floor;
        return this;
    }

    /**
     * Equipment room create request.
     *
     * @param equipment the equipment
     * @return the room create request
     */
    public RoomCreateRequest equipment(List<EquipmentType> equipment) {
        this.equipment = equipment;
        return this;
    }

    /**
     * Coordinate room create request.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the room create request
     */
    public RoomCreateRequest coordinate(String latitude, String longitude) {
        this.coordinate = new Coordinate(latitude, longitude);
        return this;
    }

    /**
     * Range room create request.
     *
     * @param departmentList the department list
     * @return the room create request
     */
    public RoomCreateRequest range(List<Integer> departmentList) {
        this.range = new Range(departmentList, null);
        return this;
    }

    /**
     * Range room create request.
     *
     * @param userList the user list
     * @return the room create request
     */
    public RoomCreateRequest range(ArrayList<String> userList) {
        this.range = new Range(null, userList);
        return this;
    }

    /**
     * Range room create request.
     *
     * @param departmentList the department list
     * @param userList       the user list
     * @return the room create request
     */
    public RoomCreateRequest range(List<Integer> departmentList, List<String> userList) {
        this.range = new Range(departmentList, userList);
        return this;
    }
}
