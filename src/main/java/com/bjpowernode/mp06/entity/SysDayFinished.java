package com.bjpowernode.mp06.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@TableName("sys_day_finished")
public class SysDayFinished implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDate timeDay;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(LocalDate timeDay) {
        this.timeDay = timeDay;
    }
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SysDayFinished{" +
            "id=" + id +
            ", timeDay=" + timeDay +
            ", count=" + count +
        "}";
    }
}
