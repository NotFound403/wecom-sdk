package cn.felord.domain.contactbook.linkedcorp;

import cn.felord.domain.contactbook.user.Extattr;
import lombok.Data;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/9/2 9:56
 */
@Data
public class CorpUserInfo {
    private String userid;
    private String name;
    private String mobile;
    private List<String> department;
    private String position;
    private String email;
    private String telephone;
    private String corpid;
    private Extattr extattr;
}
