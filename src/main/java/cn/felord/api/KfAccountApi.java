package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.KfAccountInfo;
import cn.felord.domain.callcenter.KfAccountListRequest;
import cn.felord.domain.callcenter.KfAccountUpdateRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客服账号管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public class KfAccountApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf account api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfAccountApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 添加客服账号
     *
     * @param accountName the account name
     * @param mediaId     the media id
     * @return the generic response
     */
    public GenericResponse<String> addKfAccount(String accountName, String mediaId) {
        Map<String, String> body = new HashMap<>(2);
        body.put("name", accountName);
        body.put("media_id", mediaId);
        return workWeChatApiClient.post( WeComEndpoint.KF_ACCOUNT_CREATE, body, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 删除客服账号
     *
     * @param openKfid the open kfid
     * @return the we com response
     */
    public WeComResponse delKfAccount(String openKfid) {
        return workWeChatApiClient.post(WeComEndpoint.KF_ACCOUNT_DEL, Collections.singletonMap("open_kfid", openKfid), WeComResponse.class);
    }

    /**
     * 修改客服账号
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse updateKfAccount(KfAccountUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_ACCOUNT_UPDATE, request, WeComResponse.class);
    }

    /**
     * 获取客服账号列表
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<List<KfAccountInfo>> kfAccountList(KfAccountListRequest request) {
        return workWeChatApiClient.post( WeComEndpoint.KF_ACCOUNT_LIST, request, new ParameterizedTypeReference<GenericResponse<List<KfAccountInfo>>>() {
        });
    }

    /**
     * 获取客服账号链接
     *
     * @param openKfid the open kfid
     * @param scene    the scene
     * @return the generic response
     */
    public GenericResponse<String> kfAccountLink(String openKfid, String scene) {
        Map<String, String> body = new HashMap<>(2);
        body.put("open_kfid", openKfid);
        if (StringUtils.hasText(scene)) {
            body.put("scene", scene);
        }
        GenericResponse<String> response = workWeChatApiClient.post(WeComEndpoint.KF_ADD_CONTACT_WAY, body, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
        if (StringUtils.hasText(scene)) {
            String url = UriComponentsBuilder.fromHttpUrl(response.getData())
                    .queryParam("scene_param", UriUtils.encode(scene, StandardCharsets.UTF_8))
                    .build()
                    .toUriString();
            response.setData(url);
        }
        return response;
    }
}
