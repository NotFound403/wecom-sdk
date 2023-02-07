package cn.felord.domain.message;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

/**
 * 更新按钮为不可点击状态
 *
 * @author dax
 * @since 2023 /2/7 10:16
 */
@Getter
public class UpdateDisabledBtnRequest extends AbstractUpdateTemplateCardRequest {
    private Set<Integer> tagids;
    private Integer atall;
    private final Btn button;

    public UpdateDisabledBtnRequest(String agentid, String responseCode, Btn button) {
        super(agentid, responseCode);
        this.button = button;
    }

    public UpdateDisabledBtnRequest tagids(Set<Integer> tagids) {
        this.tagids = tagids;
        return this;
    }

    public UpdateDisabledBtnRequest atall(Integer atall) {
        this.atall = atall;
        return this;
    }

    /**
     * The type Btn.
     */
    @Data
    public static class Btn {
        private final String replaceName;
    }

}
