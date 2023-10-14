package cn.felord.domain.journal;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.BoolEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JournalRecordResponse extends WeComResponse {
    private List<String> journaluuidList;
    private Integer nextCursor;
    private BoolEnum endflag;
}