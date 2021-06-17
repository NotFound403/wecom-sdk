package cn.felord.api.contactbook;

import cn.felord.api.AbstractApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.department.DeptRequest;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * 通讯录管理-部门管理
 *
 * @author n1
 * @since 2021 /6/17 14:58
 */
public class DepartmentApi extends AbstractApi {
    /**
     * Instantiates a new Department api.
     *
     * @param contactBookAgent the contact book agent
     */
    public DepartmentApi(ContactBookAgent contactBookAgent) {
        super(contactBookAgent);
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return CreateDeptResponse
     * @see WeComEndpoint#DEPT_CREATE
     */
    public GenericResponse<String> createDept(DeptRequest request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.DEPT_CREATE.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.weComClient().post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {});
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return the we com response
     * @see WeComEndpoint#DEPT_UPDATE
     */
    public WeComResponse updateDept(DeptRequest request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.DEPT_UPDATE.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.weComClient().post(uri, request, WeComResponse.class);
    }

    /**
     * 删除部门,不能删除根部门；不能删除含有子部门、成员的部门
     * <p>
     * 第三方仅通讯录应用可以调用。
     *
     * @param departmentId departmentId
     * @return WeComResponse
     * @see WeComEndpoint#DEPT_DELETE
     */
    public WeComResponse deleteDept(String departmentId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.DEPT_DELETE.endpoint(WeComDomain.CGI_BIN))
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return this.weComClient().get(uri, WeComResponse.class);
    }

    /**
     * 获取部门列表
     *
     * @param departmentId departmentId
     * @return DeptResponse
     * @see WeComEndpoint#DEPT_LIST
     */
    public GenericResponse<List<DeptRequest>> deptList(String departmentId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.DEPT_LIST.endpoint(WeComDomain.CGI_BIN))
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return this.weComClient().get(uri, new ParameterizedTypeReference<GenericResponse<List<DeptRequest>>>() {
        });
    }
}
