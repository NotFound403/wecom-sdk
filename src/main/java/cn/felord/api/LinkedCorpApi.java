package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpSimpleUserInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.PermListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * 互联企业通讯录
 *
 * @author felord.cn
 * @since 2021 /8/29 16:39
 */
public class LinkedCorpApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    LinkedCorpApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取应用的可见范围
     *
     * @return the perm list
     */
    public PermListResponse getPermList() {
        String endpoint = WeComEndpoint.LINKED_CORP_PERM_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.emptyMap(), PermListResponse.class);
    }

    /**
     * 获取互联企业成员详细信息
     *
     * @param corpUserId the corp user id
     * @return the user
     */
    public GenericResponse<CorpUserInfo> getUser(String corpUserId) {
        String endpoint = WeComEndpoint.LINKED_CORP_USER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("userid", corpUserId),
                new ParameterizedTypeReference<GenericResponse<CorpUserInfo>>() {
                });
    }

    /**
     * 获取互联企业部门成员
     *
     * @param linkedDepartmentId the linked department id
     * @return the generic response
     */
    public GenericResponse<List<CorpSimpleUserInfo>> getUserSimplelist(String linkedDepartmentId) {
        String endpoint = WeComEndpoint.LINKED_CORP_USER_SIMPLELIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("department_id", linkedDepartmentId),
                new ParameterizedTypeReference<GenericResponse<List<CorpSimpleUserInfo>>>() {
                });
    }

    /**
     * 获取互联企业部门列表
     *
     * @param linkedDepartmentId the linked department id
     * @return the dept list
     */
    public GenericResponse<List<DeptInfo>> getDeptList(String linkedDepartmentId) {
        String endpoint = WeComEndpoint.LINKED_CORP_DEPT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("department_id", linkedDepartmentId),
                new ParameterizedTypeReference<GenericResponse<List<DeptInfo>>>() {
                });
    }
}
