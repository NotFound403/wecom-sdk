package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:33
 */
@Getter
public class AtStaffHorizontalContent extends HorizontalContent {
    private final String userid;
    public AtStaffHorizontalContent(String keyname, String userid) {
        super(HorizontalContentType.AT_STAFF, keyname);
        this.userid = userid;
    }
}
