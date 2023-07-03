package cn.felord.domain.corpay.external.account;

import lombok.Data;

@Data
public class AuditDetailItem {
    private String rejectReason;
    private String paramName;
}