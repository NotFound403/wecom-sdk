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

import lombok.Getter;
import lombok.ToString;

/**
 * The WatchStatRequest
 *
 * @author dax
 * @since 2024/11/23
 */
@ToString
@Getter
public class WatchStatRequest {
    /**
     * 直播id
     */
    private final String livingid;
    /**
     * 上一次调用时返回的next_key，初次调用可以填"0"
     */
    private final String nextKey;

    public WatchStatRequest(String livingid) {
        this(livingid, "0");
    }

    public WatchStatRequest(String livingid, String nextKey) {
        this.livingid = livingid;
        this.nextKey = nextKey;
    }
}
