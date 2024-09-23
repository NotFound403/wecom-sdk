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

import cn.felord.xml.convert.UpdateDetailTypeConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 回调事件群变更详情
 *
 * @author dax
 * @since 2024/7/6 8:52
 */
@XStreamConverter(UpdateDetailTypeConverter.class)
public enum UpdateDetailType {

    /**
     * 成员入群
     */
    ADD_MEMBER("add_member"),
    /**
     * 成员退群
     */
    DEL_MEMBER("del_member"),
    /**
     * 删除成员事件
     */
    CHANGE_OWNER("change_owner"),
    /**
     * 群名变更
     */
    CHANGE_NAME("change_name"),
    /**
     * 群公告变更
     */
    CHANGE_NOTICE("change_notice");
    private final String type;

    UpdateDetailType(String type) {
        this.type = type;
    }

    /**
     * Event string.
     *
     * @return the string
     */
    public String type() {
        return type;
    }
}
