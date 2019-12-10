package com.bxtsy.web.dao.repository;

import com.bxtsy.web.dao.entity.DictDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictRepository extends JpaRepository<DictDO, String> {
}
