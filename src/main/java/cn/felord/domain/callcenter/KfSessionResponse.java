package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.KfServiceState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiafang
 * @since 2022/9/30 13:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KfSessionResponse extends WeComResponse {
    private KfServiceState serviceState;
    private String servicerUserid;
}
