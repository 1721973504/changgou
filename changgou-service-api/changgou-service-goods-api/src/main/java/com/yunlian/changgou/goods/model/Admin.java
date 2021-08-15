package com.yunlian.changgou.goods.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//编号

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;
}
