package cn.felord.domain.callcenter;

import lombok.Data;

/**
 * @author dax
 * @since 2023/6/3
 */
@Data
public class KfLocation {
    private String latitude;
    private String longitude;
    private String name;
    private String address;
}
