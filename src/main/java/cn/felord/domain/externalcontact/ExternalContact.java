package cn.felord.domain.externalcontact;

import cn.felord.domain.contactbook.user.ExternalProfile;
import cn.felord.enumeration.ContactUserType;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/8 18:22
 */
@Data
public class ExternalContact {
    private String externalUserid;
    private String name;
    private String position;
    private String avatar;
    private String corpName;
    private String corpFullName;
    private ContactUserType type;
    private Integer gender;
    private String unionid;
    private ExternalProfile externalProfile;
}
