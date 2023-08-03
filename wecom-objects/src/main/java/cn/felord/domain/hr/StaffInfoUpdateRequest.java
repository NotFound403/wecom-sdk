package cn.felord.domain.hr;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author dax
 * @since 2023/8/3 14:46
 */
@Data
public class StaffInfoUpdateRequest {
    private final String userid;
    private List<? extends FieldBase> updateItems;
    private Set<RemoveIdx> removeItems;
    private Set<NewGroup> insertItems;
}
