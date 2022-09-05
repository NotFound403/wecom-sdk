package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.Cacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.linkedcorp.CorpDept;
import cn.felord.domain.contactbook.linkedcorp.CorpUser;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.LinkedCorpListResponse;
import cn.felord.enumeration.WeComEndpoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Linked corp api.
 *
 * @author felord.cn
 * @since 2021 /8/29 16:39
 */
public class LinkedCorpApi extends AbstractApi {
    /**
     * LinkedCorpApi
     *
     * @param cacheable the cacheable
     */
    LinkedCorpApi(Cacheable cacheable) {
        super(cacheable);
    }

    /**
     * Agent linked corp api.
     *
     * @param agent the agent
     * @return the linked corp api
     */
    LinkedCorpApi agent(AgentDetails agent) {
        this.withAgent(agent);
        return this;
    }


    /**
     * Gets perm list.
     *
     * @return the perm list
     */
    public LinkedCorpListResponse getPermList() {
        String endpoint = WeComEndpoint.LINKED_CORP_PERM_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        PermListResponse response = this.post(uri, Collections.emptyMap(), PermListResponse.class);

        Set<CorpUser> corpUsers = response.userids.stream()
                .map(s -> {
                    String[] split = s.split("/");
                    CorpUser corpUser = new CorpUser();
                    corpUser.setCorpId(split[0]);
                    corpUser.setUserId(split[1]);
                    return corpUser;
                })
                .collect(Collectors.toSet());
        Set<CorpDept> corpDepts = response.departmentIds.stream()
                .map(s -> {
                    String[] split = s.split("/");
                    CorpDept corpDept = new CorpDept();
                    corpDept.setLinkedId(split[0]);
                    corpDept.setDepartmentId(split[1]);
                    return corpDept;
                })
                .collect(Collectors.toSet());
        LinkedCorpListResponse linkedCorpListResponse = new LinkedCorpListResponse();
        linkedCorpListResponse.setCorpUsers(corpUsers);
        linkedCorpListResponse.setCorpDepts(corpDepts);
        return linkedCorpListResponse;
    }

    /**
     * Gets user.
     *
     * @param corpId the corp id
     * @param userId the user id
     * @return the user
     */
    public GenericResponse<CorpUserInfo> getUser(String corpId, String userId) {
        String endpoint = WeComEndpoint.LINKED_CORP_USER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("userid", corpId + "/" + userId),
                new ParameterizedTypeReference<GenericResponse<CorpUserInfo>>() {
                });
    }

    /**
     * The type Perm list response.
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    static class PermListResponse extends WeComResponse {
        private Set<String> userids;
        private Set<String> departmentIds;
    }

}
