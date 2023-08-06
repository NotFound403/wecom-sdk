package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type File field.
 *
 * @author dax
 * @since 2023 /8/3 14:55
 */
@Getter
public class FileField extends FieldBase {
    private final ValueFile valueFile;

    /**
     * Instantiates a new File field.
     *
     * @param fieldid   the fieldid
     * @param valueFile the value file
     */
    public FileField(Integer fieldid, ValueFile valueFile) {
        this(fieldid, null, valueFile);
    }

    /**
     * Instantiates a new File field.
     *
     * @param fieldid   the fieldid
     * @param subIdx    the sub idx
     * @param valueFile the value file
     */
    public FileField(Integer fieldid, Integer subIdx, ValueFile valueFile) {
        super(fieldid, subIdx);
        this.valueFile = valueFile;
    }
}
