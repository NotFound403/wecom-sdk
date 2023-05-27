package cn.felord.domain.approval;

import cn.felord.domain.common.UserId;
import cn.felord.enumeration.SpStatus;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 15:55
 */
@Data
public class SpRecordDetail {
    private UserId approver;
    private String speech;
    private SpStatus spStatus;
    private Instant sptime;
    private List<String> mediaId;
}
