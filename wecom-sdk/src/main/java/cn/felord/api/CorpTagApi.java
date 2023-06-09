package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.AgentCorpTagIterator;
import cn.felord.domain.externalcontact.CorpTagAddRequest;
import cn.felord.domain.externalcontact.CorpTagEditRequest;
import cn.felord.domain.externalcontact.CorpTagGroup;
import cn.felord.domain.externalcontact.CorpTagIterator;
import cn.felord.domain.externalcontact.CorpTagOptRequest;
import cn.felord.domain.externalcontact.CorpTagStrategyAddRequest;
import cn.felord.domain.externalcontact.CorpTagStrategyEditRequest;
import cn.felord.domain.externalcontact.StrategyCorpTagIterator;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * The type Corp tag api.
 *
 * @author dax
 * @since 2021 /9/12 16:39
 */
public interface CorpTagApi {

    /**
     * 获取企业标签库
     *
     * @param request the request
     * @return the customer strategy detail response
     */
    @POST("externalcontact/get_corp_tag_list")
    Single<GenericResponse<List<CorpTagGroup>>> corpTagList(@Body CorpTagIterator request);

    /**
     * 添加企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_corp_tag")
    Single<GenericResponse<CorpTagGroup>> addCorpTag(@Body CorpTagAddRequest request);

    /**
     * 编辑企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/edit_corp_tag")
    Single<WeComResponse> editCorpTag(@Body CorpTagEditRequest request);

    /**
     * 删除企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/del_corp_tag")
    Single<WeComResponse> delCorpTag(@Body AgentCorpTagIterator request);

    /**
     * 管理企业规则组下的客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/get_strategy_tag_list")
    Single<GenericResponse<List<CorpTagGroup>>> strategyCorpTagList(@Body StrategyCorpTagIterator request);

    /**
     * 为指定规则组创建企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_strategy_tag")
    Single<GenericResponse<CorpTagGroup>> addStrategyCorpTag(@Body CorpTagStrategyAddRequest request);

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/edit_strategy_tag")
    Single<WeComResponse> editStrategyCorpTag(CorpTagStrategyEditRequest request);

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/del_strategy_tag")
    Single<WeComResponse> delStrategyCorpTag(@Body CorpTagIterator request);

    /**
     * 编辑客户企业标签
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/mark_tag")
    Single<WeComResponse> markTag(@Body CorpTagOptRequest request);
}
