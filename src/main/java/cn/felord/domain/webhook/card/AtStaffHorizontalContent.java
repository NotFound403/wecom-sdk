package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * The type At staff horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:33
 */
@Getter
public class AtStaffHorizontalContent extends HorizontalContent {
    private final String userid;

    /**
     * Instantiates a new At staff horizontal content.
     *
     * @param keyname the keyname
     * @param userid  the userid
     */
    public AtStaffHorizontalContent(String keyname, String userid) {
       this(keyname, userid, null);
    }

    /**
     * Instantiates a new At staff horizontal content.
     *
     * @param keyname the keyname
     * @param userid  the userid
     * @param value   the value
     */
    public AtStaffHorizontalContent(String keyname, String userid, String value) {
        super(HorizontalContentType.AT_STAFF, keyname, value);
        this.userid = userid;
    }

    /**
     * 需要开启ID转译 {@code enable_id_trans}
     *
     * @param keyname the keyname
     * @param userid  the userid
     * @return the at staff horizontal content
     */
    public static AtStaffHorizontalContent withTransUserId(String keyname, String userid) {
        return new AtStaffHorizontalContent(keyname, userid, "$userName=" + userid + "$");
    }

}
