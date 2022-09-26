package cn.felord.domain.callcenter;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/9/26 15:20
 */
@Data
public class KfServicerRequest {
   private final String openKfid;
   private List<String> useridList;
   private List<Integer> departmentIdList;
}
