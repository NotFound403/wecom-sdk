package cn.felord.domain.oa;

import lombok.Data;

import java.util.Set;

/**
 * @author felord
 * @since 2022/11/22 10:33
 */
@Data
public class PublicRange {
    private final Set<String> userids;
    private final Set<String> partyids;
}
