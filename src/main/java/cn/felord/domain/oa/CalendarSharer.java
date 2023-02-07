package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

/**
 * @author felord
 * @since 2021/11/22 10:36
 */
@Data
public class CalendarSharer {
    private final String userid;
    private final BoolEnum readonly;

    public CalendarSharer(String userid) {
        this(userid, BoolEnum.TRUE);
    }

    public CalendarSharer(String userid, BoolEnum readonly) {
        this.userid = userid;
        this.readonly = readonly;
    }
}
