package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/9 16:11
 */
@Data
public class CustomerRemarkRequest {
    private final String userid;
    private final String externalUserid;
    private String remark;
    private String description;
    private String remarkCompany;
    private List<String> remarkMobiles;
    private String remarkPicMediaid;

}
