package com.bjpowernode.mp06.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Jdata {
    int i;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    Date date;

}
