package cn.felord.domain.callback;

import lombok.Data;

/**
 * @author xiafang
 * @since 2022/10/12 20:30
 */
@Data
public class CallbackCrypt {
    private final String token;
    private final String encodingAesKey;
    private final String receiveid;
}
