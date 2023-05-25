package cn.felord.domain.approval;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 16:59
 */
@Data
public class FileConfig {
    private Wrapper file;

    @Data
    public static class Wrapper {
        private BoolEnum isOnlyPhoto;
    }
}
