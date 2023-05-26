package cn.felord.domain.approval;

import cn.felord.enumeration.ContactCtrlMode;
import cn.felord.enumeration.SingleOrMulti;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 16:31
 */
@Data
@JsonTypeName("ContactConfig")
public class ContactConfig {
    private Wrapper contact;

    @Data
    public static class Wrapper {
        private SingleOrMulti type;
        private ContactCtrlMode mode;
    }
}
