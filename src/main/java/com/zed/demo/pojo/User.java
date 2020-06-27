package com.zed.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@ApiModel("学生表")
@Data


public class User {
    @ApiModelProperty(value ="学生ID")
    private  String StudentID;
    @ApiModelProperty("密码")
    private  String password;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年级")
    private String Grade;
    @ApiModelProperty("学院")
    private String Academy;
    @ApiModelProperty("性别")
    private String Sex;
    @ApiModelProperty("电话号码")
    private String phoneNumber;

    public User(String StudentID, String password, String name,
            String grade, String academy, String sex, String number) {
        this.StudentID = StudentID;
        this.password = password;
        this.name = name;
        this.Grade = grade;
        this.Academy = academy;
        this.Sex = sex;
        this.phoneNumber = number;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
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

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
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
        return phoneNumber;
    }

    public void setNumber(String phonenumber) {
        phoneNumber = phonenumber;
    }
}

