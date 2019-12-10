package com.bxtsy.web.dao.repository;

import com.bxtsy.web.dao.entity.ProductTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductTypeDO, Long> {
}
