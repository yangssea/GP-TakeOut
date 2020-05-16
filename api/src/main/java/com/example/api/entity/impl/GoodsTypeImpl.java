package com.example.api.entity.impl;

import com.example.api.entity.Goods;
import com.example.api.entity.GoodsType;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/8  20:25
 */
@Repository
public interface GoodsTypeImpl extends JpaRepository<GoodsType, Long> {
    List<GoodsType> findByStoreId(Long id);

    @Modifying
    @Transactional
    @Query("delete from GoodsType h where h.id=:id")
    int deletes(@Param("id") int id);
}
