package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FillOutAuth;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2023/3/13 17:03
 */
@Data
public class FormSetting {
    private final FillOutAuth fillOutAuth;
    private FillInRange fillInRange;
    private Set<String> settingManagerRange;
    private TimedRepeatInfo timedRepeatInfo;
    private Integer maxFillCnt;
    private Integer timedFinish;
    private Boolean canAnonymous;
    private Boolean canNotifySubmit;

}
