/*
 * Copyright (c) 2025. felord.cn
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

package cn.felord.domain.checkin;

import cn.felord.enumeration.CheckinDeviceType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CheckinRecord {
    /**
     * 用户id
     */
    private String userid;
    /**
     * 打卡时间。Unix时间戳
     */
    private Instant checkinTime;
    /**
     * 打卡地点title，限制1024字符
     */
    private String locationTitle;
    /**
     * 打卡地点详情限制1024字符
     */
    private String locationDetail;
    /**
     * 打卡备注限制1024字符
     */
    private String notes;
    /**
     * 打卡wifi名称限制1024字符
     */
    private String wifiname;
    /**
     * 打卡的MAC地址/bssid
     * 满足正则表达式^[A-Fa-f0-9]{2}:[A-Fa-f0-9]{2}:[A-Fa-f0-9]{2}:[A-Fa-f0-9]{2}:[A-Fa-f0-9]{2}:[A-Fa-f0-9]{2}$。
     * 传入wifiname时必填
     */
    private String wifimac;
    /**
     * 打卡的附件media_id，可使用{@code MediaApi#uploadMedia}上传附件。当前最多只允许传1个
     */
    private List<String> mediaids;
    /**
     * 位置打卡地点纬度，是实际纬度的1000000倍，与腾讯地图一致采用GCJ-02坐标系统标准 范围 -90000000,90000000
     */
    private Integer lat;
    /**
     * 位置打卡地点经度，是实际经度的1000000倍，与腾讯地图一致采用GCJ-02坐标系统标准 范围-180000000,180000000
     */
    private Integer lng;
    /**
     * 打卡设备类型：1、门禁 2、考勤机（人脸识别、指纹识别） 3、其他；
     */
    private CheckinDeviceType deviceType;
    /**
     * 打卡设备品牌：字符串写入（限制40个字符内）
     */
    private String deviceDetail;
}
