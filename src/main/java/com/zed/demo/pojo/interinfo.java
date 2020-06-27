package com.zed.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@ApiModel("实习表")
@Data

public class interinfo {

    @ApiModelProperty(value ="学生ID")
        private String StudentID;
    @ApiModelProperty("姓名")
        private String name;
    @ApiModelProperty("登记状态")
        private String RegStatus;
    @ApiModelProperty("实习状态")
        private String interStatus;
    @ApiModelProperty("公司名称")
        private String CompanyName;
    @ApiModelProperty("公司地址")
        private String ComAddress;
    @ApiModelProperty("开始日期")
        private String StartTime;
    @ApiModelProperty("结束日期")
        private String EndTime;
    @ApiModelProperty("住宿状态")
        private String AccStatus;
    @ApiModelProperty("住宿地址")
        private String AccAddress;


    public interinfo(String studentID, String name, String regStatus, String interStatus,
                     String companyName, String comAddress, String startTime, String endTime,
                     String accStatus, String accAddress) {
        StudentID = studentID;
        this.name = name;
        RegStatus = regStatus;
        this.interStatus = interStatus;
        CompanyName = companyName;
        ComAddress = comAddress;
        StartTime = startTime;
        EndTime = endTime;
        AccStatus = accStatus;
        AccAddress = accAddress;
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

    public String getRegStatus() {
        return RegStatus;
    }

    public void setRegStatus(String regStatus) {
        RegStatus = regStatus;
    }

    public String getInterStatus() {
        return interStatus;
    }

    public void setInterStatus(String interStatus) {
        this.interStatus = interStatus;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getComAddress() {
        return ComAddress;
    }

    public void setComAddress(String comAddress) {
        ComAddress = comAddress;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getAccStatus() {
        return AccStatus;
    }

    public void setAccStatus(String accStatus) {
        AccStatus = accStatus;
    }

    public String getAccAddress() {
        return AccAddress;
    }

    public void setAccAddress(String accAddress) {
        AccAddress = accAddress;
    }
}


