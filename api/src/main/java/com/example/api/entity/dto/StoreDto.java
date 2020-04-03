package com.example.api.entity.dto;

import com.example.api.entity.Coupons;
import com.example.api.entity.CouponsType;
import com.example.api.entity.StoreDetail;
import lombok.Data;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/3  9:06
 */
@Data
public class StoreDto {
    private StoreDetail storeDetail;

    private String grade;
    //月售
    private int orderSum;

    private List<Coupons> list;

}
