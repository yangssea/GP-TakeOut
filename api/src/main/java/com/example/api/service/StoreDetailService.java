package com.example.api.service;

/**
 * @author yzx
 * @date 2020/4/2  20:19
 */
public interface StoreDetailService {
    Object getStoreList(int page,int type,double lat,double lng);
    Object findStoreList(int page,int type,double lat,double lng,String find);
}
