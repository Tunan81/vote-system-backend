package team.weyoung.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.service.IContestantInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 选项信息表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/contestantInfo")
public class ContestantInfoController {

    @Resource
    private IContestantInfoService iContestantInfoService;

//    /**
//     * 添加选项信息表。
//     *
//     * @param contestantInfo 选项信息表
//     * @return {@code true} 添加成功，{@code false} 添加失败
//     */
//    @PostMapping("save")
//    public boolean save(@RequestBody ContestantInfo contestantInfo) {
//        return iContestantInfoService.save(contestantInfo);
//    }
//
//    /**
//     * 根据主键删除选项信息表。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return iContestantInfoService.removeById(id);
//    }
//
//    /**
//     * 根据主键更新选项信息表。
//     *
//     * @param contestantInfo 选项信息表
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    public boolean update(@RequestBody ContestantInfo contestantInfo) {
//        return iContestantInfoService.updateById(contestantInfo);
//    }
//
//    /**
//     * 查询所有选项信息表。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<ContestantInfo> list() {
//        return iContestantInfoService.list();
//    }
//
//    /**
//     * 根据选项信息表主键获取详细信息。
//     *
//     * @param id 选项信息表主键
//     * @return 选项信息表详情
//     */
//    @GetMapping("getInfo/{id}")
//    public ContestantInfo getInfo(@PathVariable Serializable id) {
//        return iContestantInfoService.getById(id);
//    }
//
//    /**
//     * 分页查询选项信息表。
//     *
//     * @param page 分页对象
//     * @return 分页对象
//     */
//    @GetMapping("page")
//    public Page<ContestantInfo> page(Page<ContestantInfo> page) {
//        return iContestantInfoService.page(page);
//    }

}
