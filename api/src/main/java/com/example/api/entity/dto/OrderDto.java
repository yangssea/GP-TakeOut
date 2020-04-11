package com.example.api.entity.dto;

import com.example.api.entity.OrderDetail;
import com.example.api.entity.Orders;
import lombok.Data;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/11  15:22
 */
@Data
public class OrderDto {
    private Orders orders;
    private List<OrderDetail> list;
}
