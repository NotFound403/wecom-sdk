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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 超级管理员证件类型
 * <p>
 * 当超级管理员类型是经办人时，请上传超级管理员证件类型。
 *
 * @author felord.cn
 * @since 1.1.1
 */
public enum IdDocType {
    /**
     * 中国大陆居民-身份证
     */
    IDENTIFICATION_TYPE_IDCARD1(0),
    /**
     * 其他国家或地区居民-护照
     */
    IDENTIFICATION_TYPE_OVERSEA_PASSPORT(1),
    /**
     * 中国香港居民-来往内地通行证
     */
    IDENTIFICATION_TYPE_HONGKONG_PASSPORT(2),
    /**
     * 中国澳门居民-来往内地通行证
     */
    IDENTIFICATION_TYPE_MACAO_PASSPORT(3),
    /**
     * 中国台湾居民-来往大陆通行证
     */
    IDENTIFICATION_TYPE_TAIWAN_PASSPORT(4),
    /**
     * 外国人居留证
     */
    IDENTIFICATION_TYPE_FOREIGN_RESIDENT(5),
    /**
     * 港澳居民证
     */
    IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT(6),
    /**
     * 台湾居民证
     */
    IDENTIFICATION_TYPE_TAIWAN_RESIDENT(7),
    /**
     * 中国大陆居民-身份证
     */
    IDENTIFICATION_TYPE_IDCARD2(8);
    private final int type;

    IdDocType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }


    /**
     * Deserialize idDocType.
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static IdDocType deserialize(int type) {
        return Arrays.stream(IdDocType.values())
                .filter(idDocType -> idDocType.type == type)
                .findFirst()
                .orElse(null);
    }
}
