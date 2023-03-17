package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FillOutAuth;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * @author dax
 * @since 2023/3/13 17:03
 */
@ToString
@Getter
@Setter
public class FormSettingDetail {
    private final FillOutAuth fillOutAuth;
    private FillInRange fillInRange;
    private Set<String> settingManagerRange;
    private TimedRepeatInfoDetail timedRepeatInfo;
    private Integer maxFillCnt;
    private Integer timedFinish;
    private Boolean canAnonymous;
    private Boolean canNotifySubmit;

    @JsonCreator
    public FormSettingDetail(@JsonProperty("fill_out_auth") FillOutAuth fillOutAuth) {
        this.fillOutAuth = fillOutAuth;
    }
}
