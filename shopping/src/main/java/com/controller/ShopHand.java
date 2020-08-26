package com.dropshoping.dropshoping.controller;

import com.dropshoping.dropshoping.entity.Shop;
import com.dropshoping.dropshoping.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//前端调用接口在这，通过RestController
@RestController
@RequestMapping("/shop")
public class ShopHand {
    //Autowired扫描当前类的属性或方法
    @Autowired
    private ShopRepository shopRepository;

    //@PathVariable使用前端传参数页码，分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<Shop> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
//        Pageable接口分页查询of方法取页码 传入pageable返回真实页码page-1
        PageRequest pageRequest = PageRequest.of(page, size);
        return shopRepository.findAll(pageRequest);
    }

//    通过网络请求让他人调用
//    @RequestBody映射 才能将json转为java对象shop
//    保存内容到数据库
    @RequestMapping("/save")
    public String save(@RequestBody Shop shop) {
        Shop result = shopRepository.save(shop);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //PathVariable获取数据库id，分页查询
    @GetMapping("/findById/{id}")
    public Shop findById(@PathVariable("id") Integer id) {
        return shopRepository.findById(id).get();
    }


    //修改数据库内容,同样用的save，注解使用@PutMapping,@CrossOrigin防止前端被拦截跨源请求，原因：CORS 头缺少 'Access-Control-Allow-Origin'
    @PutMapping("/update")
    @CrossOrigin
    public String update(@RequestBody Shop shop) {
        Shop result = shopRepository.save(shop);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //@DeleteMapping提供删除接口
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        shopRepository.deleteById(id);
    }

}
