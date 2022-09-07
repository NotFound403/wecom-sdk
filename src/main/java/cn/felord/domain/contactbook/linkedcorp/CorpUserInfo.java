package cn.felord.domain.contactbook.linkedcorp;

import cn.felord.domain.contactbook.user.Extattr;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author felord.cn
 * @since 2021/9/2 9:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CorpUserInfo extends CorpSimpleUserInfo {
    private String mobile;
    private String position;
    private String email;
    private String telephone;
    private Extattr extattr;
}
