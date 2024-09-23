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

import cn.felord.enumeration.WorkbenchType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Work bench setting.
 *
 * @param <B> the type parameter
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class UserWorkBenchSetting<B extends WorkBenchBody> {
    /**
     * 工作台类型
     */
    private final WorkbenchType type;
    /**
     * 用户id
     * <p>
     * userid必须在应用可见范围；
     * 每个用户每个应用接口限制10次/分钟；
     */
    private final String userid;
    /**
     * 填充数据，要根据工作台类型来决定
     *
     * @see WorkBenchBody
     */
    private final B body;

    /**
     * Instantiates a new Work bench setting.
     *
     * @param type   the type
     * @param userid the userid
     * @param body   the body
     */
    UserWorkBenchSetting(WorkbenchType type, String userid, B body) {
        this.type = type;
        this.userid = userid;
        this.body = body;
    }

    /**
     * 关键数据型
     *
     * @param userid  the userid
     * @param keyData the key data
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<KeyData> keyData(String userid, KeyData keyData) {
        return new UserWorkBenchSetting<>(WorkbenchType.KEY_DATA, userid, keyData);
    }


    /**
     * 图片型
     *
     * @param userid the userid
     * @param image  the image
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Image> image(String userid, Image image) {
        return new UserWorkBenchSetting<>(WorkbenchType.IMAGE, userid, image);
    }

    /**
     * 列表型
     *
     * @param userid the userid
     * @param items  the items
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Items> list(String userid, Items items) {
        return new UserWorkBenchSetting<>(WorkbenchType.LIST, userid, items);
    }

    /**
     * Webview型
     *
     * @param userid  the userid
     * @param webview the webview
     * @return the work bench setting
     */
    public static UserWorkBenchSetting<Webview> webview(String userid, Webview webview) {
        return new UserWorkBenchSetting<>(WorkbenchType.WEBVIEW, userid, webview);
    }

}
