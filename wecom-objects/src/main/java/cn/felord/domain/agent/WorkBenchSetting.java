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
public class WorkBenchSetting<B extends WorkBenchBody> {
    /**
     * 工作台类型
     */
    private final WorkbenchType type;
    /**
     * 是否覆盖用户工作台的数据。
     * <p>
     * 设置为true的时候，会覆盖企业所有用户当前设置的数据。
     * 若设置为false,则不会覆盖用户当前设置的所有数据。默认为false
     */
    private final boolean replaceUserData;
    /**
     * 填充数据，要根据工作台类型来决定
     *
     * @see WorkBenchBody
     */
    private final B body;

    /**
     * Instantiates a new Work bench setting.
     *
     * @param type            the type
     * @param replaceUserData the replace user data
     * @param body            the body
     */
    WorkBenchSetting(WorkbenchType type, boolean replaceUserData, B body) {
        this.type = type;
        this.replaceUserData = replaceUserData;
        this.body = body;
    }

    /**
     * 关键数据型
     *
     * @param keyData the key data
     * @return the work bench setting
     */
    public static WorkBenchSetting<KeyData> keyData(KeyData keyData) {
        return keyData(false, keyData);
    }

    /**
     * 关键数据型
     *
     * @param replaceUserData the replace user data
     * @param keyData         the key data
     * @return the work bench setting
     */
    public static WorkBenchSetting<KeyData> keyData(boolean replaceUserData, KeyData keyData) {
        return new WorkBenchSetting<>(WorkbenchType.KEY_DATA, replaceUserData, keyData);
    }

    /**
     * 图片型
     *
     * @param image the image
     * @return the work bench setting
     */
    public static WorkBenchSetting<Image> image(Image image) {
        return image(false, image);
    }

    /**
     * 图片型
     *
     * @param replaceUserData the replace user data
     * @param image           the image
     * @return the work bench setting
     */
    public static WorkBenchSetting<Image> image(boolean replaceUserData, Image image) {
        return new WorkBenchSetting<>(WorkbenchType.IMAGE, replaceUserData, image);
    }

    /**
     * 列表型
     *
     * @param items the items
     * @return the work bench setting
     */
    public static WorkBenchSetting<Items> list(Items items) {
        return list(false, items);
    }

    /**
     * 列表型
     *
     * @param replaceUserData the replace user data
     * @param items           the items
     * @return the work bench setting
     */
    public static WorkBenchSetting<Items> list(boolean replaceUserData, Items items) {
        return new WorkBenchSetting<>(WorkbenchType.LIST, replaceUserData, items);
    }

    /**
     * Webview型
     *
     * @param webview the webview
     * @return the work bench setting
     */
    public static WorkBenchSetting<Webview> webview(Webview webview) {
        return webview(false, webview);
    }

    /**
     * Webview型
     *
     * @param replaceUserData the replace user data
     * @param webview         the webview
     * @return the work bench setting
     */
    public static WorkBenchSetting<Webview> webview(boolean replaceUserData, Webview webview) {
        return new WorkBenchSetting<>(WorkbenchType.WEBVIEW, replaceUserData, webview);
    }

    /**
     * 普通型
     *
     * @return the work bench setting
     */
    public static WorkBenchSetting<Webview> normal() {
        return normal(false);
    }

    /**
     * 普通型
     *
     * @param replaceUserData the replace user data
     * @return the work bench setting
     */
    public static WorkBenchSetting<Webview> normal(boolean replaceUserData) {
        return new WorkBenchSetting<>(WorkbenchType.NORMAL, replaceUserData, null);
    }
}
