package com.jingxuan.core.service.impl;

import com.jingxuan.core.dao.BaseDictDao;
import com.jingxuan.core.po.BaseDict;
import com.jingxuan.core.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService{

    @Autowired
    private BaseDictDao baseDictDao;
    @Override
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {
        return baseDictDao.selectBaseDictByTypeCode(typecode);
    }
}
