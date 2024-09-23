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

package cn.felord.domain.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * The type File opt record request.
 *
 * @author dax
 * @since 2024/5/27 14:48
 */
@ToString
@Getter
@RequiredArgsConstructor
public class FileOptRecordRequest {
    /**
     * 开始时间
     */
    private final Instant startTime;
    /**
     * 结束时间，开始时间到结束时间的范围不能超过14天
     */
    private final Instant endTime;
    /**
     * 由企业微信后台返回，第一次调用可不填
     */
    private String cursor;
    /**
     * 限制返回的条数，最多设置为1000
     */
    private Integer limit;
    /**
     * 操作信息
     */
    private Operation operation;
    /**
     * 需要查询的文件操作者的userid，单次最多可以传100个用户
     */
    private List<String> useridList;

    /**
     * Cursor file opt record request.
     *
     * @param cursor the cursor
     * @return the file opt record request
     */
    public FileOptRecordRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Limit file opt record request.
     *
     * @param limit the limit
     * @return the file opt record request
     */
    public FileOptRecordRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Operation file opt record request.
     *
     * @param operation the operation
     * @return the file opt record request
     */
    public FileOptRecordRequest operation(Operation operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Userid list file opt record request.
     *
     * @param useridList the userid list
     * @return the file opt record request
     */
    public FileOptRecordRequest useridList(List<String> useridList) {
        this.useridList = useridList;
        return this;
    }
}
