package cn.felord.domain.living;

import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/11/23
 */
@ToString
@Getter
public class LivingId {
    private final String livingid;

    public LivingId(String livingid) {
        this.livingid = livingid;
    }
}
