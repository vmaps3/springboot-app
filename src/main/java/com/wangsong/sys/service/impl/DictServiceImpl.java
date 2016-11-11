package com.wangsong.sys.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.commons.service.impl.BaseServiceImpl;
import com.wangsong.sys.model.Dict;
import com.wangsong.sys.service.DictService;

@Service
@Transactional
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService{

}
