package cn.felord.domain;

import lombok.Data;

/**
 * The type Abstract response.
 *
 * @author n1
 * @since 2021 /6/16 9:53
 */
@Data
public class WeComResponse {
    private Integer errcode;
    private String errmsg;

    /**
     * Is successful boolean.
     *
     * @return the boolean
     */
    public boolean isSuccessful() {
        return errcode == 0;
    }

}
