package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import cn.felord.enumeration.RejectSwitch;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class RejectCustomerMsgKfEvent extends KfEvent {

    private final String servicerUserid;
    private final RejectSwitch rejectSwitch;

    @JsonCreator
    public RejectCustomerMsgKfEvent(@JsonProperty("open_kfid")String openKfid,
                                    @JsonProperty("external_userid") String externalUserid,
                                    @JsonProperty("servicer_userid")String servicerUserid,
                                    @JsonProperty("reject_switch") RejectSwitch rejectSwitch) {
        super(KfEventType.REJECT_CUSTOMER_MSG_SWITCH_CHANGE,openKfid,externalUserid);
        this.servicerUserid = servicerUserid;
        this.rejectSwitch = rejectSwitch;
    }
}
