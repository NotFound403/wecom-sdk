
package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.IdDocType;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author dax
 * @since 2023/6/29
 */
@Data
public class IdCardInfo {

    private final String idCardCopyOpenWxPayMediaId;
    private String idCardNationalOpenWxPayMediaId;
    private final String idCardName;
    private final String idCardNumber;
    private String idCardAddress;
    private final LocalDate idCardValidTimeBegin;
    //  yyyy-MM-dd  或者 长期
    private final String idCardValidTime;
    private IdDocType idDocType;

}
