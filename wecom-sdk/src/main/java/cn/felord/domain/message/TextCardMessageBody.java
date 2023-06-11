/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@Getter
public class TextCardMessageBody extends AbstractMessageBody {

    private final MessageTextCard textcard;
    private final BoolEnum enableIdTrans;

    protected TextCardMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageTextCard textcard) {
        super("textcard", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.textcard = textcard;

        this.enableIdTrans = enableIdTrans;
    }


    public static class Builder {
        private final MessageTextCard textcard;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageTextCard textcard) {
            this.textcard = textcard;
        }

        public Builder touser(String touser) {
            this.touser = touser;
            return this;
        }

        public Builder toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        public Builder totag(String totag) {
            this.totag = totag;
            return this;
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

        public TextCardMessageBody build() {
            return new TextCardMessageBody(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, textcard);
        }

    }
}
