package cn.felord.domain.oa;

import cn.felord.enumeration.SharePermission;
import lombok.Data;

/**
 * @author felord
 * @since 2021/11/22 10:36
 */
@Data
public class CalendarSharer {
    private final String userid;
    private final SharePermission permission;

    public CalendarSharer(String userid) {
        this(userid, SharePermission.READ_ALL);
    }

    public CalendarSharer(String userid, SharePermission permission) {
        this.userid = userid;
        this.permission = permission;
    }
}
