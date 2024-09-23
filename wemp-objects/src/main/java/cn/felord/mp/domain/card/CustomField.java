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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.MemberCardFieldType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

/**
 * 自定义会员信息类目
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class CustomField {
    /**
     * 会员信息类目半自定义名称，
     * 当开发者变更这类类目信息的value值时 可以选择触发系统模板消息通知用户
     */
    private final String nameType;
    /**
     * 会员信息类目自定义名称，
     * 当开发者变更这类类目信息的value值时 不会触发系统模板消息通知用户
     */
    private final String name;
    /**
     * 点击类目跳转外链url
     */
    private final String url;


    /**
     * Instantiates a new Custom field.
     *
     * @param nameType the name type
     * @param url      the url
     */
    public CustomField(MemberCardFieldType nameType, String url) {
        this(Optional.ofNullable(nameType).map(Enum::name).orElse(null), null, url);
    }

    /**
     * Instantiates a new Custom field.
     *
     * @param name the name
     * @param url  the url
     */
    public CustomField(String name, String url) {
        this(null, name, url);
    }

    /**
     * Instantiates a new Custom field.
     *
     * @param nameType the name type
     * @param name     the name
     * @param url      the url
     */
    @JsonCreator
    CustomField(@JsonProperty("name_type") String nameType,
                @JsonProperty("name") String name,
                @JsonProperty("url") String url) {
        this.nameType = nameType;
        this.name = name;
        this.url = url;
    }

    /**
     * 从配置中删除自定义类目调用此方法
     *
     * @return the custom field
     */
    public static CustomField remove() {
        return new CustomField("", "", "");
    }
}
