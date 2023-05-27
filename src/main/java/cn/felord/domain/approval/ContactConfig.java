package cn.felord.domain.approval;

import cn.felord.enumeration.ContactCtrlMode;
import cn.felord.enumeration.SingleOrMulti;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/25 16:31
 */
@Data
public class ContactConfig {
    private Wrapper contact;

    @Data
    public static class Wrapper {
        private SingleOrMulti type;
        private ContactCtrlMode mode;
    }
}
