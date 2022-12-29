package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author xiafang
 * @since 2022/12/29 17:07
 */
@Data
public class UnassignedInfo {
    private String handoverUserid;
    private String externalUserid;
    private Instant dimissionTime;
}
