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

package cn.felord.domain.living;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.BoolEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Watch stat response.
 *
 * @author dax
 * @since 2024/5/24 11:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WatchStatResponse extends WeComResponse {
    /**
     * 是否结束。FALSE表示还有更多数据，需要继续拉取，TRUE表示已经拉取完所有数据。
     * <p>
     * 注意只能根据该字段判断是否已经拉完数据
     */
    private BoolEnum ending;
    /**
     * 当前数据最后一个key值，如果下次调用带上该值则从该key值往后拉，用于实现分页拉取
     */
    private String nextKey;
    /**
     * 统计信息列表
     */
    private StatInfo statInfo;
}
