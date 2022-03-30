package com.gu.orderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gu.orderservice.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from cloud_order.tb_order where id = #{id}")
    Order findById(Long id);
}
