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

package cn.felord.domain.security;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Device list request.
 *
 * @author dax
 * @since 2024/10/10
 */
@ToString
@Getter
public class DeviceListRequest {
    /**
     * 查询设备类型
     */
    private final int type;
    /**
     * 分页cursor,用于获取分页数据
     */
    private String cursor;
    /**
     * 查询返回的最大记录数，最高不超过100，默认为100
     */
    private Integer limit;


    /**
     * Instantiates a new Device list request.
     *
     * @param type the type
     */
    DeviceListRequest(int type) {
        this.type = type;
    }

    /**
     * 可信企业设备
     *
     * @return the device list request
     */
    public static DeviceListRequest corp() {
        return new DeviceListRequest(1);
    }

    /**
     * 未知设备
     *
     * @return the device list request
     */
    public static DeviceListRequest unknown() {
        return new DeviceListRequest(2);
    }

    /**
     * 可信个人设备
     *
     * @return the device list request
     */
    public static DeviceListRequest personal() {
        return new DeviceListRequest(3);
    }

    /**
     * Cursor device list request.
     *
     * @param cursor the cursor
     * @return the device list request
     */
    public DeviceListRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Limit device list request.
     *
     * @param limit the limit
     * @return the device list request
     */
    public DeviceListRequest limit(int limit) {
        this.limit = limit;
        return this;
    }
}
