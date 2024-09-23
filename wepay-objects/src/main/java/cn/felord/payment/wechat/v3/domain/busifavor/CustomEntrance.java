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
package cn.felord.payment.wechat.v3.domain.busifavor;

import cn.felord.payment.wechat.enumeration.BusiFavorCodeDisplayMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 商家券核销规则-自定义入口
 * <p>
 * 卡详情页面，可选择多种入口引导用户。
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class CustomEntrance {

    /**
     * 可用门店id
     * <p>
     * 不可修改项
     */
    private String storeId;
    /**
     * 营销馆id
     */
    private String hallId;
    /**
     * 小程序入口
     */
    private MiniProgramsInfo miniProgramsInfo;
    /**
     * 商户公众号appid
     * <p>
     * 从券详情可跳转至公众号
     */
    private String appid;
    /**
     * code展示模式
     */
    private BusiFavorCodeDisplayMode codeDisplayMode;

    @JsonCreator
    CustomEntrance(@JsonProperty("store_id") String storeId,
                   @JsonProperty("hall_id") String hallId,
                   @JsonProperty("mini_programs_info") MiniProgramsInfo miniProgramsInfo,
                   @JsonProperty("APPID") String appid,
                   @JsonProperty("code_display_mode") BusiFavorCodeDisplayMode codeDisplayMode) {
        this.storeId = storeId;
        this.hallId = hallId;
        this.miniProgramsInfo = miniProgramsInfo;
        this.appid = appid;
        this.codeDisplayMode = codeDisplayMode;
    }

    /**
     * Store id custom entrance.
     *
     * @param storeId the store id
     * @return the custom entrance
     */
    public CustomEntrance storeId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    /**
     * Sets hall id.
     *
     * @param hallId the hall id
     * @return the hall id
     */
    public CustomEntrance hallId(String hallId) {
        this.hallId = hallId;
        return this;
    }

    /**
     * Sets mini programs info.
     *
     * @param miniProgramsInfo the mini programs info
     * @return the mini programs info
     */
    public CustomEntrance miniProgramsInfo(MiniProgramsInfo miniProgramsInfo) {
        this.miniProgramsInfo = miniProgramsInfo;
        return this;
    }

    /**
     * Sets appid.
     *
     * @param appid the appid
     * @return the appid
     */
    public CustomEntrance appid(String appid) {
        this.appid = appid;
        return this;
    }

    /**
     * Sets code display mode.
     *
     * @param codeDisplayMode the code display mode
     * @return the code display mode
     */
    public CustomEntrance codeDisplayMode(BusiFavorCodeDisplayMode codeDisplayMode) {
        this.codeDisplayMode = codeDisplayMode;
        return this;
    }
}
