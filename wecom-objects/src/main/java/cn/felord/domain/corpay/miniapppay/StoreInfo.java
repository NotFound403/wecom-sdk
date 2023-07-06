package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class StoreInfo {
    private final String id;
    private String name;
    private String areaCode;
    private String address;
}