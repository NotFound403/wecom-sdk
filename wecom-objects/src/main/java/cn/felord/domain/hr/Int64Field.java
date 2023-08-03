package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type Uint 64 field.
 *
 * @author dax
 * @since 2023 /8/3 18:23
 */
@Getter
public class Int64Field extends FieldBase {
    private final Long valueInt64;

    /**
     * Instantiates a new Int 64 field.
     *
     * @param fieldid    the fieldid
     * @param valueInt64 the value int 64
     */
    public Int64Field(Integer fieldid, Long valueInt64) {
        this(fieldid, null, valueInt64);
    }

    /**
     * Instantiates a new Int 64 field.
     *
     * @param fieldid    the fieldid
     * @param subIdx     the sub idx
     * @param valueInt64 the value int 64
     */
    public Int64Field(Integer fieldid, Integer subIdx, Long valueInt64) {
        super(fieldid, subIdx);
        this.valueInt64 = valueInt64;
    }
}
