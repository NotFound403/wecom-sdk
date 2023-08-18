package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.BusinessService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 卡券高级信息
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class AdvancedInfo {
    /**
     * 使用门槛（条件）字段，
     * 若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
     */
    private UseCondition useCondition;
    /**
     * 封面摘要结构体名称
     */
    @JsonProperty("abstract")
    private AbstractInfo abstractInfo;
    /**
     * 图文列表，显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
     */
    private List<TextImage> textImageList;
    /**
     * 使用时段限制
     */
    private List<WeekDayLimit> timeLimit;
    /**
     * 商家服务类型
     */
    private Set<BusinessService> businessService;
}