package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * The BillResponse.
 *
 * @author dax
 * @since 2023 /7/7 10:11
 */
@Data
public class BillResponse {
    private String auth;
    private String downloadUrl;
    private String hashValue;
    private String hashType;
}