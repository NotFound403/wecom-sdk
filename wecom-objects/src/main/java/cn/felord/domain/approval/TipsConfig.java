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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Tips config.
 *
 * @author dax
 * @since 2024 /1/24
 */
@ToString
@Getter
public class TipsConfig implements ControlConfig {
    private final Tips tips;

    /**
     * Instantiates a new Tips config.
     *
     * @param tips the tips
     */
    @JsonCreator
    TipsConfig(@JsonProperty("tips") Tips tips) {
        this.tips = tips;
    }

    /**
     * Instantiates a new Tips config.
     *
     * @param tipsContent the tips content
     * @return the tips config
     * @see TipsContent#zhCN(List)
     * @see TipsContent#from(String, List)
     */
    public static TipsConfig from(List<TipsContent> tipsContent) {
        return new TipsConfig(new Tips(tipsContent));
    }
}
