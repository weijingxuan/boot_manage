package com.jingxuan.core.service;

import com.jingxuan.core.po.BaseDict;

import java.util.List;

public interface BaseDictService {

    //根据类别代码查询数据字典
    public List<BaseDict>findBaseDictByTypeCode(String typecode);
}
