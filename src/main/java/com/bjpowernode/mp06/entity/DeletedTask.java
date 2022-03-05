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
@TableName("deleted_task")
public class DeletedTask implements Serializable {

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

    private LocalDate beginDay;

    private Integer taskDay;

    private LocalDate endDay;

    /**
     * 需要坚持的天数
     */
    private Integer taskValue;

    private String taskDescription;

    /**
     * 0:已删除任务 1：正在进行中 2：任务已完成
     */
    private Integer tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public LocalDate getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(LocalDate beginDay) {
        this.beginDay = beginDay;
    }
    public Integer getTaskDay() {
        return taskDay;
    }

    public void setTaskDay(Integer taskDay) {
        this.taskDay = taskDay;
    }
    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
    public Integer getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(Integer taskValue) {
        this.taskValue = taskValue;
    }
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "DeletedTask{" +
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
