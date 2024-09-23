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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 升级服务
 *
 * @author dax
 * @since 2024/6/6
 */
public interface KfUpgradeApi {

    /**
     * 获取配置的专员与客户群
     *
     * @return the upgrade service config
     * @throws WeComException the weComException
     */
    @GET("kf/customer/get_upgrade_service_config")
    UpgradeServiceConfig upgradeServiceConfig() throws WeComException;

    /**
     * 为客户升级为专员或客户群服务
     *
     * @param request the request
     * @return the upgrade service config
     * @throws WeComException the weComException
     */
    @POST("kf/customer/upgrade_service")
    WeComResponse upgradeService(@Body UpgradeServiceRequest request) throws WeComException;

    /**
     * 为客户取消推荐
     *
     * @param kfAndExternalUser the kf and external user
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/customer/cancel_upgrade_service")
    WeComResponse cancelService(@Body KfAndExternalUser kfAndExternalUser) throws WeComException;

    /**
     * 获取客户基础信息
     *
     * @param request the request
     * @return the kf external user response
     * @throws WeComException the weComException
     */
    @POST("kf/customer/batchget")
    KfExternalUserResponse batchKfExternalUsers(@Body KfExternalUserRequest request) throws WeComException;
}
