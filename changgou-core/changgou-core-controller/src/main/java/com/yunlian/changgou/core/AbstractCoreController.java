package com.yunlian.changgou.core;

import com.github.pagehelper.PageInfo;
import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.common.StatusCode;
import com.yunlian.changgou.core.CoreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class AbstractCoreController<T> {

    //调用方的service
    protected CoreService<T> coreService;

    public AbstractCoreController(CoreService<T> coreService) {
        this.coreService = coreService;

    }

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(name = "id") Object id) {
        coreService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    @PostMapping
    public Result insert(@RequestBody T record) {
        coreService.insert(record);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 分页查询记录
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<T>> findByPage(@PathVariable(name = "page") Integer pageNo,
                                          @PathVariable(name = "size") Integer pageSize) {
        PageInfo<T> pageInfo = coreService.findByPage(pageNo, pageSize);
        return new Result<PageInfo<T>>(true, StatusCode.OK, "分页查询成功", pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<T>> findByPage(@PathVariable(name = "page") Integer pageNo,
                                          @PathVariable(name = "size") Integer pageSize,
                                          @RequestBody T record) {
        PageInfo<T> pageInfo = coreService.findByPage(pageNo, pageSize, record);
        return new Result<PageInfo<T>>(true, StatusCode.OK, "条件分页查询成功", pageInfo);
    }

    @GetMapping("/{id}")
    public Result<T> findById(@PathVariable(name = "id") Object id) {
        T t = coreService.selectByPrimaryKey(id);
        return new Result<T>(true, StatusCode.OK, "查询单个数据成功", t);
    }

    @GetMapping
    public Result<List<T>> findAll() {
        List<T> list = coreService.selectAll();
        return new Result<List<T>>(true, StatusCode.OK, "查询所有数据成功", list);
    }

    //更新数据
    @PutMapping
    public Result updateByPrimaryKey(@RequestBody T record) {
        coreService.updateByPrimaryKey(record);
        return new Result(true, StatusCode.OK, "更新成功");
    }
}