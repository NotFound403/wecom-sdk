package cn.felord.domain.corpgroup;

import lombok.Data;

/**
 * @author dax
 * @since 2023/10/13
 */
@Data
public class FailedContact {
    private String mobile;
    private Integer errcode;
    private String errmsg;
}
