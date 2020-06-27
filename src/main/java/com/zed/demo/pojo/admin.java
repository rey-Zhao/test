package com.zed.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@ApiModel("管理员表")
@Data


public class admin {
    @ApiModelProperty(value ="工号")
    private  String TeacherID;
    @ApiModelProperty("密码")
    private  String password;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("学院")
    private String Academy;
    @ApiModelProperty("性别")
    private String Sex;
    @ApiModelProperty("电话号码")
    private String Number;

    public admin(String teacherID, String password, String name, String academy, String sex, String number) {
        TeacherID = teacherID;
        this.password = password;
        this.name = name;
        Academy = academy;
        Sex = sex;
        Number = number;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return Academy;
    }

    public void setAcademy(String academy) {
        Academy = academy;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}

