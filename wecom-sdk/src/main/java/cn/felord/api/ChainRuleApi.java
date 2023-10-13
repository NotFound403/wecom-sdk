package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.corpgroup.ChainId;
import cn.felord.domain.corpgroup.ChainRule;
import cn.felord.domain.corpgroup.ChainRuleAddRequest;
import cn.felord.domain.corpgroup.ChainRuleModifyRequest;
import cn.felord.domain.corpgroup.RuleInfo;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 上下游规则
 * <p>
 * 上下游系统应用调用
 *
 * @author dax
 * @since 2023 /10/13
 */
public interface ChainRuleApi {

    /**
     * 获取对接规则id列表
     * <p>
     * 上下游系统应用可通过该接口获取企业上下游规则id列表
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param chainId the chain id
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/rule/list_ids")
    GenericResponse<List<Integer>> listIds(@Body ChainId chainId) throws WeComException;

    /**
     * 删除对接规则
     * <p>
     * 上下游系统应用可通过该接口删除企业上下游规则
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param chainRule the chain rule
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/rule/delete_rule")
    WeComResponse deleteRule(@Body ChainRule chainRule) throws WeComException;

    /**
     * Gets rule info.
     *
     * @param chainRule the chain rule
     * @return the rule info
     * @throws WeComException the weComException
     */
    @POST("corpgroup/rule/get_rule_info")
    GenericResponse<RuleInfo> getRuleInfo(@Body ChainRule chainRule) throws WeComException;

    /**
     * 新增对接规则
     * <p>
     * 上下游系统应用可通过该接口新增一条对接规则
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/rule/add_rule")
    GenericResponse<Integer> addRule(@Body ChainRuleAddRequest request) throws WeComException;

    /**
     * 更新对接规则
     * <p>
     * 上下游应用可通过该接口修改一条对接规则
     * <p>
     * 仅上下游应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/rule/modify_rule")
    WeComResponse modifyRule(@Body ChainRuleModifyRequest request) throws WeComException;
}
