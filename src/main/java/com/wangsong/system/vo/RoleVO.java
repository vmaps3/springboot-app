package com.wangsong.system.vo;

import java.util.List;

import com.wangsong.system.model.Role;
import com.wangsong.system.model.RoleResources;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO extends Role {
    private List<RoleResources> roleResourcesList;
}
