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

package cn.felord.domain.agent;

import cn.felord.enumeration.AgentMenuBtnType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 二级菜单项
 *
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class SubAgentMenuBtn {
    private final String name;
    private final AgentMenuBtnType type;
    private final String key;
    private final String url;
    private final String pagepath;
    private final String appid;

    /**
     * Instantiates a new Sub agent menu btn.
     *
     * @param name     the name
     * @param type     the type
     * @param key      the key
     * @param url      the url
     * @param pagepath the pagepath
     * @param appid    the appid
     */
    SubAgentMenuBtn(@JsonProperty("name") String name,
                    @JsonProperty("type") AgentMenuBtnType type,
                    @JsonProperty("key") String key,
                    @JsonProperty("url") String url,
                    @JsonProperty("pagepath") String pagepath,
                    @JsonProperty("appid") String appid) {
        this.name = name;
        this.type = type;
        this.key = key;
        this.url = url;
        this.pagepath = pagepath;
        this.appid = appid;
    }


    /**
     * 点击推事件
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn click(String name, String key) {
        return common(name, AgentMenuBtnType.CLICK, key);
    }

    /**
     * 扫码推事件
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn scancodePush(String name, String key) {
        return common(name, AgentMenuBtnType.SCANCODE_PUSH, key);
    }

    /**
     * 扫码推事件 且弹出“消息接收中”提示框
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn scancodeWaitmsg(String name, String key) {
        return common(name, AgentMenuBtnType.SCANCODE_WAITMSG, key);
    }

    /**
     * 弹出系统拍照发图
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn picSysphoto(String name, String key) {
        return common(name, AgentMenuBtnType.PIC_SYSPHOTO, key);
    }

    /**
     * 弹出拍照或者相册发图
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn picPhotoOrAlbum(String name, String key) {
        return common(name, AgentMenuBtnType.PIC_PHOTO_OR_ALBUM, key);
    }

    /**
     * 弹出企业微信相册发图器
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn picWeixin(String name, String key) {
        return common(name, AgentMenuBtnType.PIC_WEIXIN, key);
    }

    /**
     * 弹出地理位置选择器
     *
     * @param name the name
     * @param key  the key
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn locationSelect(String name, String key) {
        return common(name, AgentMenuBtnType.LOCATION_SELECT, key);
    }

    /**
     * 跳转URL
     *
     * @param name the name
     * @param url  the url
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn view(String name, String url) {
        return new SubAgentMenuBtn(name, AgentMenuBtnType.VIEW, null, url, null, null);
    }

    /**
     * 跳转到小程序
     *
     * @param name     the name
     * @param pagepath the pagepath
     * @param appid    the appid
     * @return the agent menu btn
     */
    public static SubAgentMenuBtn miniprogram(String name, String pagepath, String appid) {
        return new SubAgentMenuBtn(name, AgentMenuBtnType.VIEW_MINIPROGRAM, null, null, pagepath, appid);
    }

    private static SubAgentMenuBtn common(String name, AgentMenuBtnType type, String key) {
        return new SubAgentMenuBtn(name, type, key, null, null, null);
    }
}
