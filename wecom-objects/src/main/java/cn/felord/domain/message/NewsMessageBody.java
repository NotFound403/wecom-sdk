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

package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;
import lombok.ToString;

/**
 * @author felord
 * @since 2021/11/22 17:22
 */
@ToString
@Getter
public class NewsMessageBody extends AbstractMessageBody {
    private final MessageNews<NewsArticle> news;
    private final BoolEnum enableIdTrans;


    protected NewsMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageNews<NewsArticle> news) {
        super("news", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.news = news;
        this.enableIdTrans = enableIdTrans;
    }

    public static class Builder implements MessageBodyBuilder {
        private final MessageNews<NewsArticle> news;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageNews<NewsArticle> news) {
            this.news = news;
        }


        @Override
        public Builder touser(String touser) {
            this.touser = touser;
            return this;
        }

        @Override
        public String touser() {
            return this.touser;
        }

        @Override
        public Builder toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        @Override
        public String toparty() {
            return this.toparty;
        }

        @Override
        public Builder totag(String totag) {
            this.totag = totag;
            return this;
        }

        @Override
        public String totag() {
            return this.totag;
        }

        public Builder enableIdTrans(BoolEnum enableIdTrans) {
            this.enableIdTrans = enableIdTrans;
            return this;
        }


        public Builder enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        public Builder duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        @Override
        public NewsMessageBody build() {
            return new NewsMessageBody(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, news);
        }

    }
}
