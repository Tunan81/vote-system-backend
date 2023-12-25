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
import team.weyoung.model.entity.MatchInfo;
import team.weyoung.service.IMatchInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 对战信息表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/matchInfo")
public class MatchInfoController {

//    @Resource
//    private IMatchInfoService iMatchInfoService;
//
//    /**
//     * 添加对战信息表。
//     *
//     * @param matchInfo 对战信息表
//     * @return {@code true} 添加成功，{@code false} 添加失败
//     */
//    @PostMapping("save")
//    public boolean save(@RequestBody MatchInfo matchInfo) {
//        return iMatchInfoService.save(matchInfo);
//    }
//
//    /**
//     * 根据主键删除对战信息表。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return iMatchInfoService.removeById(id);
//    }
//
//    /**
//     * 根据主键更新对战信息表。
//     *
//     * @param matchInfo 对战信息表
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    public boolean update(@RequestBody MatchInfo matchInfo) {
//        return iMatchInfoService.updateById(matchInfo);
//    }
//
//    /**
//     * 查询所有对战信息表。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<MatchInfo> list() {
//        return iMatchInfoService.list();
//    }
//
//    /**
//     * 根据对战信息表主键获取详细信息。
//     *
//     * @param id 对战信息表主键
//     * @return 对战信息表详情
//     */
//    @GetMapping("getInfo/{id}")
//    public MatchInfo getInfo(@PathVariable Serializable id) {
//        return iMatchInfoService.getById(id);
//    }
//
//    /**
//     * 分页查询对战信息表。
//     *
//     * @param page 分页对象
//     * @return 分页对象
//     */
//    @GetMapping("page")
//    public Page<MatchInfo> page(Page<MatchInfo> page) {
//        return iMatchInfoService.page(page);
//    }

}
