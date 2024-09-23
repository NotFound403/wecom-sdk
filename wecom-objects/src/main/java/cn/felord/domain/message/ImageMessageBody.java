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

import cn.felord.domain.common.MediaId;
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
public class ImageMessageBody extends AbstractMessageBody {
    private final MediaId image;

    protected ImageMessageBody(String touser, String toparty, String totag, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MediaId image) {
        super("image", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.image = image;
    }

    public static class Builder implements MessageBodyBuilder {
        private final MediaId file;
        private String touser;
        private String toparty;
        private String totag;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;


        protected Builder(MediaId file) {
            this.file = file;
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
        public ImageMessageBody build() {
            return new ImageMessageBody(touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval, file);
        }

    }
}
