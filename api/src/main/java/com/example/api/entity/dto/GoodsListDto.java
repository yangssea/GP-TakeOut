package com.example.api.entity.dto;

import com.example.api.entity.Goods;
import lombok.Data;

/**
 * @author yzx
 * @date 2020/4/8  20:39
 */
@Data
public class GoodsListDto {
    private Goods goods;
    private String sum;
    private int ordersum;
}
