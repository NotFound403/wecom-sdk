package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type String field.
 *
 * @author dax
 * @since 2023 /8/3 14:55
 */
@Getter
public class StringField extends FieldBase {
    private final String valueString;

    /**
     * Instantiates a new String field.
     *
     * @param fieldid     the fieldid
     * @param valueString the value string
     */
    public StringField(Integer fieldid, String valueString) {
        this(fieldid, null, valueString);
    }

    /**
     * Instantiates a new String field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueString the value string
     */
    public StringField(Integer fieldid, Integer subIdx, String valueString) {
        super(fieldid, subIdx);
        this.valueString = valueString;
    }
}
