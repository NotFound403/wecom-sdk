package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfServiceStatus;
import cn.felord.enumeration.KfServicerType;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2021/8/23 16:57
 */
@Data
public class KfServicer {
    private String subId;
    private KfServiceStatus status;
    private KfServicerType type;

    @JsonAlias({"userid"})
    public void setUserid(String userid) {
        this.subId = userid;
        this.type = KfServicerType.USER;
    }

    @JsonAlias({"department_id"})
    public void setDepartmentId(String departmentId) {
        this.subId = departmentId;
        this.type = KfServicerType.DEPT;
    }
}
