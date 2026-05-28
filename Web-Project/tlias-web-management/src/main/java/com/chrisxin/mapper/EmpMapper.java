package com.chrisxin.mapper;

import com.chrisxin.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*员工基本信息*/
@Mapper
public interface EmpMapper {

    /**
     * 查询员工数量
     */
    @Select("select count(*) from emp")
    public Long count();

    @Select("select e.*,d.name from emp e left join dept d on e.dept_id = d.id")
    public List<Emp>
}
