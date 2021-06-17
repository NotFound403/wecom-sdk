package cn.felord.enumeration;

/**
 * The enum User qrcode size.
 *
 * @author n1
 * @since 2021 /6/17 17:52
 */
public enum UserQrcodeSize {
    /**
     * 171 x 171
     */
    SIZE_171("1"),
    /**
     * 399 x 399
     */
    SIZE_399("2"),
    /**
     * 741 x 741
     */
    SIZE_741("3"),
    /**
     * 2052 x 2052
     */
    SIZE_2052("4");
    private final String size;

    UserQrcodeSize(String size) {
        this.size = size;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public String type() {
        return size;
    }

}
