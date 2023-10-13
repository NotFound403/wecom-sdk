package cn.felord.domain.corpgroup;

import cn.felord.enumeration.ImportStatus;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/13
 */
@Data
public class JobResult {
    private String chainId;
    private ImportStatus importStatus;
    private List<FailedCorp> failList;
}
