package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * The type Miniprogram message body.
 *
 * @author felord
 * @since 2022 /11/22 16:07
 */
@Getter
public class MiniprogramMessageBody implements MessageBody {
    private final String msgtype = "miniprogram_notice";
    private final MiniprogramNotice miniprogramNotice;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    /**
     * Instantiates a new Miniprogram message body.
     *
     * @param miniprogramNotice the miniprogram notice
     */
    protected MiniprogramMessageBody(MiniprogramNotice miniprogramNotice) {
        this.miniprogramNotice = miniprogramNotice;
    }

    @Override
    public String getAgentid() {
        return null;
    }
}
