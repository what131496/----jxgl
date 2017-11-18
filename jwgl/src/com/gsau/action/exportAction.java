package com.gsau.action;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.gsau.entity.Out_School;
import com.gsau.service.OutSchoolService;
import com.gsau.utils.Student;
public class exportAction {
	private OutSchoolService outSchoolService;
	
	    
		public OutSchoolService getOutSchoolService() {
		return outSchoolService;
	}


	public void setOutSchoolService(OutSchoolService outSchoolService) {
		this.outSchoolService = outSchoolService;
	}
		public String export()throws Exception
	    {  
			List studentList=outSchoolService.findAll();
	        //List studentList=new ArrayList<Student>();//学生LIst
	       
	        /*for(int i=0;i<10;i++)
	        {   Student student=new Student();//学生对象
	            student.setStudentId("200908110"+i);
	            student.setStudentName("杨波"+i);
	            student.setStudentSex("男");
	            student.setStudentDormitory("14-20"+i);
	            student.setStudentSept("软件工程系");
	            studentList.add(student);
	        }*/
	             
	String []tableHeader={"姓名","性别","电话","事由","目的地","备用联系人","关系","联系方式","离开时间","返回时间"};
	       
	short cellNumber=(short)tableHeader.length;//表的列数
	        HSSFWorkbook workbook = new HSSFWorkbook();   //创建一个excel
	        HSSFCell cell = null;                                    //Excel的列
	        HSSFRow row = null;                                      //Excel的行
	        HSSFCellStyle style = workbook.createCellStyle();        //设置表头的类型
	        
	        HSSFCellStyle style1 = workbook.createCellStyle();       //设置数据类型
	       
	        HSSFFont font = workbook.createFont();                 //设置字体
	        HSSFSheet sheet = workbook.createSheet("sheet1");        //创建一个sheet
	        HSSFHeader header = sheet.getHeader();//设置sheet的头
	try {              
	            if(studentList.size() < 1 ){
	                header.setCenter("查无资料");
	            }else{
	                header.setCenter("信息科学技术学院公休日、节假日离校外出登记");
	                row = sheet.createRow(0);
	                row.setHeight((short)400);
	                for(int k = 0;k < cellNumber;k++){
	                    cell = row.createCell(k);//创建第0行第k列
	                    cell.setCellValue(tableHeader[k]);//设置第0行第k列的值
	                    sheet.setColumnWidth(k,8000);//设置列的宽度
	                    font.setColor(HSSFFont.COLOR_NORMAL);      // 设置单元格字体的颜色.
	                    font.setFontHeight((short)250); //设置单元字体高度
	                    style1.setFont(font);//设置字体风格
	                    cell.setCellStyle(style1);
	                }
	                        
	                for(int i = 0 ;i < studentList.size() ;i++){                            
	                    Out_School student1 = (Out_School)studentList.get(i);//获取student对象
	                    System.out.println("-----------------------"+student1.getBack_time());
	                    row = sheet.createRow((short) (i + 1));//创建第i+1行
	                    row.setHeight((short)400);//设置行高
	                    if(student1.getName() != null){
	                         cell = row.createCell(0); //创建第i+1行第1列
	                         cell.setCellValue(student1.getName());//设置第i+1行第1列的值
	                         cell.setCellStyle(style); //设置风格
	                    }
	//由于下面的和上面的基本相同，就不加注释了
	                    if(student1.getSex() != null){
	                         cell = row.createCell(1);
	                         cell.setCellValue(student1.getSex());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getPhone()!= null){
	                         cell = row.createCell(2);
	                         cell.setCellValue(student1.getPhone());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getReason()!= null){
	                         cell = row.createCell(3);
	                         cell.setCellValue(student1.getReason());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getPlace()!= null){
	                         cell = row.createCell(4);
	                         cell.setCellValue(student1.getPlace());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getYour_phone() != null){
	                         cell = row.createCell(5);
	                         cell.setCellValue(student1.getYour_phone());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getRelationship() != null){
	                         cell = row.createCell(6);
	                         cell.setCellValue(student1.getRelationship());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getRe_phone() != null){
	                         cell = row.createCell(7);
	                         cell.setCellValue(student1.getRe_phone());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getLeave_time() != null){
	                         cell = row.createCell(8);
	                         cell.setCellValue(student1.getLeave_time());
	                         cell.setCellStyle(style);
	                    }
	                    if(student1.getBack_time() != null){
	                         cell = row.createCell(9);
	                         cell.setCellValue(student1.getBack_time());
	                         cell.setCellStyle(style);
	                    }
	                }
	               
	            }
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	  
	        HttpServletResponse response = null;//创建一个HttpServletResponse对象
	        OutputStream out = null;//创建一个输出流对象
	        try {
	            response = ServletActionContext.getResponse();//初始化HttpServletResponse对象
	            out = response.getOutputStream();//
	          
	    String StringheaderStr = "信息科学技术学院公休日、节假日离校外出登记";
	    String headerStr="";
	    headerStr = new String(headerStr.getBytes("gb2312"), "ISO8859-1");//headerString为中文时转码
	    response.setHeader("Content-disposition","attachment; filename="+    headerStr+"outRegister.xls");//filename是下载的xls的名，建议最好用英文
	            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
	            response.setHeader("Pragma","No-cache");//设置头
	            response.setHeader("Cache-Control","no-cache");//设置头
	            response.setDateHeader("Expires", 0);//设置日期头
	            workbook.write(out);
	            out.flush();
	            workbook.write(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try{
	               
	                if(out!=null){
	                    out.close();
	                }
	               
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	           
	        }
	       
	        return null;
	   
}
}
