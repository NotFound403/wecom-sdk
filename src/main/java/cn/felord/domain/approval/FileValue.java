package cn.felord.domain.approval;

import cn.felord.domain.common.FileId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/26
 */
@ToString
@Getter
public class FileValue implements ContentDataValue {
    private final List<FileId> files;

    @JsonCreator
    public FileValue(@JsonProperty("files") List<FileId> files) {
        this.files = files;
    }
}
