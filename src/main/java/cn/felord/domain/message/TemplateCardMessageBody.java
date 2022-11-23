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
public class TemplateCardMessageBody<M extends MessageTemplateCard> implements MessageBody {
    private final String msgtype = "template_card";
    private final String agentid;
    private final M templateCard;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    /**
     * Instantiates a new Template card message body.
     *
     * @param templateCard the template card
     */
    protected TemplateCardMessageBody(M templateCard) {
        this(null, templateCard);
    }

    /**
     * Instantiates a new Template card message body.
     *
     * @param agentid      the agentid
     * @param templateCard the template card
     */
    protected TemplateCardMessageBody(String agentid, M templateCard) {
        this.agentid = agentid;
        this.templateCard = templateCard;
    }

}
