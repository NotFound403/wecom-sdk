package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentInteractionType;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * Deserialized by {@code InteractionUserJsonDeserializer}
 *
 * @author dax
 * @since 2021/10/20 15:22
 */
@Getter
@ToString
public class InteractionUser {
    private String virtualUserid;
    private Instant createTime;
    private MomentInteractionType type;

    @JsonAlias({"external_userid"})
    public void setExternalUserid(String externalUserid) {
        this.virtualUserid = externalUserid;
        this.type = MomentInteractionType.EXTERNAL;
    }
    @JsonAlias({"userid"})
    public void setUserid(String userid) {
        this.virtualUserid = userid;
        this.type = MomentInteractionType.INTERNAL;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }
}
