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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardStatus;
import lombok.Data;

import java.util.List;

/**
 * The type Batch card request.
 */
@Data
public class BatchCardRequest {
    /**
     * 查询卡列表的起始偏移量，从0开始，
     * 即offset: 5是指从从列表里的第六个开始读取。
     */
    private final Integer offset;
    /**
     * 需要查询的卡片的数量（数量最大50）
     */
    private final Integer count;
    private final List<CardStatus> statusList;

    /**
     * Instantiates a new Batch card request.
     *
     * @param offset the offset
     * @param count  the count
     */
    public BatchCardRequest(Integer offset, Integer count) {
        this(offset, count, null);
    }

    /**
     * Instantiates a new Batch card request.
     *
     * @param offset     the offset
     * @param count      the count
     * @param statusList the status list
     */
    public BatchCardRequest(int offset, int count, List<CardStatus> statusList) {
        this.offset = offset;
        this.count = count;
        this.statusList = statusList;
    }
}
