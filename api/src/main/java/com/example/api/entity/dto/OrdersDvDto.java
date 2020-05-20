package com.example.api.entity.dto;

import com.example.api.entity.Orders;
import lombok.Data;

import java.util.List;

/**
 * @author yzx
 * @date 2020/5/20  16:05
 */
@Data
public class OrdersDvDto {
    private Orders orders;
    private String address;
    private String name;
    private String lat;
    private String lng;
}
