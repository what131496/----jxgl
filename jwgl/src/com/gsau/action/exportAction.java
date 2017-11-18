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
	        //List studentList=new ArrayList<Student>();//ѧ��LIst
	       
	        /*for(int i=0;i<10;i++)
	        {   Student student=new Student();//ѧ������
	            student.setStudentId("200908110"+i);
	            student.setStudentName("�"+i);
	            student.setStudentSex("��");
	            student.setStudentDormitory("14-20"+i);
	            student.setStudentSept("�������ϵ");
	            studentList.add(student);
	        }*/
	             
	String []tableHeader={"����","�Ա�","�绰","����","Ŀ�ĵ�","������ϵ��","��ϵ","��ϵ��ʽ","�뿪ʱ��","����ʱ��"};
	       
	short cellNumber=(short)tableHeader.length;//�������
	        HSSFWorkbook workbook = new HSSFWorkbook();   //����һ��excel
	        HSSFCell cell = null;                                    //Excel����
	        HSSFRow row = null;                                      //Excel����
	        HSSFCellStyle style = workbook.createCellStyle();        //���ñ�ͷ������
	        
	        HSSFCellStyle style1 = workbook.createCellStyle();       //������������
	       
	        HSSFFont font = workbook.createFont();                 //��������
	        HSSFSheet sheet = workbook.createSheet("sheet1");        //����һ��sheet
	        HSSFHeader header = sheet.getHeader();//����sheet��ͷ
	try {              
	            if(studentList.size() < 1 ){
	                header.setCenter("��������");
	            }else{
	                header.setCenter("��Ϣ��ѧ����ѧԺ�����ա��ڼ�����У����Ǽ�");
	                row = sheet.createRow(0);
	                row.setHeight((short)400);
	                for(int k = 0;k < cellNumber;k++){
	                    cell = row.createCell(k);//������0�е�k��
	                    cell.setCellValue(tableHeader[k]);//���õ�0�е�k�е�ֵ
	                    sheet.setColumnWidth(k,8000);//�����еĿ��
	                    font.setColor(HSSFFont.COLOR_NORMAL);      // ���õ�Ԫ���������ɫ.
	                    font.setFontHeight((short)250); //���õ�Ԫ����߶�
	                    style1.setFont(font);//����������
	                    cell.setCellStyle(style1);
	                }
	                        
	                for(int i = 0 ;i < studentList.size() ;i++){                            
	                    Out_School student1 = (Out_School)studentList.get(i);//��ȡstudent����
	                    System.out.println("-----------------------"+student1.getBack_time());
	                    row = sheet.createRow((short) (i + 1));//������i+1��
	                    row.setHeight((short)400);//�����и�
	                    if(student1.getName() != null){
	                         cell = row.createCell(0); //������i+1�е�1��
	                         cell.setCellValue(student1.getName());//���õ�i+1�е�1�е�ֵ
	                         cell.setCellStyle(style); //���÷��
	                    }
	//��������ĺ�����Ļ�����ͬ���Ͳ���ע����
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
	       
	  
	        HttpServletResponse response = null;//����һ��HttpServletResponse����
	        OutputStream out = null;//����һ�����������
	        try {
	            response = ServletActionContext.getResponse();//��ʼ��HttpServletResponse����
	            out = response.getOutputStream();//
	          
	    String StringheaderStr = "��Ϣ��ѧ����ѧԺ�����ա��ڼ�����У����Ǽ�";
	    String headerStr="";
	    headerStr = new String(headerStr.getBytes("gb2312"), "ISO8859-1");//headerStringΪ����ʱת��
	    response.setHeader("Content-disposition","attachment; filename="+    headerStr+"outRegister.xls");//filename�����ص�xls���������������Ӣ��
	            response.setContentType("application/msexcel;charset=UTF-8");//��������
	            response.setHeader("Pragma","No-cache");//����ͷ
	            response.setHeader("Cache-Control","no-cache");//����ͷ
	            response.setDateHeader("Expires", 0);//��������ͷ
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
