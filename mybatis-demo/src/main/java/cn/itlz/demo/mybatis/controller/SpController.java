package cn.itlz.demo.mybatis.controller;

import cn.itlz.demo.mybatis.dao.SpDao;
import cn.itlz.demo.mybatis.entity.Sp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/3/20 0020
 */
@RestController
public class SpController {

    @Autowired
    private SpDao spDao;

    @GetMapping("mpage")
    public IPage<Sp> getUserDtoByPage(Integer size,Integer current) {
        Page<Sp> page = new Page<Sp>().setSize(size).setCurrent(current);
        List<Sp> sps = spDao.getSpByPage(page);
        page.setRecords(sps);
        return page;
    }

    @GetMapping("customPage")
    public IPage<Sp> customPage(Integer size,Integer current) {
        Page<Sp> page = new Page<Sp>().setSize(size).setCurrent(current);
        Integer offset = (current-1)*size;
        List<Sp> sps = spDao.getCustomPage(offset,  size);
        int total = spDao.selectCount(null);

        page.setRecords(sps);
        page.setTotal(total);

        return page;

    }


}
