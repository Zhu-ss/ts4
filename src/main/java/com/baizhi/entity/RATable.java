package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName RATable
 * @Author
 * @Date 2020/1/5 15:03
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "r_a_table")
public class RATable implements Serializable {
    @Id
    private String id;
    private String r_id;
    private String a_id;

}
