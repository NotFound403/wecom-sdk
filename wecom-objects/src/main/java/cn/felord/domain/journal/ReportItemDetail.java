package cn.felord.domain.journal;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/10/14
 */
@Data
public class ReportItemDetail {
    private String journaluuid;
    private BoolEnum flag;
    private Instant reporttime;
}