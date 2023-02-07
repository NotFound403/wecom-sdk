package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.Set;

/**
 * @author felord
 * @since 2021/11/22 11:42
 */
@Data
public class CalendarDetail {
    private String calId;
    private String organizer;
    private BoolEnum readonly;
    private String summary;
    private String color;
    private String description;
    private BoolEnum isPublic;
    private PublicRange publicRange;
    private BoolEnum isCorpCalendar;
    private Set<CalendarSharer> shares;
}
