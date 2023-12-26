package team.weyoung.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import team.weyoung.model.dto.competition.ContestantUploadDTO;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.service.IContestantInfoService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SuppressWarnings("all")
public class UploadDTOListener extends AnalysisEventListener<ContestantUploadDTO> {

    private IContestantInfoService iContestantInfoService;

    private Long competitionId;

    private List<ContestantUploadDTO> list = new ArrayList<>();

    public UploadDTOListener(IContestantInfoService iContestantInfoService,Long competitionId) {
        super();
        this.competitionId = competitionId;
        this.iContestantInfoService = iContestantInfoService;
    }

    @Override
    public void invoke(ContestantUploadDTO contestantUploadDTO, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", contestantUploadDTO);
        list.add(contestantUploadDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
        List<ContestantInfo> contestantInfoList = new ArrayList<>();
        for (ContestantUploadDTO contestantUploadDTO : list) {
            ContestantInfo contestantInfo = new ContestantInfo();
            contestantInfo.setContestantName(contestantUploadDTO.getContestantName());
            contestantInfo.setSongName(contestantUploadDTO.getSongName());
            contestantInfo.setCompetitionId(competitionId);
            contestantInfoList.add(contestantInfo);
        }
        iContestantInfoService.saveBatch(contestantInfoList);
    }
}
