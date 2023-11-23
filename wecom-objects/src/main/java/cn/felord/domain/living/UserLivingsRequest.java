package cn.felord.domain.living;

import lombok.Data;

/**
 * @author dax
 * @since 2023/11/23
 */
@Data
public class UserLivingsRequest {
    /**
     * 企业成员的userid
     */
    private final String userid;
    /**
     * 上一次调用时返回的next_cursor，第一次拉取可以不填
     */
    private String cursor;
    /**
     * 每次拉取的数据量，建议填20，默认值和最大值都为100
     */
    private Integer limit;
}
