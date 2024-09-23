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

import cn.felord.enumeration.DeviceType;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type Trust device.
 *
 * @author dax
 * @since 2024/10/10
 */
@ToString
@Getter
public class TrustDevice {
    /**
     * 设备的类型，Windows或Mac
     */
    private final DeviceType type;
    /**
     * 设备MAC地址，当system为Windows时必填，Mac选填，每个设备最多100个
     */
    private final String macAddr;
    /**
     * Mac序列号，当system为Mac时必填
     */
    private final String seqNo;
    /**
     * 主板UUID，当system为Windows可选填此参数
     */
    private String motherboardUuid;
    /**
     * 硬盘序列号，当system为Windows时可选填此参数，每个设备最多100个
     */
    private Set<String> harddiskUuid;
    /**
     * Windows域名，当system为Windows时可选填此参数
     */
    private String domain;
    /**
     * Windows计算机名，当system为Windows时可选填此参数
     */
    private String pcName;


    /**
     * Instantiates a new Trust device.
     *
     * @param type    the type
     * @param macAddr the mac addr
     * @param seqNo   the seq no
     */
    TrustDevice(DeviceType type, String macAddr, String seqNo) {
        this.type = type;
        this.macAddr = macAddr;
        this.seqNo = seqNo;
    }

    /**
     * Instantiates a new Trust device.
     *
     * @param type            the type
     * @param macAddr         the mac addr
     * @param seqNo           the seq no
     * @param motherboardUuid the motherboard uuid
     * @param harddiskUuid    the harddisk uuid
     * @param domain          the domain
     * @param pcName          the pc name
     */
    TrustDevice(DeviceType type, String macAddr, String seqNo, String motherboardUuid, Set<String> harddiskUuid, String domain, String pcName) {
        this.type = type;
        this.macAddr = macAddr;
        this.seqNo = seqNo;
        this.motherboardUuid = motherboardUuid;
        this.harddiskUuid = harddiskUuid;
        this.domain = domain;
        this.pcName = pcName;
    }

    /**
     * Mac trust device.
     *
     * @param seqNo the seq no
     * @return the trust device
     */
    public static TrustDevice mac(String seqNo) {
        return mac(seqNo, null);
    }

    /**
     * Mac trust device.
     *
     * @param seqNo   the seq no
     * @param macAddr the mac addr
     * @return the trust device
     */
    public static TrustDevice mac(String seqNo, String macAddr) {
        return new TrustDevice(DeviceType.MAC, seqNo, macAddr);
    }

    /**
     * Windows trust device.
     *
     * @param macAddr the mac addr
     * @return the trust device
     */
    public static TrustDevice windows(String macAddr) {
        return mac(null, macAddr);
    }

    /**
     * Windows trust device.
     *
     * @param macAddr the mac addr
     * @param seqNo   the seq no
     * @return the trust device
     */
    public static TrustDevice windows(String macAddr, String seqNo) {
        return new TrustDevice(DeviceType.WINDOWS, seqNo, macAddr);
    }

    /**
     * Motherboard uuid trust device.
     *
     * @param motherboardUuid the motherboard uuid
     * @return the trust device
     */
    public TrustDevice motherboardUuid(String motherboardUuid) {
        this.motherboardUuid = motherboardUuid;
        return this;
    }

    /**
     * Harddisk uuid trust device.
     *
     * @param harddiskUuid the harddisk uuid
     * @return the trust device
     */
    public TrustDevice harddiskUuid(Set<String> harddiskUuid) {
        this.harddiskUuid = harddiskUuid;
        return this;
    }

    /**
     * Domain trust device.
     *
     * @param domain the domain
     * @return the trust device
     */
    public TrustDevice domain(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * Pc name trust device.
     *
     * @param pcName the pc name
     * @return the trust device
     */
    public TrustDevice pcName(String pcName) {
        this.pcName = pcName;
        return this;
    }
}
