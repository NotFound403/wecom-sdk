package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.department.DeptSimpleInfo;
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
public class DepartmentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Department api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    DepartmentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return CreateDeptResponse generic response
     */
    public GenericResponse<Long> createDept(DeptInfo request) {
        String endpoint = WeComEndpoint.DEPT_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<Long>>() {
        });
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse updateDept(DeptInfo request) {
        String endpoint = WeComEndpoint.DEPT_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除部门,不能删除根部门；不能删除含有子部门、成员的部门
     * <p>
     * 第三方仅通讯录应用可以调用。
     *
     * @param departmentId departmentId
     * @return WeComResponse we com response
     */
    public WeComResponse deleteDept(Long departmentId) {
        String endpoint = WeComEndpoint.DEPT_DELETE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, WeComResponse.class);
    }

    /**
     * 获取部门列表
     *
     * @param departmentId departmentId
     * @return DeptResponse generic response
     * @see WeComEndpoint#DEPT_LIST
     */
    @Deprecated
    public GenericResponse<List<DeptInfo>> deptList(String departmentId) {
        String endpoint = WeComEndpoint.DEPT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<DeptInfo>>>() {
        });
    }

    /**
     * Gets simple list.
     *
     * @return the simple list
     */
    public GenericResponse<List<DeptSimpleInfo>> getSimpleList() {
        return getSimpleList(null);
    }

    /**
     * Get generic response.
     *
     * @param departmentId the department id
     * @return the generic response
     */
    public GenericResponse<List<DeptSimpleInfo>> getSimpleList(Integer departmentId) {
        String endpoint = WeComEndpoint.DEPT_SIMPLE_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("id", departmentId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<DeptSimpleInfo>>>() {
        });
    }

}
