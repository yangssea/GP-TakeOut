package com.example.api.entity.impl;

import com.example.api.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author yzx
 * @date 2020/3/30  18:43
 */
@Repository
public interface UserAddressImpl extends JpaRepository<UserAddress, Long> {
    List<UserAddress> findAllBy();
}
