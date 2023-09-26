package cn.felord.domain.checkin;

import lombok.Data;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public class UserCheckinGroup {
    private String userid;
    private CheckinGroup group;
}
