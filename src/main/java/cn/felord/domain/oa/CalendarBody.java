package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.Set;

/**
 * @author felord
 * @since 2021/11/22 10:28
 */
@Data
public class CalendarBody {
    private final String organizer;
    private BoolEnum readonly;
    private BoolEnum setAsDefault;
    private final String summary;
    private final String color;
    private String description;
    private BoolEnum isPublic;
    private PublicRange publicRange;
    private BoolEnum isCorpCalendar;
    private Set<CalendarSharer> shares;
}
