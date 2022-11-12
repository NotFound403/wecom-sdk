package cn.felord.domain.callback;

import cn.felord.callbacks.WeComCallbackException;
import lombok.Getter;
import org.springframework.util.Base64Utils;

/**
 * The type Callback authentication.
 *
 * @author xiafang
 * @since 2022 /10/12 20:30
 */
@Getter
public class CallbackAuthentication {
    private final String token;
    private final byte [] aesKey;
    private final String receiveid;

    /**
     * Instantiates a new Callback authentication.
     *
     * @param token          the token
     * @param encodingAesKey the encoding aes key
     * @param receiveid      the receiveid
     */
    public CallbackAuthentication(String token, String encodingAesKey, String receiveid) {
        if (encodingAesKey.length() != 43) {
            throw new WeComCallbackException(WeComCallbackException.IllegalAesKey);
        }
        this.token = token;
        this.aesKey = Base64Utils.decodeFromString(encodingAesKey + "=");
        this.receiveid = receiveid;
    }
}
