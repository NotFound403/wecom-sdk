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

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.EquipmentType;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/11/29
 */
@Data
public class RoomDetail {
    /**
     * 会议室id
     */
    private Integer meetingroomId;
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
     * 是否需要审批
     */
    private BoolEnum needApproval;
    /**
     * 会议室的使用范围
     */
    private Range range;
}
