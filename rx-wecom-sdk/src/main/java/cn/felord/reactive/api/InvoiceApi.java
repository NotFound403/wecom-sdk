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

import cn.felord.domain.WeComResponse;
import cn.felord.domain.invoice.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 电子发票
 *
 * @author dax
 * @since 2024/7/27
 */
public interface InvoiceApi {

    /**
     * 查询电子发票
     * <p>
     * 报销方在获得用户选择的电子发票标识参数后，可以通过该接口查询电子发票的结构化信息，并获取发票PDF文件。
     *
     * @param invoiceInfo the invoice info
     * @return the invoice info
     */
    @POST("card/invoice/reimburse/getinvoiceinfo")
    Single<InvoiceDetailResponse> getInvoiceInfo(@Body InvoiceInfo invoiceInfo);

    /**
     * 更新发票状态
     *
     * @param request the request
     * @return the in voice detail response
     */
    @POST("card/invoice/reimburse/updateinvoicestatus")
    Single<WeComResponse> updateInvoiceStatus(@Body InvoiceUpdateRequest request);

    /**
     * 批量更新发票状态
     *
     * @param request the request
     * @return the we com response
     */
    @POST("card/invoice/reimburse/updatestatusbatch")
    Single<WeComResponse> updateStatusBatch(@Body InvoiceUpdateRequest request);

    /**
     * 批量查询电子发票
     *
     * @param invoiceInfoItems the invoice info items
     * @return the invoiceinfo batch
     */
    @POST("card/invoice/reimburse/getinvoiceinfobatch")
    Single<InvoiceDetailsResponse> getInvoiceinfoBatch(@Body InvoiceInfoItems invoiceInfoItems);
}
