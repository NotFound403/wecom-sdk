package cn.felord.domain.hr;

import lombok.Data;

/**
 * @author dax
 * @since 2023/8/3 14:52
 */
@Data
public abstract class FieldBase {
    private final Integer fieldid;
    private final Integer subIdx;
}
