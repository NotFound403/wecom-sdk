package cn.felord.domain.corpay.internal;

import cn.felord.domain.callback.Xml;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Objects;

/**
 * @author dax
 * @since 2023/6/26 13:50
 */
@Data
public abstract class AbstractXmlResponse implements Xml {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("err_code")
    private String errCode;
    @XStreamAlias("err_code_des")
    private String errCodeDes;


    public final boolean isSuccessful() {
        return Objects.equals(returnCode, "SUCCESS") &&
                Objects.equals(resultCode, "SUCCESS");
    }
}
