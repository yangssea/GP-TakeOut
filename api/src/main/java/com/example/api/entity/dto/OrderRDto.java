package com.example.api.entity.dto;

import com.example.api.entity.OrderDetail;
import com.example.api.entity.Orders;
import lombok.Data;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/11  20:53
 */
@Data
public class OrderRDto {
    private Orders orders;
    private String StoreName;
    private String Storeimg;
    private List<OrderDetail> orderDetail;
}
