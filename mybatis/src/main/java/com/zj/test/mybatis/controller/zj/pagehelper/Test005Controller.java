package com.zj.test.mybatis.controller.zj.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.test.mybatis.mapper.zj.Test005Mapper;
import com.zj.test.mybatis.po.zj.UserPO;
import com.zj.test.mybatis.util.zj.TestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/* @author: zhoujian
 * @create-time: 2020年9月17日 12:12:36
 * @description: 1.mybatis查询Example的使用
 * @version: 1.0
 */
@RestController
@RequestMapping("/test/mybatis/pagehelper")
public class Test005Controller {

    @Autowired
    Test005Mapper test005Mapper;

    @RequestMapping("test005")
    public PageInfo<Map<Object, Object>> test003(Integer pageNum, Integer pageSize) {
        TestHelper.startTest("mybatis example使用测试");

        Example example = new Example(UserPO.class);
        example.createCriteria().andGreaterThan("id",5);

        return PageHelper.startPage(1,5).doSelectPageInfo(()->test005Mapper.selectByExample(example));
    }
}