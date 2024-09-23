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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.security.DeviceCodes;
import cn.felord.domain.security.DeviceConfirmResponse;
import cn.felord.domain.security.DeviceDelRequest;
import cn.felord.domain.security.DeviceResultResponse;
import cn.felord.domain.security.FileOptRecordRequest;
import cn.felord.domain.security.FileOptRecordResponse;
import cn.felord.domain.security.TrustDeviceDetail;
import cn.felord.domain.security.TrustDevices;
import cn.felord.domain.security.UserDeviceRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 安全管理
 *
 * @author dax
 * @since 2024/10/11
 */
public interface SecurityApi {

    /**
     * 文件防泄漏
     * <p>
     * 启用了 “文件防泄漏”的企业可以通过本接口查询文件上传、下载、转发等操作记录。
     * <ul>
     *     <li>仅「文件防泄漏」可调用</li>
     *     <li>被分配微盘高级功能的用户，其操作记录将永久保存；其他用户仅保存近90天的记录</li>
     * </ul>
     *
     * @param request the request
     * @return the file oper record
     */
    @POST("security/get_file_oper_record")
    Single<FileOptRecordResponse> getFileOperRecord(@Body FileOptRecordRequest request);

    /**
     * 导入可信企业设备
     * <ul>
     *     <li>仅「设备管理」可调用</li>
     *     <li>每次调用最多导入100条可信企业设备记录</li>
     * </ul>
     *
     * @param trustDevices the trust devices
     * @return the file opt record response
     */
    @POST("security/trustdevice/import")
    Single<DeviceResultResponse> importTrustDevice(@Body TrustDevices trustDevices);

    /**
     * 获取成员使用设备
     * <p>
     * 仅「设备管理」可调用
     *
     * @param request the request
     * @return the trust device by user
     */
    @POST("security/trustdevice/get_by_user")
    Single<GenericResponse<List<TrustDeviceDetail>>> getTrustDeviceByUser(@Body UserDeviceRequest request);

    /**
     * 删除设备信息
     * <ul>
     *     <li>仅「设备管理」可调用</li>
     *     <li>每次调用可删除100个设备</li>
     * </ul>
     *
     * @param request the request
     * @return the we com response
     */
    @POST("security/trustdevice/delete")
    Single<WeComResponse> deleteTrustDevice(@Body DeviceDelRequest request);

    /**
     * 确认为可信设备
     * <ul>
     *     <li>仅「设备管理」可调用</li>
     *     <li>每次调用最多可以确认100个设备</li>
     * </ul>
     *
     * @param deviceCodes the device codes
     * @return the we com response
     */
    @POST("security/trustdevice/approve")
    Single<DeviceConfirmResponse> approveTrustDevice(@Body DeviceCodes deviceCodes);

    /**
     * 驳回可信设备申请
     * <ul>
     *     <li>仅「设备管理」可调用</li>
     *     <li>每次调用最多可以拒绝100个设备</li>
     * </ul>
     *
     * @param deviceCodes the device codes
     * @return the we com response
     */
    @POST("security/trustdevice/reject")
    Single<DeviceConfirmResponse> rejectTrustDevice(@Body DeviceCodes deviceCodes);
}
