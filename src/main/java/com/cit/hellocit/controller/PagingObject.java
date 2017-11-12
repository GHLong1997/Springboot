package com.cit.hellocit.controller;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingObject<T>{
    private long total;
    private Integer  totalPage;
    private List<T> data = new ArrayList<>();
}
