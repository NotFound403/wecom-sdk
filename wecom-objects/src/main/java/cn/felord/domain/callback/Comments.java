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

package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;

/**
 * 备注
 *
 * @author dax
 * @since 2023/5/27
 */
@Data
public class Comments {
    @XStreamAlias("CommentUserInfo")
    private CallbackUserId commentUserInfo;
    @XStreamAlias("CommentTime")
    private Instant commentTime;
    //todo 备注不太对 有空研究
    @XStreamAlias("CommentContent")
    private String commentContent;
    @XStreamAlias("CommentId")
    private String commentId;
}

