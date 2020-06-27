package com.zed.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@ApiModel("打卡表")
@Data

public class sign{
    @ApiModelProperty(value ="学生ID")
    private String StudentID;
    @ApiModelProperty(value ="姓名")
    private String name;
    @ApiModelProperty(value ="签到日期")
    private String date;
    @ApiModelProperty(value ="签到状态")
    private String SignStatus;
    @ApiModelProperty(value ="签到地点")
    private String Position;

    public sign(String studentID, String name, String date, String signStatus, String position) {
        StudentID = studentID;
        this.name = name;
        this.date = date;
        SignStatus = signStatus;
        Position = position;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSignStatus() {
        return SignStatus;
    }

    public void setSignStatus(String signStatus) {
        SignStatus = signStatus;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
