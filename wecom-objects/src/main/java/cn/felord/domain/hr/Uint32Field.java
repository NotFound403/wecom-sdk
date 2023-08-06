package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type Uint 32 field.
 *
 * @author dax
 * @since 2023 /8/3 18:23
 */
@Getter
public class Uint32Field extends FieldBase {
    private final Long valueUint32;

    /**
     * Instantiates a new Uint 32 field.
     *
     * @param fieldid     the fieldid
     * @param valueUint32 the value uint 32
     */
    public Uint32Field(Integer fieldid, Long valueUint32) {
        this(fieldid, null, valueUint32);
    }

    /**
     * Instantiates a new Uint 32 field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueUint32 the value uint 32
     */
    public Uint32Field(Integer fieldid, Integer subIdx, Long valueUint32) {
        super(fieldid, subIdx);
        this.valueUint32 = valueUint32;
    }
}
