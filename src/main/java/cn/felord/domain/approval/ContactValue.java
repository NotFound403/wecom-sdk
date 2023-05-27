package cn.felord.domain.approval;

import cn.felord.enumeration.ContactCtrlMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * The type Contact value.
 *
 * @author dax
 * @since 2023 /5/27 10:31
 */
@ToString
@Getter
public class ContactValue implements ContentDataValue {
    @JsonIgnore
    private final ContactCtrlMode contactCtrlMode;
    private final List<MemberInfo> members;
    private final List<DeptInfo> departments;

    /**
     * Instantiates a new Contact value.
     *
     * @param members     the members
     * @param departments the departments
     */
    @JsonCreator
    ContactValue(@JsonProperty("members") List<MemberInfo> members, @JsonProperty("departments") List<DeptInfo> departments) {
        this.contactCtrlMode = CollectionUtils.isEmpty(members) ? ContactCtrlMode.DEPARTMENT : ContactCtrlMode.USER;
        this.members = members;
        this.departments = departments;
    }

    /**
     * Members contact value.
     *
     * @param members the members
     * @return the contact value
     */
    public static ContactValue members(List<MemberInfo> members) {
        return new ContactValue(members, Collections.emptyList());
    }

    public static ContactValue departments(List<DeptInfo> departments) {
        return new ContactValue(Collections.emptyList(), departments);
    }

    /**
     * The type Member info.
     */
    @Data
    public static class MemberInfo {
        private final String userid;
        private final String name;
    }

    /**
     * The type Dept info.
     */
    @Data
    public static class DeptInfo {
        private final Long openapiId;
        private final String name;
    }
}
