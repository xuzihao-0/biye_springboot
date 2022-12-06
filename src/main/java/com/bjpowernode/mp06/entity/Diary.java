package com.bjpowernode.mp06.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/4/12 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("diary")
public class Diary {
    @Id
    private int id;
    @Field("userId")
    private int userId;

    @Field("title")
    private String title;
    @Field("date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Field("context")
    private String context;




}
