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

package cn.felord.domain.wedoc.smartsheet;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 智能表数据行值
 *
 * @author dax
 * @since 2024 /12/23
 */
@ToString
@Getter
public class RecordValues {

    private final Map<String, Object> values = new HashMap<>();

    /**
     * 创建一行数据
     *
     * @return the record values
     */
    public static RecordValues row() {
        return new RecordValues();
    }

    /**
     * 文本
     *
     * @param key   the key
     * @param texts the texts
     * @return the record values
     */
    public RecordValues text(String key, List<String> texts) {
        this.values.put(key, texts.stream().map(CellTextValue::text).collect(Collectors.toList()));
        return this;
    }

    /**
     * 数字
     *
     * @param key    the key
     * @param number the number
     * @return the record values
     */
    public RecordValues number(String key, double number) {
        this.values.put(key, number);
        return this;
    }

    /**
     * 复选框
     *
     * @param key     the key
     * @param checked the checked
     * @return the record values
     */
    public RecordValues checkBox(String key, boolean checked) {
        this.values.put(key, checked);
        return this;
    }

    /**
     * 日期
     *
     * @param key      the key
     * @param dateTime the date time
     * @return the record values
     */
    public RecordValues dateTime(String key, Instant dateTime) {
        this.values.put(key, String.valueOf(dateTime.toEpochMilli()));
        return this;
    }

    /**
     * 图片
     *
     * @param key    the key
     * @param images the images
     * @return the record values
     */
    public RecordValues image(String key, List<CellImageValue> images) {
        this.values.put(key, images);
        return this;
    }

    /**
     * 文件
     *
     * @param key        the key
     * @param attachment the attachment
     * @return the record values
     */
    public RecordValues attachment(String key, List<CellAttachmentValue> attachment) {
        this.values.put(key, attachment);
        return this;
    }

    /**
     * 成员
     *
     * @param key     the key
     * @param userIds the user ids
     * @return the record values
     */
    public RecordValues user(String key, List<String> userIds) {
        this.values.put(key, userIds.stream().map(CellUserValue::new).collect(Collectors.toList()));
        return this;
    }

    /**
     * 链接
     *
     * @param key  the key
     * @param urls the urls
     * @return the record values
     */
    public RecordValues url(String key, CellUrlValue urls) {
        return url(key, Collections.singletonList(urls));
    }

    /**
     * 链接
     * <p>
     * 数组类型为预留能力，目前只支持展示一个链接，建议只传入一个链接
     *
     * @param key  the key
     * @param urls the urls
     * @return the record values
     */
    public RecordValues url(String key, List<CellUrlValue> urls) {
        this.values.put(key, urls);
        return this;
    }

    /**
     * 单选与多选
     *
     * @param key     the key
     * @param options the options
     * @return the record values
     */
    public RecordValues option(String key, List<SelectFieldOption> options) {
        this.values.put(key, options);
        return this;
    }

    /**
     * 进度
     *
     * @param key        the key
     * @param percentage the percentage
     * @return the record values
     */
    public RecordValues progress(String key, double percentage) {
        this.values.put(key, percentage);
        return this;
    }

    /**
     * 电话
     *
     * @param key         the key
     * @param phoneNumber the phone number
     * @return the record values
     */
    public RecordValues phoneNumber(String key, String phoneNumber) {
        this.values.put(key, phoneNumber);
        return this;
    }

    /**
     * 邮箱
     *
     * @param key   the key
     * @param email the email
     * @return the record values
     */
    public RecordValues email(String key, String email) {
        this.values.put(key, email);
        return this;
    }

    /**
     * 地理位置
     *
     * @param key      the key
     * @param location the location
     * @return the record values
     */
    public RecordValues location(String key, CellLocationValue location) {
        this.values.put(key, Collections.singletonList(location));
        return this;
    }

    /**
     * 货币
     *
     * @param key      the key
     * @param currency the currency
     * @return the record values
     */
    public RecordValues currency(String key, double currency) {
        this.values.put(key, currency);
        return this;
    }
}
