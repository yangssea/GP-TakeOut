package com.example.api.util;

import com.example.api.entity.Goods;
import com.example.api.entity.dto.StoreDto;
import org.apache.commons.collections.FastArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/6  10:22
 */
public class Sort {
    public static List<StoreDto> listSort(List<StoreDto> list,int type){
        Collections.sort(list, new Comparator<StoreDto>() {
            @Override
            public int compare(StoreDto o1, StoreDto o2) {
                int i=0;
                if(type==1) {
                    if(o1.getAllSort() -o2.getAllSort()<0){
                        i = 1;
                    }else if(o1.getAllSort() -o2.getAllSort()==0){
                        i=0;
                    }else{
                        i=-1;
                    }
                }else if(type==2){
                     if(o1.getDistance() - o2.getDistance()<0){
                         i = 1;
                     }else if(o1.getDistance() - o2.getDistance()==0){
                         i=0;
                     }else{
                         i=-1;
                     }
                }else if(type==3){
                    i = o2.getOrderSum() - o1.getOrderSum();
                }
                return i;
            }
        });
        return list;
    }
}
