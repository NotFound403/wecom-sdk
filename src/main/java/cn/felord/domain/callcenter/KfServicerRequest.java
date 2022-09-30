package cn.felord.domain.callcenter;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/8/23 15:20
 */
@Data
public class KfServicerRequest {
   private final String openKfid;
   private List<String> useridList;
   private List<Integer> departmentIdList;
}
