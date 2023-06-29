package cn.felord.domain.corpay.external;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/29 14:01
 */
@Data
public class MchScope {
    private List<String> user;
    private List<Long> partyid;
    private List<Long> tagid;
}
