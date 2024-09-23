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

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.CreateType;
import cn.felord.enumeration.MomentVisibleType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/8/21 19:14
 */
@Data
public class MomentDetail {
    private String momentId;
    private String creator;
    private Instant createTime;
    private MomentVisibleType visibleType;
    private CreateType createType;
    private ContentText text;
    private List<MediaId> image;
    private MomentDetailVideo video;
    private MomentLink link;
    private MomentLocation location;

}
