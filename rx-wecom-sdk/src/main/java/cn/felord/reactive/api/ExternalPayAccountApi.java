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

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.corpay.external.account.ApplyStatusResponse;
import cn.felord.domain.corpay.external.account.MchAccountRequest;
import cn.felord.domain.corpay.external.account.OutRequestNo;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 对外收款账户API
 *
 * @author dax
 * @since 2024/7/3 15:57
 */
public interface ExternalPayAccountApi {

    /**
     * 提交创建对外收款账户的申请单(进件)
     * <p>
     * 企业可以通过这个接口快速递交材料，用于创建对外收款账户申请单
     * 图片ID通过提交图片接口获取
     * 同一个提现人员最多申请200个商户号，同一个企业最多申请2000个商户号
     * 目前本接口仅支持『对外收款』应用调用，即获取access_token时需要使用『对外收款』应用的SECRET
     *
     * @param request the request
     * @return the generic response
     */
    @POST("miniapppay/apply_mch")
    Single<GenericResponse<String>> applyMch(@Body MchAccountRequest request);

    /**
     * 查询申请单状态
     * <p>
     * 通过这个接口查询已提交的申请单状态
     * 使用提交创建对外收款账户的申请单接口中填写的out_request_no来查询
     * 目前本接口仅支持『对外收款』应用调用，即获取access_token时需要使用『对外收款』应用的SECRET
     *
     * @param outRequestNo the out request no
     * @return the applyment status
     */
    @POST("miniapppay/get_applyment_status")
    Single<ApplyStatusResponse> getApplymentStatus(@Body OutRequestNo outRequestNo);
}
