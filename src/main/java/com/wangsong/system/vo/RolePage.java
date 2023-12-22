package com.wangsong.system.vo;

import com.wangsong.common.model.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePage extends Page implements Serializable {
    private static final long serialVersionUID = 3582588209589180635L;
    private Long id;
    private String name;
}