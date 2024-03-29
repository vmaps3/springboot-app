package com.wangsong.system.service;

import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangsong.system.vo.UserAddModel;
import com.wangsong.system.vo.UserPage;
import com.wangsong.system.vo.UserVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2021-09-18
 */
public interface IUserService extends IService<User> {

    GetEasyUIData list(UserPage user);

    void add(UserAddModel user);

    UserVO selectVOByPrimaryKey(Long id);

    void updateUser(UserAddModel muser);

    void deleteUser(Long[] id);

    String findTByT(User user);

    void updatePassword(UserAddModel muser);

    User findTByUsername(Long userDetails);
}
