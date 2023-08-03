package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.hr.FieldDetail;
import cn.felord.domain.hr.FieldGroup;
import cn.felord.domain.hr.StaffInfoRequest;
import cn.felord.domain.hr.StaffInfoUpdateRequest;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 人事助手
 *
 * @author dax
 * @since 2023 /8/3 11:48
 */
public interface StaffManagerApi {

    /**
     * 获取员工字段配置
     * <p>
     * 通过这个接口获取员工字段配置信息
     *
     * @return the fields
     */
    @GET("hr/get_fields")
    GenericResponse<List<FieldGroup>> getFields();

    /**
     * 获取员工花名册信息
     * <p>
     * 通过这个接口获取指定员工的花名册信息
     * 调用参数中的字段id信息可以通过获取员工字段配置接口获取
     *
     * @param request the request
     * @return the staff info
     */
    @POST("hr/get_staff_info")
    GenericResponse<List<FieldDetail>> getStaffInfo(@Body StaffInfoRequest request);

    /**
     * 更新员工花名册信息
     * <p>
     * 通过这个接口更新指定员工的花名册信息
     * 调用参数中的字段id信息可以通过获取员工字段配置接口获取
     * 有一些字段不支持更新，参考 <a href="https://developer.work.weixin.qq.com/document/path/99133#forbidden_fields">不支持更新字段表</a>
     *
     * @param request the request
     * @return the generic response
     */
    @POST("hr/update_staff_info")
    GenericResponse<List<FieldDetail>> updateStaffInfo(@Body StaffInfoUpdateRequest request);
}
