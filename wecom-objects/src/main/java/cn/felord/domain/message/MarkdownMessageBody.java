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

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import lombok.Getter;
import lombok.ToString;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@ToString
@Getter
public class MarkdownMessageBody extends AbstractMessageBody {
    private final ContentText markdown;

    protected MarkdownMessageBody(String touser, String toparty, String totag, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, ContentText markdown) {
        super("markdown", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.markdown = markdown;
    }

    public static class Builder implements MessageBodyBuilder {
        private final ContentText markdown;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;


        protected Builder(ContentText markdown) {
            this.markdown = markdown;
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

        public Builder enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        public Builder duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        @Override
        public MarkdownMessageBody build() {
            return new MarkdownMessageBody(touser, toparty, totag, enableDuplicateCheck, duplicateCheckInterval, markdown);
        }

    }
}
