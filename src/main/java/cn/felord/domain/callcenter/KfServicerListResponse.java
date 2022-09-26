package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/9/26 15:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KfServicerListResponse extends WeComResponse {
    private List<KfServicer> servicerList;
}
