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

import lombok.Getter;

import java.util.regex.Pattern;

/**
 * The type Kf account link request.
 *
 * @author dax
 * @since 2024/5/24 15:25
 */
@Getter
public class KfAccountLinkRequest {
    private static final Pattern SCENE_REG = Pattern.compile("^[0-9a-zA-Z_-]$");
    private final String openKfid;
    private final String scene;

    /**
     * Instantiates a new Kf account link request.
     *
     * @param openKfid the open kfid
     */
    public KfAccountLinkRequest(String openKfid) {
        this(openKfid, null);
    }

    /**
     * Instantiates a new Kf account link request.
     *
     * @param openKfid the open kfid
     * @param scene    the scene
     */
    public KfAccountLinkRequest(String openKfid, String scene) {
        this.openKfid = openKfid;
        this.scene = scene;
    }
}
