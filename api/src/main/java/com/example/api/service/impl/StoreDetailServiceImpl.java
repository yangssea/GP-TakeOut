package com.example.api.service.impl;

import com.example.api.entity.StoreDetail;
import com.example.api.entity.impl.GradeImpl;
import com.example.api.entity.impl.OrderImpl;
import com.example.api.entity.impl.StoreDetailImpl;
import com.example.api.service.StoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/2  20:23
 */
@Service
public class StoreDetailServiceImpl implements StoreDetailService {
    @Autowired
    private StoreDetailImpl storeDetailImpl;
    @Autowired
    private GradeImpl gradeImpl;
    @Autowired
    private OrderImpl orderImpl;
    @Override
    public Object getStoreList(int page, int type) {
        //page从1开始
        List<Object> list = storeDetailImpl.findAllBy();
        List<Object> list1 = new ArrayList<>();
        //筛选type
        if(list==null&&list.size()<10){
            return list;
        }else{
            for(int i=0;i<list.size();i++){
                if(i>=(page-1)*10&&i<page*10){
                    list1.add(list.get(i));
                }
            }
           /* for(int i=0;i<list1.size();i++){
                gradeImpl.find(list1.get(i).userId);
            }*/
            return list1;
        }
    }
}
