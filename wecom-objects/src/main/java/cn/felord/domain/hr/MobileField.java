package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type Mobile field.
 *
 * @author dax
 * @since 2023 /8/3 14:55
 */
@Getter
public class MobileField extends FieldBase {
    private final ValueMobile valueMobile;

    /**
     * Instantiates a new Mobile field.
     *
     * @param fieldid     the fieldid
     * @param valueMobile the value mobile
     */
    public MobileField(Integer fieldid, ValueMobile valueMobile) {
        this(fieldid, null, valueMobile);
    }

    /**
     * Instantiates a new Mobile field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueMobile the value mobile
     */
    public MobileField(Integer fieldid, Integer subIdx, ValueMobile valueMobile) {
        super(fieldid, subIdx);
        this.valueMobile = valueMobile;
    }
}
