package com.taira.box.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //乐观锁版本号
    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;
}
