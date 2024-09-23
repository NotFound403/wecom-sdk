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
 * The type User device request.
 *
 * @author dax
 * @since 2024/10/11
 */
@ToString
@Getter
public class UserDeviceRequest {
    private final String lastLoginUserid;
    private final int type;

    /**
     * Instantiates a new User device request.
     *
     * @param lastLoginUserid the last login userid
     * @param type            the type
     */
    UserDeviceRequest(String lastLoginUserid, int type) {
        this.lastLoginUserid = lastLoginUserid;
        this.type = type;
    }

    /**
     * 可信企业设备
     *
     * @param lastLoginUserid the last login userid
     * @return the device list request
     */
    public static UserDeviceRequest corp(String lastLoginUserid) {
        return new UserDeviceRequest(lastLoginUserid, 1);
    }

    /**
     * 未知设备
     *
     * @param lastLoginUserid the last login userid
     * @return the device list request
     */
    public static UserDeviceRequest unknown(String lastLoginUserid) {
        return new UserDeviceRequest(lastLoginUserid, 2);
    }

    /**
     * 可信个人设备
     *
     * @param lastLoginUserid the last login userid
     * @return the device list request
     */
    public static UserDeviceRequest personal(String lastLoginUserid) {
        return new UserDeviceRequest(lastLoginUserid, 3);
    }

}
