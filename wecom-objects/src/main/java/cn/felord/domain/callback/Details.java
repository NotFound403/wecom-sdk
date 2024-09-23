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

import cn.felord.enumeration.NodeStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Details.
 *
 * @author dax
 * @since 2024/5/27
 */
@Data
public class Details {
    @XStreamAlias("Approver")
    private CallbackUserId approver;
    @XStreamAlias("Speech")
    private String speech;
    @XStreamAlias("SpStatus")
    private NodeStatus spStatus;
    @XStreamAlias("SpTime")
    private Instant spTime;
    @XStreamImplicit(itemFieldName = "Attach")
    private final List<String> attaches;
}

