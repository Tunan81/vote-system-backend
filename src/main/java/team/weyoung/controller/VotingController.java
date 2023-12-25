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
import team.weyoung.model.entity.Voting;
import team.weyoung.service.IVotingService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 投票表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/voting")
public class VotingController {
//
//    @Resource
//    private IVotingService iVotingService;
//
//    /**
//     * 添加投票表。
//     *
//     * @param voting 投票表
//     * @return {@code true} 添加成功，{@code false} 添加失败
//     */
//    @PostMapping("save")
//    public boolean save(@RequestBody Voting voting) {
//        return iVotingService.save(voting);
//    }
//
//    /**
//     * 根据主键删除投票表。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return iVotingService.removeById(id);
//    }
//
//    /**
//     * 根据主键更新投票表。
//     *
//     * @param voting 投票表
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    public boolean update(@RequestBody Voting voting) {
//        return iVotingService.updateById(voting);
//    }
//
//    /**
//     * 查询所有投票表。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<Voting> list() {
//        return iVotingService.list();
//    }
//
//    /**
//     * 根据投票表主键获取详细信息。
//     *
//     * @param id 投票表主键
//     * @return 投票表详情
//     */
//    @GetMapping("getInfo/{id}")
//    public Voting getInfo(@PathVariable Serializable id) {
//        return iVotingService.getById(id);
//    }
//
//    /**
//     * 分页查询投票表。
//     *
//     * @param page 分页对象
//     * @return 分页对象
//     */
//    @GetMapping("page")
//    public Page<Voting> page(Page<Voting> page) {
//        return iVotingService.page(page);
//    }

}
