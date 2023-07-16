package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @see TableConfig
 * @since 2023/7/16 17:14
 */
@Data
public class ListContentDataValue implements ContentDataValue {
    private final List<? extends ContentDataValue> values;
}
