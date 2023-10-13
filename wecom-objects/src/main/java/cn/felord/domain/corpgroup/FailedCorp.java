package cn.felord.domain.corpgroup;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/13
 */
@Data
public class FailedCorp {
    private String corpName;
    private String customId;
    private Integer errcode;
    private String errmsg;
    private List<FailedContact> contactInfoList;
}
