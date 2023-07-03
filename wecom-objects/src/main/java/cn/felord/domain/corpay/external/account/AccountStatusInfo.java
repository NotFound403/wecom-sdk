package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.AccountSignState;
import cn.felord.enumeration.ApplymentState;
import lombok.Data;

import java.util.List;

@Data
public class AccountStatusInfo {
    private ApplymentState applymentState;
    private String applymentStateDesc;
    private AccountSignState signState;
    private String signUrl;
    private String subMchid;
    private List<AuditDetailItem> auditDetail;
    private AccountValidation accountValidation;
    private String legalValidationUrl;
}