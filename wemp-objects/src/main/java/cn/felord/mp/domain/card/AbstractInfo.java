package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 封面摘要结构体名称
 *
 * @author xiafang
 * @since 2023/8/18 17:06
 */
@Data
public class AbstractInfo {
    @JsonProperty("abstract")
    private String info;
    private List<String> iconUrlList;
}
