package cn.felord.api.contactbook;

import cn.felord.api.AbstractApi;
import cn.felord.domain.contactbook.department.CreateDeptRequest;
import cn.felord.domain.contactbook.department.CreateDeptResponse;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
     * @return the we com response
     * @see WeComEndpoint#DEPT_CREATE
     */
    public CreateDeptResponse createDept(CreateDeptRequest request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.DEPT_CREATE.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.weComClient().post(uri, request, CreateDeptResponse.class);
    }
}
