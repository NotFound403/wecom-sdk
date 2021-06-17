package cn.felord.domain.contactbook.department;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/17 15:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateDeptResponse extends WeComResponse {
    private String id;
}
