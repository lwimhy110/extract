package com.nipsoft.neo4.web;

import com.nipsoft.neo4.bean.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Api(tags = {"测试接口"}, value = "测试接口事件集")
@RestController
@RequestMapping("/restful")
public class RestfulController {

    @ApiOperation(value = "post请求数据为json或者字符串", notes = "post请求")
    @RequestMapping(value = "/postBody", method = RequestMethod.POST)
    public ResponseEntity postBody(@RequestBody @ApiParam(name = "data",
                                                     value = "计费实体数据") String data) {
        return ResponseEntity.ok(ResponseBean.builder().message(data).status("200").build());
    }

    @ApiOperation(value = "get请求数据id为/id", notes = "get 请求")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getPathVariable(@PathVariable @ApiParam(name = "id",
            value = "parth方式获取请求路径为 /get/id") String id) {
        // implementation omitted
        return ResponseEntity.ok(ResponseBean.builder().message(id).status("200").build());
    }

    @ApiOperation(value = "普通get请求", notes = "get")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam @ApiParam(name="id",value = "get请求") String id){
        // implementation omitted
        return ResponseEntity.ok(ResponseBean.builder().message(id).status("200").build());
    }

    @ApiOperation(value = "普通post请求", notes = "post")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity post(@RequestParam(name = "data") @ApiParam(name="data",value = "post请求") String data) {
        // implementation omitted
        return ResponseEntity.ok(ResponseBean.builder().message(data).status("200").build());
    }
}
