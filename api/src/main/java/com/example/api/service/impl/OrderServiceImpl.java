package com.example.api.service.impl;

import com.example.api.entity.OrderDetail;
import com.example.api.entity.Orders;
import com.example.api.entity.StoreDetail;
import com.example.api.entity.dto.OrderDto;
import com.example.api.entity.dto.OrderRDto;
import com.example.api.entity.impl.CouponsImpl;
import com.example.api.entity.impl.OrderDeatilImpl;
import com.example.api.entity.impl.OrdersImpl;
import com.example.api.entity.impl.StoreDetailImpl;
import com.example.api.service.OrderService;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/11  10:08
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CouponsImpl coupons;
    @Autowired
    private OrdersImpl orders;
    @Autowired
    private OrderDeatilImpl orderDeatil;
    @Autowired
    private StoreDetailImpl storeDetailImpl;
    @Override
    public Object findCoupons(int id) {
        return coupons.getByStoreId(id);
    }

    //保存订单
    @Transactional
    @Override
    public Object save(OrderDto orderDto) {
        Orders res=orders.save(orderDto.getOrders());
        for(int i=0;i<orderDto.getList().size();i++){
            orderDto.getList().get(i).setOrderId(res.getId());
            orderDeatil.save(orderDto.getList().get(i));
        }
        return res;
    }

    //查询订单
    @Override
    public Object findAll(int id) {
        List<Orders> list=orders.findByUserId(id);
        List<OrderRDto> rlist = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            OrderRDto orderRDto=new OrderRDto();
            List<OrderDetail> listD=orderDeatil.findByOrderId(list.get(i).getId());
            orderRDto.setOrderDetail(listD);
            orderRDto.setOrders(list.get(i));
            //查询商店名
            StoreDetail storeDetail=storeDetailImpl.findById(list.get(i).getStoreId());
            orderRDto.setStoreName(storeDetail.getName());
            orderRDto.setStoreimg(storeDetail.getImg());
            rlist.add(orderRDto);
        }
        return rlist;
    }
}
