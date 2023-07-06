package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class SceneInfo {
    private final String payerClientIp;
    private StoreInfo storeInfo;
    private String deviceId;
}