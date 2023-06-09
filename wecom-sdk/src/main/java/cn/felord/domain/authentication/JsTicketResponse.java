package cn.felord.domain.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/5/24 17:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JsTicketResponse extends AbstractTokenResponse {
    private String ticket;

    @Override
    public String getToken() {
        return ticket;
    }
}
