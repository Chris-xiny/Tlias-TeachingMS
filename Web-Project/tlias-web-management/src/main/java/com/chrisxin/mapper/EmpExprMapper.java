package com.chrisxin.mapper;

import com.chrisxin.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*员工工作经历*/
@Mapper
public interface EmpExprMapper {

    void addBatch(List<EmpExpr> exprList);
}
