package com.bjpowernode.mp06.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@Data
@TableName("ongoing_task")
public class OngoingTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务类型
     */
    private Integer typeId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern ="yyyy-MM-dd")
    private LocalDate beginDay;

    private Integer taskDay;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern ="yyyy-MM-dd")
    private LocalDate  endDay;

    /**
     * 需要坚持的天数
     */
    private Integer taskValue;

    private String taskDescription;

    /**
     * 0:已删除任务 1：正在进行中 2：任务已完成
     */
    private Integer tag;


    @Override
    public String toString() {
        return "OngoingTask{" +
            "id=" + id +
            ", uid=" + uid +
            ", taskName=" + taskName +
            ", typeId=" + typeId +
            ", beginDay=" + beginDay +
            ", taskDay=" + taskDay +
            ", endDay=" + endDay +
            ", taskValue=" + taskValue +
            ", taskDescription=" + taskDescription +
            ", tag=" + tag +
        "}";
    }
}
