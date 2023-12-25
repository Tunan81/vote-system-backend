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
import team.weyoung.model.entity.Competition;
import team.weyoung.service.ICompetitionService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 比赛表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Resource
    private ICompetitionService iCompetitionService;

//    /**
//     * 添加比赛表。
//     *
//     * @param competition 比赛表
//     * @return {@code true} 添加成功，{@code false} 添加失败
//     */
//    @PostMapping("save")
//    public boolean save(@RequestBody Competition competition) {
//        return iCompetitionService.save(competition);
//    }
//
//    /**
//     * 根据主键删除比赛表。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return iCompetitionService.removeById(id);
//    }
//
//    /**
//     * 根据主键更新比赛表。
//     *
//     * @param competition 比赛表
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    public boolean update(@RequestBody Competition competition) {
//        return iCompetitionService.updateById(competition);
//    }
//
//    /**
//     * 查询所有比赛表。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<Competition> list() {
//        return iCompetitionService.list();
//    }
//
//    /**
//     * 根据比赛表主键获取详细信息。
//     *
//     * @param id 比赛表主键
//     * @return 比赛表详情
//     */
//    @GetMapping("getInfo/{id}")
//    public Competition getInfo(@PathVariable Serializable id) {
//        return iCompetitionService.getById(id);
//    }
//
//    /**
//     * 分页查询比赛表。
//     *
//     * @param page 分页对象
//     * @return 分页对象
//     */
//    @GetMapping("page")
//    public Page<Competition> page(Page<Competition> page) {
//        return iCompetitionService.page(page);
//    }

}
