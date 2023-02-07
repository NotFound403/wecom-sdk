package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * 模板卡片
 *
 * @param <M> the type parameter
 * @author felord
 * @see TemplateCardBuilders
 * @since 2021 /11/22 16:07
 */
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
    public static class Builder<M extends AbstractCard> {
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

        /**
         * Touser builder.
         *
         * @param touser the touser
         * @return the builder
         */
        public Builder<M> touser(String touser) {
            this.touser = touser;
            return this;
        }

        /**
         * Toparty builder.
         *
         * @param toparty the toparty
         * @return the builder
         */
        public Builder<M> toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        /**
         * Totag builder.
         *
         * @param totag the totag
         * @return the builder
         */
        public Builder<M> totag(String totag) {
            this.totag = totag;
            return this;
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
