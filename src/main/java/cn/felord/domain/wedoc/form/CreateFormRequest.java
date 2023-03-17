package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/3/10 9:35
 */
@Data
public class CreateFormRequest {
    private String spaceId;
    private String fatherid;
    private FormInfo formInfo;
}
