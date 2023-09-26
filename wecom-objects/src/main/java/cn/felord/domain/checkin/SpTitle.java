package cn.felord.domain.checkin;

import cn.felord.domain.approval.ApprovalTitle;
import lombok.Data;

import java.util.List;

@Data
public class SpTitle {
    private List<ApprovalTitle> data;
}