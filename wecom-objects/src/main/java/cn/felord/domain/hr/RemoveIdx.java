package cn.felord.domain.hr;

import cn.felord.enumeration.FieldGroupType;
import lombok.Data;

/**
 * The type Remove idx.
 *
 * @author dax
 * @since 2023 /8/3 18:37
 */
@Data
public class RemoveIdx {
    private final FieldGroupType groupType;
    private Integer subIdx;
}
