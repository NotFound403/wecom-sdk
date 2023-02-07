package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * 更新为新的卡片
 *
 * @param <C> the type parameter
 * @author dax
 * @see TemplateReplaceCardBuilders
 * @since 2022 /2/7 10:55
 */
@Getter
public class UpdateNewTemplateCardRequest<C extends AbstractReplaceCard> extends AbstractUpdateTemplateCardRequest {
    private final BoolEnum enableIdTrans;
    private final C templateCard;

    /**
     * Instantiates a new Update new template card request.
     *
     * @param agentid       the agentid
     * @param responseCode  the response code
     * @param enableIdTrans the enable id trans
     * @param templateCard  the template card
     */
    public UpdateNewTemplateCardRequest(String agentid, String responseCode, BoolEnum enableIdTrans, C templateCard) {
        super(agentid, responseCode);
        this.enableIdTrans = enableIdTrans;
        this.templateCard = templateCard;
    }
}
