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

package cn.felord.domain.externalcontact;

import cn.felord.enumeration.InterceptType;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/8/23 11:28
 */
@Data
public class InterceptRuleDetail {
    private final String ruleId;
    private final String ruleName;
    private final Set<String> wordList;
    private ExtraInterceptRule extraRule;
    private final InterceptType interceptType;
    private final ApplicableRange applicableRange;
}