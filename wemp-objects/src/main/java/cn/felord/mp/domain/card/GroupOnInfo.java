/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 团购券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@Data
public class GroupOnInfo {
    private final BaseInfo baseInfo;
    /**
     * 团购券专用，团购详情。
     * <p>
     * 双人套餐\n -进口红酒一支。\n孜然牛肉一份。
     */
    private final String dealDetail;
    private AdvancedInfo advancedInfo;
}
