package cn.felord.domain.journal;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/27 17:29
 */
@Data
public class JournalExportRequest {
    private final String journaluuid;
    private final String docid;
}