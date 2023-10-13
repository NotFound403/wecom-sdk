package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Chain id.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class ChainId {
    private final String chainId;

    /**
     * Instantiates a new Chain id.
     *
     * @param chainId the chain id
     */
    ChainId(String chainId) {
        this.chainId = chainId;
    }

    public static ChainId from(String chainId) {
        return new ChainId(chainId);
    }
}
