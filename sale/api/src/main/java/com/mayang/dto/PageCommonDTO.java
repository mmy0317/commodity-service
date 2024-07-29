package com.mayang.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageCommonDTO implements Serializable {

    private Integer page;

    private Integer size;


}
