package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 14:30
 */
@Data
public class TemplateContent {
    private List<TmpControl<?>> controls;
}
