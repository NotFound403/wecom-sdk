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
 * 模板卡片
 *
 * @param <M> the type parameter
 * @author felord
 * @see TemplateCardBuilders
 * @since 2021 /11/22 16:07
 */
@ToString
@Getter
public class TemplateCardMessageBody<M extends AbstractCard> extends AbstractMessageBody {
    private final M templateCard;
    private final BoolEnum enableIdTrans;

    /**
     * Instantiates a new Template card message body.
     *
     * @param touser                 the touser
     * @param toparty                the toparty
     * @param totag                  the totag
     * @param enableIdTrans          the enable id trans
     * @param enableDuplicateCheck   the enable duplicate check
     * @param duplicateCheckInterval the duplicate check interval
     * @param templateCard           the template card
     */
    protected TemplateCardMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, M templateCard) {
        super("template_card", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.templateCard = templateCard;
        this.enableIdTrans = enableIdTrans;
    }


    /**
     * The type Builder.
     *
     * @param <M> the type parameter
     */
    public static class Builder<M extends AbstractCard> implements MessageBodyBuilder {
        private final M templateCard;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        /**
         * Instantiates a new Builder.
         *
         * @param templateCard the template card
         */
        protected Builder(M templateCard) {
            this.templateCard = templateCard;
        }


        @Override
        public Builder<M> touser(String touser) {
            this.touser = touser;
            return this;
        }

        @Override
        public String touser() {
            return this.touser;
        }

        @Override
        public Builder<M> toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        @Override
        public String toparty() {
            return this.toparty;
        }

        @Override
        public Builder<M> totag(String totag) {
            this.totag = totag;
            return this;
        }

        @Override
        public String totag() {
            return this.totag;
        }

        /**
         * Enable id trans builder.
         *
         * @param enableIdTrans the enable id trans
         * @return the builder
         */
        public Builder<M> enableIdTrans(BoolEnum enableIdTrans) {
            this.enableIdTrans = enableIdTrans;
            return this;
        }


        /**
         * Enable duplicate check builder.
         *
         * @param enableDuplicateCheck the enable duplicate check
         * @return the builder
         */
        public Builder<M> enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        /**
         * Duplicate check interval builder.
         *
         * @param duplicateCheckInterval the duplicate check interval
         * @return the builder
         */
        public Builder<M> duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        /**
         * Build template card message body.
         *
         * @return the template card message body
         */
        public TemplateCardMessageBody<M> build() {
            return new TemplateCardMessageBody<>(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, templateCard);
        }

    }
}
