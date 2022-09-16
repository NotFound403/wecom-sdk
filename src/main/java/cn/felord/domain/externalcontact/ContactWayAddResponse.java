package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/7/8 13:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContactWayAddResponse extends WeComResponse {
    private String configId;
    private String qrCode;
}
