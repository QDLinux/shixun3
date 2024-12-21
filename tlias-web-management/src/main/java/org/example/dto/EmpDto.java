package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
    private String name;
    private String gender;
    private String begin;
    private String end;

    //分页参数
    private Integer page;
    private Integer pageSize;
}
