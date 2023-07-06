
package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.IdDocType;
import cn.felord.enumeration.PayContactType;
import lombok.Data;

import java.time.LocalDate;

/**
 * 超级管理员信息
 *
 * @author dax
 * @see <a href="https://developer.work.weixin.qq.com/document/path/98973#contact_info">超级管理员信息参数说明</a>
 * @since 2023/6/29
 */
@Data
public class ContactInfoWrapper {

    private PayContactType contactType;
    private String businessAuthorizationLetterOpenWxPayMediaId;
    private String contactEmail;
    private ContactInfo contactInfo;
    private String mobilePhone;

    @Data
    public static class ContactInfo {
        private final String idCardCopyOpenWxPayMediaId;
        private String idCardNationalOpenWxPayMediaId;
        private final String idCardName;
        private final String idCardNumber;
        private final LocalDate idCardValidTimeBegin;
        //  yyyy-MM-dd  或者 长期
        private final String idCardValidTime;
        private final IdDocType idDocType;
    }

}
