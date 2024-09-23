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
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;
import lombok.ToString;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@ToString
@Getter
public class TextMessageBody extends AbstractMessageBody {

    private final ContentText text;
    private final BoolEnum enableIdTrans;


    protected TextMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, ContentText text) {
        super("text", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.text = text;
        this.enableIdTrans = enableIdTrans;
    }


    public static class Builder implements MessageBodyBuilder {
        private final ContentText text;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(ContentText text) {
            this.text = text;
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

        public Builder safe(MessageSafe safe) {
            this.safe = safe;
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
        public TextMessageBody build() {
            return new TextMessageBody(touser, toparty, totag, enableIdTrans, safe, enableDuplicateCheck, duplicateCheckInterval, text);
        }

    }
}
