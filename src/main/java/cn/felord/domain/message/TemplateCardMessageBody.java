package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * The type Template card message body.
 *
 * @param <M> the type parameter
 * @author felord
 * @since 2022 /11/22 16:07
 */
@Getter
public class TemplateCardMessageBody<M extends AbstractCard> extends AbstractMessageBody {
    private final M templateCard;
    private final BoolEnum enableIdTrans;

    protected TemplateCardMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, M templateCard) {
        super("template_card", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.templateCard = templateCard;
        this.enableIdTrans = enableIdTrans;
    }


    public static class Builder<T extends AbstractCard> {
        private final T templateCard;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(T templateCard) {
            this.templateCard = templateCard;
        }

        public Builder<T> touser(String touser) {
            this.touser = touser;
            return this;
        }

        public Builder<T> toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        public Builder<T> totag(String totag) {
            this.totag = totag;
            return this;
        }

        public Builder<T> enableIdTrans(BoolEnum enableIdTrans) {
            this.enableIdTrans = enableIdTrans;
            return this;
        }


        public Builder<T> enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        public Builder<T> duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        public TemplateCardMessageBody<T> build() {
            return new TemplateCardMessageBody<>(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, templateCard);
        }

    }
}
