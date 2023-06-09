package cn.felord.domain.common;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/24 13:06
 */
@Data
public class PageRequest {
    private String cursor;
    private Integer limit;
}
