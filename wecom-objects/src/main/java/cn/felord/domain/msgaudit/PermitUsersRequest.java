package cn.felord.domain.msgaudit;

import cn.felord.enumeration.MsgAuditEditionType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Permit users request.
 *
 * @author dax
 * @since 2023 /12/1
 */
@ToString
@Getter
public class PermitUsersRequest {
    /**
     * 版本
     */
    private final MsgAuditEditionType type;

    /**
     * Instantiates a new Permit users request.
     *
     * @param type the type
     */
    PermitUsersRequest(MsgAuditEditionType type) {
        this.type = type;
    }

    /**
     * 办公版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest office() {
        return new PermitUsersRequest(MsgAuditEditionType.OFFICE);
    }

    /**
     * 服务版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest service() {
        return new PermitUsersRequest(MsgAuditEditionType.SERVICE);
    }

    /**
     * 企业版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest corp() {
        return new PermitUsersRequest(MsgAuditEditionType.CORP);
    }
}
