
package cn.felord.domain.corpay.external.account;


import cn.felord.enumeration.PayBusinessId;
import cn.felord.enumeration.PayOrgType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/6/29
 */
@Data
public class MchAccountRequest {

    private final String outRequestNo;
    private final PayOrgType organizationType;
    private final BusinessLicenseInfo businessLicenseInfo;
    private FinanceInstitutionInfo financeInstitutionInfo;
    private final String merchantShortName;
    private final IdCardInfo idCardInfo;
    private Boolean owner;
    private IdCardInfo uboInfo;
    private final ContactInfoWrapper contactInfo;
    private final AccountInfo accountInfo;
    private final PayBusinessId businessId;
    private MediaIds qualifications;
    private MediaIds businessAdditionPics;
    private final String userid;
}
