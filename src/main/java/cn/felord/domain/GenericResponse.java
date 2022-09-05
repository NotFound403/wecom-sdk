package cn.felord.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 对于类似该结构的进行统一泛型封装
 *
 * @author n1
 * @since 2021/6/17 17:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GenericResponse<T> extends WeComResponse {
    @JsonAlias({"openid",
            "id",
            "userid",
            "join_qrcode",
            "userlist",
            "user_info",
            "department_id",
            "department",
            "active_cnt",
            "tagid",
            "taglist",
            "jobid",
            "ip_list",
            "external_userid"
    })
    private T data;
}
