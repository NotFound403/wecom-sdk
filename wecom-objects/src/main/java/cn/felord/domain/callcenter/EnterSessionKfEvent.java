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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class EnterSessionKfEvent extends KfEvent {

    private final String externalUserid;
    private final String scene;
    private final String sceneParam;
    private final String welcomeCode;
    private final WechatChannels wechatChannels;

    @JsonCreator
    public EnterSessionKfEvent(@JsonProperty("open_kfid") String openKfid,
                               @JsonProperty("external_userid") String externalUserid,
                               @JsonProperty("scene") String scene,
                               @JsonProperty("scene_param") String sceneParam,
                               @JsonProperty("welcome_code") String welcomeCode,
                               @JsonProperty("wechat_channels") WechatChannels wechatChannels) {
        super(KfEventType.ENTER_SESSION, openKfid);
        this.externalUserid = externalUserid;
        this.scene = scene;
        this.sceneParam = sceneParam;
        this.welcomeCode = welcomeCode;
        this.wechatChannels = wechatChannels;
    }
}
