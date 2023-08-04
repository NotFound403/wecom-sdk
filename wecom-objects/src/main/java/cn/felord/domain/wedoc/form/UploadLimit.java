package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 14:19
 */
@Data
public class UploadLimit {
    private Integer countLimitType;
    // [1,9]
    private Integer count;
    // mb, (0,3000]
    private Integer maxSize;
}
