package com.yunlian.changgou.service.goods.controller;

import com.github.pagehelper.PageInfo;
import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.common.StatusCode;
import com.yunlian.changgou.goods.model.Brand;
import com.yunlian.changgou.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public Result<Brand> findAll(){
        List<Brand> list =  brandService.findAll();
        return new Result<Brand>(true, StatusCode.OK,"查询成功",list);
    }

    @PutMapping("/update/{brand}")
    public Result<Brand> update(@PathVariable("brand") Brand brand){
        brandService.update(brand);
        return new Result<Brand>(true,StatusCode.OK,"更新成功");
    }

    @GetMapping("/findOneById/{id}")
    public Result<Brand> findOneById(@PathVariable("id") int id){
        brandService.findOneById(id);
        return new Result<>(true,StatusCode.OK,"查询成功");
    }

    @PostMapping("/add/{brand}")
    public Result add(@PathVariable("brand") Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") int id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @GetMapping("/findList/{brand}")
    public Result<Brand> findList(@PathVariable("brand") Brand brand){
        List<Brand>list = brandService.findList(brand);
        return new Result<Brand>(true,StatusCode.OK,"查找成功",list);
    }

    @GetMapping("/findPage/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable("page") int page,@PathVariable("size") int size){
        PageInfo pageInfo = brandService.findPage(page,size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @GetMapping("/findListByCategoryName/{categoryName}")
    public Result findListByCategoryName(@PathVariable("categoryName") String categoryName){
        List list = brandService.findListByCategoryName(categoryName);
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/findSpecListByCategory/{categoryName}")
    public Result findSpecListByCategory(@PathVariable("categoryName") String categoryName){
        List list = brandService.findSpecListByCategory(categoryName);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

}
