package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * The type Corp tag api.
 *
 * @author dax
 * @since 2021 /9/12 16:39
 */
public class CorpTagApi extends AbstractApi {
    /**
     * Instantiates a new Corp tag api.
     *
     * @param cacheable the cacheable
     */
    CorpTagApi(WeComCacheable cacheable) {
        super(cacheable);
    }

    /**
     * Agent corp tag api.
     *
     * @param agent the agent
     * @return the corp tag api
     */
    CorpTagApi agent(AgentDetails agent) {
        this.withAgent(agent);
        return this;
    }

    /**
     * 获取企业标签库
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the customer strategy detail response
     */
    public <R extends CorpTagIterator> GenericResponse<List<CorpTagGroup>> corpTagList(R request) {

        String endpoint = WeComEndpoint.CORP_TAG_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<List<CorpTagGroup>>>() {
        });
    }

    /**
     * 添加企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<CorpTagGroup> addCorpTag(CorpTagAddRequest request) {
        String endpoint = WeComEndpoint.CORP_TAG_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<CorpTagGroup>>() {
        });
    }

    /**
     * 编辑企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse editCorpTag(CorpTagEditRequest request) {
        String endpoint = WeComEndpoint.CORP_TAG_EDIT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除企业客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends AgentCorpTagIterator> WeComResponse delCorpTag(R request) {
        String endpoint = WeComEndpoint.CORP_TAG_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 管理企业规则组下的客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends StrategyCorpTagIterator> GenericResponse<List<CorpTagGroup>> strategyCorpTagList(R request) {

        String endpoint = WeComEndpoint.CORP_TAG_STRATEGY_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<List<CorpTagGroup>>>() {
        });
    }

    /**
     * 为指定规则组创建企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<CorpTagGroup> addStrategyCorpTag(CorpTagStrategyAddRequest request) {

        String endpoint = WeComEndpoint.CORP_TAG_STRATEGY_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<CorpTagGroup>>() {
        });
    }

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse editStrategyCorpTag(CorpTagStrategyEditRequest request) {

        String endpoint = WeComEndpoint.CORP_TAG_STRATEGY_EDIT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends CorpTagIterator> WeComResponse delStrategyCorpTag(R request) {

        String endpoint = WeComEndpoint.CORP_TAG_STRATEGY_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 编辑客户企业标签
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse markTag(CorpTagOptRequest request) {

        String endpoint = WeComEndpoint.CORP_TAG_MARK.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }
}
