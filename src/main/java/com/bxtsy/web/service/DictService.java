package com.bxtsy.web.service;

import com.bxtsy.web.dao.entity.DictDO;
import com.bxtsy.web.dao.repository.DictRepository;
import org.springframework.stereotype.Service;

@Service
public class DictService {

    private DictRepository dictRepository;
    public DictService(DictRepository dictRepository) {
        this.dictRepository = dictRepository;
    }

    public String getOne(String key) {
        return dictRepository.findById(key).map(DictDO::getValue).orElse(null);
    }

    public void saveOrUpdateOne(String key, String value) {
        DictDO dictDO = dictRepository.findById(key).orElse(null);
        if (dictDO == null) {
            dictDO = new DictDO();
        }
        dictDO.setValue(value);
        dictRepository.save(dictDO);
    }




}
