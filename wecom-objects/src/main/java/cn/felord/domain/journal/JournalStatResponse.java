package cn.felord.domain.journal;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JournalStatResponse extends WeComResponse {
    private List<JournalStat> statList;
}