package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type Uint 64 field.
 *
 * @author dax
 * @since 2023 /8/3 18:23
 */
@Getter
public class Uint64Field extends FieldBase {
    private final Long valueUint64;

    /**
     * Instantiates a new Uint 64 field.
     *
     * @param fieldid     the fieldid
     * @param valueUint64 the value uint 64
     */
    public Uint64Field(Integer fieldid, Long valueUint64) {
        this(fieldid, null, valueUint64);
    }

    /**
     * Instantiates a new Uint 64 field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueUint64 the value uint 64
     */
    public Uint64Field(Integer fieldid, Integer subIdx, Long valueUint64) {
        super(fieldid, subIdx);
        this.valueUint64 = valueUint64;
    }
}
