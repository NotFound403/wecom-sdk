package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/8/23 15:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KfServicerResponse extends WeComResponse {

    private List<KfServicerResult> resultList;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class KfServicerResult extends WeComResponse {
        private String userid;
    }
}
