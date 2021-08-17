package cn.felord.api.contactbook;

import cn.felord.ContactBookAgent;
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

    public DepartmentApi agent(ContactBookAgent contactBookAgent) {
        this.withAgent(contactBookAgent);
        return this;
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return CreateDeptResponse
     * @see WeComEndpoint#DEPT_CREATE
     */
    public GenericResponse<String> createDept(DeptRequest request) {
        String endpoint = WeComEndpoint.DEPT_CREATE.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {});
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return the we com response
     * @see WeComEndpoint#DEPT_UPDATE
     */
    public WeComResponse updateDept(DeptRequest request) {
        String endpoint = WeComEndpoint.DEPT_UPDATE.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
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
        String endpoint = WeComEndpoint.DEPT_DELETE.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return this.get(uri, WeComResponse.class);
    }

    /**
     * 获取部门列表
     *
     * @param departmentId departmentId
     * @return DeptResponse
     * @see WeComEndpoint#DEPT_LIST
     */
    public GenericResponse<List<DeptRequest>> deptList(String departmentId) {
        String endpoint = WeComEndpoint.DEPT_LIST.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<DeptRequest>>>() {
        });
    }
}
