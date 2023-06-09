package cn.felord.domain.common;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/24 16:23
 */
@Data
public class CursorPage {
    private final String cursor;
    private final int pageSize;
}
