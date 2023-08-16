package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 14:17
 */
@Data
public class ImageSetting {
    private Boolean cameraOnly;
    private UploadLimit uploadImageLimit;
}