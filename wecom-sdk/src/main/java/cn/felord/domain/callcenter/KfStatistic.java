
package cn.felord.domain.callcenter;


import lombok.Data;

import java.time.Instant;

@Data
public class KfStatistic<T> {
    private Instant statTime;
    private T statistic;


}
