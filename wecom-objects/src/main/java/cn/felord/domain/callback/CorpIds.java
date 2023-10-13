package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * The type Corp ids.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class CorpIds {
    @XStreamImplicit(itemFieldName = "CorpId")
    private final List<String> corpIds;

    /**
     * Instantiates a new Corp ids.
     *
     * @param corpIds the corp ids
     */
    public CorpIds(String... corpIds) {
        this.corpIds = Arrays.asList(corpIds);
    }
}
