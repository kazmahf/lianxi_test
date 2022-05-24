package com.gavin.dao;

import com.gavin.pojo.Evaluation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationDao extends MongoRepository<Evaluation,String> {
    /**
     * 分页查询
     * 显示第一次评价 ----->Parentid 为空代表
     *
     * 对应的评论 ----->Parentid做为参数传递进去
     */
    // PageRequest extends AbstractPageRequest
    // AbstractPageRequest implements Pageable
    // ====>Pageable     PageRequest传递进去

    /**
     * 估计父标签把对应的评论查询出来
     * @param Parentid
     * @param pageable
     * @return
     */
    public Page<Evaluation>findByParentid(String Parentid, Pageable pageable);
}
