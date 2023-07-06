package cn.felord.domain.corpay.external.account;

import lombok.Data;

@Data
public class AccountValidation {
    private String destinationAccountBank;
    private String city;
    private String destinationAccountNumber;
    private String accountName;
    private Integer payAmount;
    private String remark;
    private String deadline;
    private String accountNo;
    private String destinationAccountName;
}