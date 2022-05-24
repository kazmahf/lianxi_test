package com.gavin.controller;

import ch.qos.logback.core.status.Status;
import com.gavin.common.entity.Result;
import com.gavin.common.entity.StatusCode;
import com.gavin.pojo.Evaluation;
import com.gavin.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private  EvaluationService evaluationService;

    //方法二：
//    @Autowired
//    private MongoTemplate mongoTemplate; //繁琐
    /**
     * 查询所有
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询所有成功",
                evaluationService.findAll());
    }

    /**
     * 按照ID查询
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findByID(@PathVariable String id){
        return new Result(true, StatusCode.OK,"ID查询成功",
                evaluationService.findByID(id));
    }
    /**
     * 增加
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Evaluation evaluation){
        evaluationService.add(evaluation);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Evaluation evaluation,@PathVariable String id){
        evaluation.set_id(id);
        evaluationService.update(evaluation);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        evaluationService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    /**
     *  估计父标签把对应的评论查询出来
     */
    @RequestMapping(value = "/eva/{parentID}/{page}/{size}",method = RequestMethod.DELETE)
    public Result eva(@PathVariable String parentID,@PathVariable int page,@PathVariable int size){
        evaluationService.findByParentid(parentID,page,size);
        return new Result(true, StatusCode.OK,"删除成功"
                ,evaluationService.findByParentid(parentID,page,size));
    }
}
