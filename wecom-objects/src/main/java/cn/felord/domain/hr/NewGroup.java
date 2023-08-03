package cn.felord.domain.hr;

import cn.felord.enumeration.FieldGroupType;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/8/3 18:40
 */
@Data
public class NewGroup {
    private FieldGroupType groupType;
    private List<? extends FieldBase> item;
}
