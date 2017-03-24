package com.baiHoo.utils.uploadUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class UploadUtils {
		
	//将临时文件保存到指定的目录中
		public static String copyFile(File resource){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
				String dateStr = sdf.format(date);
				System.err.println(dateStr);
				
				//日期目录结构 
				File dateDir = new File("F:/amusementItem/ActivitiFiles" + dateStr);
				if(!dateDir.exists()){
					dateDir.mkdirs();
				}
				//构造目标文件
				File target = new File(dateDir.getPath()+File.separator+UUID.randomUUID().toString());
				try {
					FileUtils.copyFile(resource, target);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return target.getPath();
		}
		
		public String generateUniqueFilename(String filename){
			int index = filename.lastIndexOf('.');
			String fileSuffix = filename.substring(index, filename.trim().length());
			return UUID.randomUUID().toString()+fileSuffix;
		}
		public String generateUnique(){
			return UUID.randomUUID().toString();
		}
		//windows系统，一个文件夹里如果有一千个文件打开就会非常缓慢，影响访问性能，因此要解决这个问题
		public String generateScatterFilepath(String filepath , String filename){
			int directory1= filename.hashCode()&15;//oxf等同于15，二进制与位符
			int directory2= (filename.hashCode()>>4)&0xf;//二进制 >>右移的数据一个hashCode相反的数据
			filepath = filepath+File.separator+directory1+File.separator+directory2;
			File file = new File(filepath);
			if(!file.exists()){//判断文件目录是否存在，如果不存在就生成该目录
				file.mkdirs();//Creates the directory named by this abstract pathname
			}
			return filepath+"/"+filename;
		}
		
		public static void deleteUpdateFile(String filePath){
			if(filePath!=null && filePath.trim().length()!=0){
				File file = new File(filePath);
				if(file!=null && file.exists()){
					file.delete();
				}
			}
		}
		public static void main(String[] args) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
			String dateStr = sdf.format(date);
			System.err.println(dateStr);
			
			File dateDir = new File("d:\\uploadFiles" + dateStr);
			if(!dateDir.exists()){
				dateDir.mkdirs();
			}
			System.out.println(dateDir.getPath());
		}
}
