
package cn.felord.domain.corpay.external.account;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/29
 */
@Data
public class BankCardSupplement {
    private List<String> otherCertificateOpenWxPayMediaId;
    private String relationshipCertificateOpenWxPayMediaId;
    private String settlementCertificateOpenWxPayMediaId;
}
