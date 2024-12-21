package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 前端专门搞分页数据的对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultVo {
    private Long total ; //总数据量  数据库这个表当中一共有多少条记录
    private List rows;  //专门存放查询出来的集合
}
