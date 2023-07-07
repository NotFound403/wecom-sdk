package cn.felord.domain.corpay.miniapppay;

import cn.felord.enumeration.MiniApyBillType;
import lombok.Data;

import java.time.LocalDate;

/**
 * The type Bill request.
 *
 * @author dax
 * @since 2023 /7/7 10:11
 */
@Data
public class BillRequest {
    private final LocalDate billDate;
    private final String mchid;
    private final String tarType;
    private MiniApyBillType billType;


    /**
     * Instantiates a new Bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param tarType  the tar type
     * @param billType the bill type
     */
    BillRequest(LocalDate billDate, String mchid, String tarType, MiniApyBillType billType) {
        this.billDate = billDate;
        this.mchid = mchid;
        this.tarType = tarType;
        this.billType = billType;
    }

    /**
     * Stream bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @return the bill request
     */
    public static BillRequest stream(LocalDate billDate, String mchid) {
        return new BillRequest(billDate, mchid, null, null);
    }

    /**
     * Stream bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param billType the bill type
     * @return the bill request
     */
    public static BillRequest stream(LocalDate billDate, String mchid, MiniApyBillType billType) {
        return new BillRequest(billDate, mchid, null, billType);
    }

    /**
     * Gzip bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @return the bill request
     */
    public static BillRequest gzip(LocalDate billDate, String mchid) {
        return new BillRequest(billDate, mchid, "GZIP", null);
    }

    /**
     * Gzip bill request.
     *
     * @param billDate the bill date
     * @param mchid    the mchid
     * @param billType the bill type
     * @return the bill request
     */
    public static BillRequest gzip(LocalDate billDate, String mchid, MiniApyBillType billType) {
        return new BillRequest(billDate, mchid, "GZIP", billType);
    }
}
