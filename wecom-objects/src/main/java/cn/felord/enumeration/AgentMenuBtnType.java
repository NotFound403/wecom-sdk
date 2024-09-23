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
 * 应用菜单按钮类型
 *
 * @author dax
 * @since 2022 /10/25
 */
public enum AgentMenuBtnType {
    /**
     * 点击推事件
     */
    CLICK("click"),
    /**
     * 跳转URL
     */
    VIEW("view"),
    /**
     * 扫码推事件
     */
    SCANCODE_PUSH("scancode_push"),
    /**
     * 扫码推事件 且弹出“消息接收中”提示框
     */
    SCANCODE_WAITMSG("scancode_waitmsg"),
    /**
     * 弹出系统拍照发图
     */
    PIC_SYSPHOTO("pic_sysphoto"),
    /**
     * 弹出拍照或者相册发图
     */
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
    /**
     * 弹出企业微信相册发图器
     */
    PIC_WEIXIN("pic_weixin"),
    /**
     * 弹出地理位置选择器
     */
    LOCATION_SELECT("location_select"),
    /**
     * 跳转到小程序
     */
    VIEW_MINIPROGRAM("view_miniprogram");

    private final String type;

    AgentMenuBtnType(String type) {
        this.type = type;
    }

    /**
     * Deserialize AgentMenuBtnType
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static AgentMenuBtnType deserialize(String type) {
        return Arrays.stream(AgentMenuBtnType.values())
                .filter(agentMenuBtnType -> agentMenuBtnType.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
