package cn.felord.domain.corpay.external;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.MchBindStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/29 13:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MchDetailResponse extends WeComResponse {
    private String mchId;
    private String merchantName;
    private MchBindStatus bindStatus;
    private MchScope allowUseScope;
}
