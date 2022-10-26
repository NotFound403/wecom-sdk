package cn.felord.domain.contactbook.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author xiafang
 * @since 2022/10/12 16:48
 */
@Data
public class DeptUser {
    @JsonAlias({"open_userid","userid"})
    private String userid;
    private Integer department;
}
