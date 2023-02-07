package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.Set;

/**
 * @author felord
 * @since 2021/11/22 11:34
 */
@Data
public class CalendarUpdateBody {
    private final String calId;
    private BoolEnum readonly;
    private final String summary;
    private final String color;
    private String description;
    private PublicRange publicRange;
    private Set<CalendarSharer> shares;
}
