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
@TableName("random_task")
public class RandomTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每天一个随机任务
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String taskName;

    private String description;

    private Integer typeId;

    private LocalDate timeDate;

    private Integer taskValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public LocalDate getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDate timeDate) {
        this.timeDate = timeDate;
    }
    public Integer getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(Integer taskValue) {
        this.taskValue = taskValue;
    }

    @Override
    public String toString() {
        return "RandomTask{" +
            "id=" + id +
            ", taskName=" + taskName +
            ", description=" + description +
            ", typeId=" + typeId +
            ", timeDate=" + timeDate +
            ", taskValue=" + taskValue +
        "}";
    }
}
