package com.jingxuan.core.dao;

import com.jingxuan.core.po.BaseDict;

import java.util.List;

public interface BaseDictDao {

    //根据类别代码查询数据字典
    public List<BaseDict>selectBaseDictByTypeCode(String typecode);
}
