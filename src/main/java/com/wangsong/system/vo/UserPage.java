package com.wangsong.system.vo;

import com.wangsong.common.model.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPage extends Page implements Serializable {
    private Long id;
    private String username;
    private String password;
}