package com.example.demo.api;


import com.example.demo.pojo.Admin;
import com.example.demo.pojo.Interinfo;
import com.example.demo.pojo.Sign;
import com.example.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "实习信息管理",description = "综设二的接口信息")
public class UserController {
    //模拟数据库
    public static Admin admin = new Admin("111111","123456",
            "admin","软件","女","15437829541");
    public static List<User> users = new ArrayList<>();
    static{
        users.add(new User("2018091608031","123456","黄少天",
                "2018级","软件","男","18574689123"));
        users.add(new User("2018091608030","123456","喻文州",
                "2018级","软件","男","13874689123"));
        users.add(new User("2018091607011","123456","叶修",
                "2018级","软件","男","118074689145"));
        users.add(new User("2018091608032","123456","周泽楷",
                "2018级","软件","男","18074689164"));
    }
    public static List<Interinfo> interinfos = new ArrayList<>();
    static{
        interinfos.add(new Interinfo("2018091608031","黄少天","已登记",
                "已实习","蓝雨俱乐部", "广州市天河区",
                "2020.6.1","2020.7.1","已注册","广州市白云区"));

        interinfos.add(new Interinfo("2018091608030","喻文州","已登记",
                "已实习","蓝雨俱乐部", "广州市天河区",
                "2020.6.1","2020.7.1","已注册","广州市白云区"));

        interinfos.add(new Interinfo("2018091608011","叶修","已登记",
                "已实习","蓝雨俱乐部", "北京市朝阳区",
                "2020.6.1","2020.7.1","已注册","北京市西城区"));

        interinfos.add(new Interinfo("2018091608032","周泽楷","已登记",
                "已实习","轮回俱乐部", "上海市浦东区",
                "2020.6.1","2020.7.1","已注册","上海市黄埔区"));
    }
    public static List<Sign> signs = new ArrayList<>();
    static{
        signs.add(new Sign("2018091608031","黄少天","7:05",
                "已签到","广州市"));
        signs.add(new Sign("2018091608030","喻文州","7:43",
                "已签到","广州市"));
        signs.add(new Sign("2018091608011","叶修","",
                "未签到",""));
        signs.add(new Sign("2018091608032","周泽楷","",
                "未签到",""));
    }


    @ApiOperation(value = "学生登录",notes = "学生登录接口")
    @PostMapping("/loginStu")
    public String login(@RequestParam("StudentID") String StudentID,
                      @RequestParam("password") String password, Map<String,String> map){
        if("2018091608031".equals(StudentID)&&"123456".equals(password)) {

            return "RIGHT";
        }
        else{
            return "ERROR";
        }
        }

    @ApiOperation(value = "管理员登录",notes = "管理员登录")
    @PostMapping("/loginAdm")
    public String login2(@RequestParam("TeacherID") String TeacherID,
                        @RequestParam("password") String password, Map<String,String> map){
        if("111111".equals(TeacherID)&&"123456".equals(password)) {

            return "RIGHT";
        }
        else{
            return "ERROR";
        }
    }


    @ApiOperation(value = "获取学生个人信息列表",notes = "获取所有学生个人信息")
    @GetMapping("/users")
    public Object users(){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("users",users);
        return map1;
    }

    @ApiOperation(value = "获取学生实习信息列表",notes = "获取所有学生实习信息")
    @GetMapping("/usersINTE")
    public Object usersInte(){
        Map<String, Object> map2 = new HashMap<>();
        map2.put("interinfos",interinfos);
        return map2;
    }

    @ApiOperation(value = "获取学生签到信息列表",notes = "获取所有学生签到信息")
    @GetMapping("/usersSign")
    public Object usersSign(){
        Map<String, Object> map3 = new HashMap<>();
        map3.put("signs",signs);
        return map3;
    }

    @ApiOperation(value = "查询学生个人信息",notes = "根据ID查询某个学生的个人信息")
    @GetMapping("/user/{id}")
    public User getUserById1(@ApiParam("学生ID")@PathVariable("id") String StudentID){
        return users.get(3);
    }

    @ApiOperation(value = "查询学生实习信息",notes = "根据ID查询某个学生的实习信息")
    @GetMapping("/userINTE/{id}")
    public Interinfo getUserById2(@ApiParam("学生ID")@PathVariable("id") String StudentID){
        return interinfos.get(3);
    }

    @ApiOperation(value = "查询学生签到信息",notes = "根据ID查询某个学生的签到信息")
    @GetMapping("/userSIGN/{id}")
    public Sign getUserById3(@ApiParam("学生ID")@PathVariable("id") String StudentID){
        return signs.get(3);
    }

    @ApiOperation(value = "添加学生",notes = "根据传入的学生信息添加用户")
    @PostMapping("/addUser")
    public Object addUser(User user){
        return users.add(user);
    }

    @ApiOperation(value = "添加学生实习信息",notes = "根据传入的学生信息添加实习信息")
    @PostMapping("/addUserINTE")
    public Object addINTE(Interinfo interinfo){
        return interinfos.add(interinfo);
    }

    @ApiOperation(value = "添加签到表",notes = "根据传入的学生信息添加实习信息")
    @PostMapping("/addUserSIGN")
    public Object addSIGN(Sign sign){
        return signs.add(sign);
    }


    @ApiOperation(value = "删除学生",notes = "根据传入的学生ID删除对应的学生")
    @DeleteMapping("/deleteUser/{id}")
    public Object delete(@PathVariable("学生ID") String StudentID){
        return users.remove(3);
    }

    @ApiOperation(value = "下载学生个人信息EXCEL表",notes = "")
    @RequestMapping("/StuExcelDownload")
    public void StuExcelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"学生ID", "密码", "姓名", "年级", "学院", "性别","电话号码"};

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称为"学生表"
        HSSFSheet sheet = workbook.createSheet("学生表");

        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(20);
        //创建标题的显示样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);

            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
            cell.setCellStyle(headerStyle);
        }

        //获取所有的employee
        for(int i=0;i<users.size();i++){
            //创建一行
            HSSFRow row1 = sheet.createRow(i+1);
            //第一列创建并赋值
            row1.createCell(0).setCellValue(new HSSFRichTextString(users.get(i).getStudentID()));
            //第二列创建并赋值
            row1.createCell(1).setCellValue(new HSSFRichTextString(users.get(i).getPassword()));
            //第三列创建并赋值
            row1.createCell(2).setCellValue(new HSSFRichTextString(users.get(i).getName()));
            //第4列创建并赋值
            row1.createCell(3).setCellValue(new HSSFRichTextString(users.get(i).getGrade()));
            //第5列创建并赋值
            row1.createCell(4).setCellValue(new HSSFRichTextString(users.get(i).getAcademy()));
            //第6列创建并赋值
            row1.createCell(5).setCellValue(new HSSFRichTextString(users.get(i).getSex()));
            //第7列创建并赋值
            row1.createCell(6).setCellValue(new HSSFRichTextString(users.get(i).getNumber()));

        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=student.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }

    @ApiOperation(value = "下载实习信息EXCEL表",notes = "")
    @RequestMapping("/InteExcelDownload")
    public void InteExcelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"学生ID", "姓名", "登记状态", "实习状态", "公司名称", "公司地址",
                "开始日期","结束日期","住宿状态","住宿地址"};

        //声明一个工作簿
        HSSFWorkbook workbook2 = new HSSFWorkbook();

        //生成一个表格，设置表格名称为"学生表"
        HSSFSheet sheet = workbook2.createSheet("实习信息表");

        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(20);
        //创建标题的显示样式
        HSSFCellStyle headerStyle = workbook2.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);

            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
            cell.setCellStyle(headerStyle);
        }

        //获取所有的employee
        for(int i=0;i<interinfos.size();i++){
            //创建一行
            HSSFRow row1 = sheet.createRow(i+1);
            //第一列创建并赋值
            row1.createCell(0).setCellValue(new HSSFRichTextString(interinfos.get(i).getStudentID()));
            //第二列创建并赋值
            row1.createCell(1).setCellValue(new HSSFRichTextString(interinfos.get(i).getName()));
            //第三列创建并赋值
            row1.createCell(2).setCellValue(new HSSFRichTextString(interinfos.get(i).getRegStatus()));
            //第4列创建并赋值
            row1.createCell(3).setCellValue(new HSSFRichTextString(interinfos.get(i).getInterStatus()));
            //第5列创建并赋值
            row1.createCell(4).setCellValue(new HSSFRichTextString(interinfos.get(i).getCompanyName()));
            //第6列创建并赋值
            row1.createCell(5).setCellValue(new HSSFRichTextString(interinfos.get(i).getComAddress()));
            //第7列创建并赋值
            row1.createCell(6).setCellValue(new HSSFRichTextString(interinfos.get(i).getStartTime()));
            row1.createCell(7).setCellValue(new HSSFRichTextString(interinfos.get(i).getEndTime()));
            row1.createCell(8).setCellValue(new HSSFRichTextString(interinfos.get(i).getAccStatus()));
            row1.createCell(9).setCellValue(new HSSFRichTextString(interinfos.get(i).getAccAddress()));

        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=interinfos.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook2.write(response.getOutputStream());
    }

    @ApiOperation(value = "下载打卡信息EXCEL表",notes = "")
    @RequestMapping("/SignExcelDownload")
    public void SignExcelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"学生ID", "姓名", "签到日期", "签到状态", "签到地点"};

        //声明一个工作簿
        HSSFWorkbook workbook3 = new HSSFWorkbook();

        //生成一个表格，设置表格名称为"学生表"
        HSSFSheet sheet = workbook3.createSheet("签到表");

        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(20);
        //创建标题的显示样式
        HSSFCellStyle headerStyle = workbook3.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);

            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
            cell.setCellStyle(headerStyle);
        }

        //获取所有的employee
        for(int i=0;i<signs.size();i++){
            //创建一行
            HSSFRow row1 = sheet.createRow(i+1);
            //第一列创建并赋值
            row1.createCell(0).setCellValue(new HSSFRichTextString(signs.get(i).getStudentID()));
            //第二列创建并赋值
            row1.createCell(1).setCellValue(new HSSFRichTextString(signs.get(i).getName()));
            //第三列创建并赋值
            row1.createCell(2).setCellValue(new HSSFRichTextString(signs.get(i).getDate()));
            //第4列创建并赋值
            row1.createCell(3).setCellValue(new HSSFRichTextString(signs.get(i).getSignStatus()));
            //第5列创建并赋值
            row1.createCell(4).setCellValue(new HSSFRichTextString(signs.get(i).getPosition()));


        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=sign.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook3.write(response.getOutputStream());
    }




}
