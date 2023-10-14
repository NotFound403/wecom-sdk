package cn.felord.domain.journal;

import java.util.List;

import lombok.Data;

@Data
public class WhiteRange {
    private List<Object> tagList;
    private List<Object> partyList;
    private List<Object> userList;
}