package com.bxtsy.web.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "t_dict")
public class DictDO extends BaseDO {
    @Id
    @Column(name = "`key`", length = 36)
    private String key;

    @Column(name = "`value`")
    private String value;
}
