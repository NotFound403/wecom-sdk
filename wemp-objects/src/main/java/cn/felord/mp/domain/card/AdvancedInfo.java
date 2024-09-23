/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.BusinessService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
 * 卡券高级信息
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@Getter
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

    /**
     * Instantiates a new Advanced info.
     */
    public AdvancedInfo() {
    }

    /**
     * Instantiates a new Advanced info.
     *
     * @param useCondition    the use condition
     * @param abstractInfo    the abstract info
     * @param textImageList   the text image list
     * @param timeLimit       the time limit
     * @param businessService the business service
     */
    @JsonCreator
    AdvancedInfo(@JsonProperty("use_condition") UseCondition useCondition,
                 @JsonProperty("abstract") AbstractInfo abstractInfo,
                 @JsonProperty("text_image_list") List<TextImage> textImageList,
                 @JsonProperty("time_limit") List<WeekDayLimit> timeLimit,
                 @JsonProperty("business_service") Set<BusinessService> businessService) {
        this.useCondition = useCondition;
        this.abstractInfo = abstractInfo;
        this.textImageList = textImageList;
        this.timeLimit = timeLimit;
        this.businessService = businessService;
    }

    /**
     * Sets use condition.
     *
     * @param useCondition the use condition
     * @return the use condition
     */
    public AdvancedInfo useCondition(UseCondition useCondition) {
        this.useCondition = useCondition;
        return this;
    }

    /**
     * Abstract info advanced info.
     *
     * @param abstractInfo the abstract info
     * @return the advanced info
     */
    public AdvancedInfo abstractInfo(AbstractInfo abstractInfo) {
        this.abstractInfo = abstractInfo;
        return this;
    }

    /**
     * Text image list advanced info.
     *
     * @param textImageList the text image list
     * @return the advanced info
     */
    public AdvancedInfo textImageList(List<TextImage> textImageList) {
        this.textImageList = textImageList;
        return this;
    }

    /**
     * Time limit advanced info.
     *
     * @param timeLimit the time limit
     * @return the advanced info
     */
    public AdvancedInfo timeLimit(List<WeekDayLimit> timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    /**
     * Business service advanced info.
     *
     * @param businessService the business service
     * @return the advanced info
     */
    public AdvancedInfo businessService(Set<BusinessService> businessService) {
        this.businessService = businessService;
        return this;
    }
}
