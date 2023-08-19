package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * The type Decrypt code request.
 *
 * @author dax
 * @since 2023 /8/19
 */
@Data
public class DecryptCodeRequest {
    private final String encryptCode;
}
