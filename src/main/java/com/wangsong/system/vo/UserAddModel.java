package com.wangsong.system.vo;

import com.wangsong.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddModel extends User implements Serializable {
    private Long[] roleId;
}