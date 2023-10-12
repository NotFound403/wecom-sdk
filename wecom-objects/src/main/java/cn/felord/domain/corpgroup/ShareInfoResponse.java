package cn.felord.domain.corpgroup;

import cn.felord.domain.CursorWeComResponse;
import cn.felord.enumeration.BoolEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The type Share info response.
 *
 * @author dax
 * @since 2023 /10/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShareInfoResponse extends CursorWeComResponse {
    private BoolEnum ending;
    private List<CorpInfo> corpList;
}
