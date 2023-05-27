package cn.felord.domain.approval;

import cn.felord.enumeration.ApproverNodeMode;
import cn.felord.enumeration.SpStatus;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 15:53
 */
@Data
public class SpRecordItem {
   private SpStatus spStatus;
   private ApproverNodeMode approverattr;
   private List<SpRecordDetail> details;
}
