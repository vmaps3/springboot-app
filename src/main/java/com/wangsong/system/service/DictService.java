package com.wangsong.system.service;

import java.util.List;

import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.model.Dict;
import com.wangsong.system.model.DictPage;

public interface DictService {

    GetEasyUIData findTByPage(DictPage dict);

    void insertDict(Dict dict);

    void updateByPrimaryKeyDict(Dict dict);

    void deleteByPrimaryKeyDict(String[] id);

    Dict selectByPrimaryKey(String id);

    List<Dict> findTByT(Dict dict);
}
