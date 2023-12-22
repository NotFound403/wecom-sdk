package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * 获客链接
 *
 * @author dax
 * @since 2023 /12/22
 */
@ToString
@Getter
public class CaLinkKfMessageRequest extends KfMessageRequest {
    private final CaLink caLink;

    /**
     * Instantiates a new Ca link kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param linkUrl  the link url
     */
    public CaLinkKfMessageRequest(String touser, String openKfid, String linkUrl) {
        this(touser, openKfid, null, linkUrl);
    }

    /**
     * Instantiates a new Ca link kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param msgid    the msgid
     * @param linkUrl  the link url
     */
    public CaLinkKfMessageRequest(String touser, String openKfid, String msgid, String linkUrl) {
        super(touser, openKfid, msgid, KfMsgType.CA_LINK);
        this.caLink = new CaLink(linkUrl);
    }
}
