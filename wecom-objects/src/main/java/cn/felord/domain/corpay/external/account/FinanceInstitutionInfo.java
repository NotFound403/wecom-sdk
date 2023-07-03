
package cn.felord.domain.corpay.external.account;

import cn.felord.enumeration.FinanceType;
import lombok.Data;

import java.util.List;

/**
 * 金融机构许可证参数说明
 *
 * @author dax
 * @since 2023/6/29
 */
@Data
public class FinanceInstitutionInfo {

    private FinanceType financeType;
    private List<String> financeLicensePicsOpenWxPayMediaId;

}
