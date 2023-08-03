package cn.felord.domain.hr;

import lombok.Getter;

import java.util.List;

/**
 * The type Staff info request.
 *
 * @author dax
 * @since 2023 /8/3 11:42
 */
@Getter
public class StaffInfoRequest {
    private final String userid;
    private Boolean getAll;
    private List<FieldId> fieldids;

    /**
     * Instantiates a new Staff info request.
     *
     * @param userid the userid
     */
    public StaffInfoRequest(String userid) {
        this.userid = userid;
        this.getAll = true;
    }

    /**
     * Instantiates a new Staff info request.
     *
     * @param userid   the userid
     * @param fieldids the fieldids
     */
    public StaffInfoRequest(String userid, List<FieldId> fieldids) {
        this.userid = userid;
        this.fieldids = fieldids;
    }
}
