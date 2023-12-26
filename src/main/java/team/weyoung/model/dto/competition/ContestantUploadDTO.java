package team.weyoung.model.dto.competition;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ContestantUploadDTO {

    /**
     * 选手姓名
     */
    @ExcelProperty(value = "选手姓名", index = 0)
    private String contestantName;

    /**
     * 选择的歌曲
     */
    @ExcelProperty(value = "歌曲名称", index = 1)
    private String songName;
}
