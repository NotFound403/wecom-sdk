package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Duration;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/8 16:28
 */
@Data
public class MutableContactWay {
    private final String configId;
    private MiniProgramStyle style;
    private String remark;
    private Boolean skipVerify;
    private String state;
    private String unionid;
    private Set<String> user;
    private Set<Integer> party;
    private Boolean isTemp;
    private Duration expiresIn;
    private Duration chatExpiresIn;
    private Boolean isExclusive;
    private Conclusions conclusions;
}
