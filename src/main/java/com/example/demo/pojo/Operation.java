package com.example.demo.pojo;

public class Operation{
    private String StudentID;
    private String name;
    private String OperRecord;
    private String OperDate;
    private String Remark;

    public String getId() {
        return StudentID;
    }
    public void setId(String id) {
        this.StudentID = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOperRecord() {
        return OperRecord;
    }
    public void setOperRecord(String OperRecord) {
        this.OperRecord = OperRecord;
    }
    public String getOperDate() {
        return OperDate;
    }
    public void setOperDate(String date) {
        this.OperDate = date;
    }
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String Remark) {
        this.Remark = Remark;
    }


    public Operation(String id, String name, String OperRecord, String date,String remark) {
        super();
        this.StudentID = id;
        this.name = name;
        this.OperRecord = OperRecord;
        this.OperDate = date;
        this.Remark = remark;


    }
    public Operation() {

    }}
