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

/**
 * The enum Email type.
 *
 * @author felord.cn
 * @since 1.0.0
 */
public enum EmailType {

    /**
     * 企业邮箱.
     */
    CORP(1,"企业邮箱（默认）"),
    /**
     * 个人邮箱.
     */
    PERSONAL(2,"个人邮箱");


    private final Integer type;
    private final String description;

    EmailType(Integer type,String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Type integer.
     *
     * @return the integer
     */
    public Integer type(){
        return this.type;
    }

    /**
     * Description string.
     *
     * @return the string
     */
    public String description(){
        return this.description;
    }
}
