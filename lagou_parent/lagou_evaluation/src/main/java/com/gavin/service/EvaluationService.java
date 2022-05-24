package com.gavin.service;

import com.gavin.common.entity.IdWorker;
import com.gavin.dao.EvaluationDao;
import com.gavin.pojo.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationDao evaluationDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 查询所有的记录
     */
    public List<Evaluation> findAll(){
        return evaluationDao.findAll();
    }

    /**
     * 根据ID查询
     */
    public Evaluation findByID(String id){
        return evaluationDao.findById(id).get();
    }
    /**
     * 增加
     */
    public void add(Evaluation evaluation){
        evaluation.set_id(idWorker.nextId()+"");
        evaluationDao.save(evaluation);
    }

    /**
     * 修改
     */
    public void update(Evaluation evaluation){
        evaluationDao.save(evaluation);
    }
    /**
     * 删除
     */
    public void delete(String id){
        evaluationDao.deleteById(id);
    }

    /**
     *  估计父标签把对应的评论查询出来
     */
    public Page<Evaluation> findByParentid(String parentid,int page,int pageSize){
        PageRequest pageRequest = PageRequest.of(page-1,pageSize);
        return evaluationDao.findByParentid(parentid,pageRequest);
    };
}
