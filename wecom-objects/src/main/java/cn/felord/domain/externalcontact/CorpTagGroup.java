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

package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * 标签组
 *
 * @author dax
 * @since 2021/7/12 16:50
 */
@Data
public class CorpTagGroup {

    /**
     * 标签组id
     */
    private String groupId;
    /**
     * 标签组名称
     */
    private String groupName;
    /**
     * 标签组创建时间
     */
    private Instant createTime;
    /**
     * 标签组排序的次序值，order值大的排序靠前。有效的值范围是[0, 2^32)
     */
    private Long order;
    /**
     * 标签组是否已经被删除，只在指定tag_id进行查询时返回
     */
    private Boolean deleted;
    /**
     * 标签组内的标签列表
     */
    private List<CorpTag> tag;
}
