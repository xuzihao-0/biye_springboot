package com.bjpowernode.mp06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/5/23 11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("mail")
public class Mail {
    @Id
    private int uid;
    @Field("mail")
    private String mail;
}
