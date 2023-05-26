package cn.felord.domain.approval;

import cn.felord.jackson.MyJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 14:30
 */
@Data
@JsonDeserialize(using = MyJsonDeserializer.class)
public class TemplateContent {
    private List<TmpControl<?>> controls;
}
