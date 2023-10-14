package cn.felord.domain.approval;

import cn.felord.domain.wedrive.FileId;
import lombok.Data;

import java.util.List;

/**
 * The type Wedrive file value.
 *
 * @author dax
 * @since 2023 /10/14
 */
@Data
public class WedriveFileValue implements ContentDataValue {
    private List<FileId> wedriveFiles;
}
