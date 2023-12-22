package com.wangsong.system.vo;

import com.wangsong.system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAddModel extends Role implements Serializable {
    private Long[] resourcesId;
}