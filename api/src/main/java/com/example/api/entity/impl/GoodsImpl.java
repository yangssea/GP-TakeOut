package com.example.api.entity.impl;

import com.example.api.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/6  9:56
 */
@Repository
public interface GoodsImpl  extends JpaRepository<Goods, Long> {
    List<Goods> findByStoreIdOrderByTypeId(int id);

    @Query("select h from Goods h where h.storeId =:id and h.typeId =:type")
    List<Goods> findsAll(@Param("id") int id,@Param("type") Long type);

    @Modifying
    @Transactional
    @Query("delete from Goods h where h.id=:id")
    int deletes(@Param("id") int id);
}
