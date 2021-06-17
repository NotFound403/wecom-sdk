package cn.felord.enumeration;

/**
 * The enum Dept user fetch type.
 *
 * @author n1
 * @since 2021 /6/17 16:19
 */
public enum DeptUserFetchType {
    /**
     * 本部门
     */
    THIS("0"),
    /**
     * 递归获取
     */
    ALL("1");
    private final String type;

    DeptUserFetchType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
