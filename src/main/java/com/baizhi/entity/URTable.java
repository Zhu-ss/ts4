package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName URTable
 * @Author
 * @Date 2020/1/5 14:59
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "u_r_table")
public class URTable implements Serializable {
    @Id
    private String id;
    private String u_id;
    private String r_id;
}
