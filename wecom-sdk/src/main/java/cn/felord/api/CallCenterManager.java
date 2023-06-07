/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

/**
 * 微信客服
 *
 * @author dax
 * @since 2021 /7/26 13:42
 */
public class CallCenterManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Call center manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    CallCenterManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 客服账号管理
     *
     * @return the service account manager api
     */
    public KfAccountApi kfAccountApi() {
        return new KfAccountApi(workWeChatApiClient);
    }

    /**
     * 接待人员管理
     *
     * @return the kf servicer api
     */
    public KfServicerApi kfServicerApi() {
        return new KfServicerApi(workWeChatApiClient);
    }

    /**
     * 会话分配与消息收发
     *
     * @return the kf session api
     */
    public KfSessionApi kfSessionApi() {
        return new KfSessionApi(workWeChatApiClient);
    }

    /**
     * 客服升级服务
     *
     * @return the kf upgrade api
     */
    public KfUpgradeApi kfUpgradeApi() {
        return new KfUpgradeApi(workWeChatApiClient);
    }

    /**
     * 客服统计管理
     *
     * @return the kf statistic api
     */
    public KfStatisticApi kfStatisticApi() {
        return new KfStatisticApi(workWeChatApiClient);
    }

}
