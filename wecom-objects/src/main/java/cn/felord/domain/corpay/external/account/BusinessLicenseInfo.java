
package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.BusinessCertType;
import lombok.Data;

import java.time.LocalDate;

/**
 * 营业执照/登记证书
 *
 * @author dax
 * @see <a href="https://developer.work.weixin.qq.com/document/path/98973#business_license_info">营业执照、登记证书参数说明</a>
 * @since 2023/6/29
 */
@Data
public class BusinessLicenseInfo {

    private final String businessLicenseCopyOpenWxPayMediaId;
    private final String businessLicenseNumber;
    private final String legalPerson;
    private final String merchantName;
    private BusinessCertType certType;
    private LocalDate businessTimeBeginTime;
    private LocalDate businessTimeEndTime;
    private String companyAddress;

}
