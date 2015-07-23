package org.conan.mymahout.recommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class MLData_dataFomulartoCSV {
	String formalFileName="datafile/ml-100k/u1.test";
	String newFileName="datafile/ml-100k/u1_test"+".csv";
/*	String formalFileName="datafile/ml-100k/u.data";
	String newFileName="datafile/ml-100k/data"+".csv";*/
	
	
	
	
	private List<String> formalList=null;
	private  File formalListFile =null;

	public List<String> newList=null;
	public  File newListFile=null;

	
	 public static void main( String[] args )
     {
		 MLData_dataFomulartoCSV dfcsv=new MLData_dataFomulartoCSV();
		 dfcsv.FileNomalization();
     }
	/**
	 * 调整数据格式用于mahout处理
	 * 读取 txt 并且调整
	 * 
	 * 
	 * 
	 * */
	private void FileNomalization(){
		
		
		//create list file
		formalListFile = new File(formalFileName);
		//list对象
		formalList= new ArrayList<String>();
		
		//create list file
		newListFile = new File(newFileName);
		//list对象
		newList= new ArrayList<String>();
		
		
		
		PrintWriter out_newList = null;
		try {
			out_newList = new PrintWriter(new FileWriter(newFileName,true));			
			//out_newList = new PrintWriter("D:\\"+ SiteFileName+"_newList1.txt", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//如果目录不存在连目录一起创建
		if(!formalListFile.exists()) {
			try {
				formalListFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果目录不存在连目录一起创建
		if(!newListFile.exists()) {
			try {
				newListFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
		
		//进入下面的代码块,用于读取该网站的newList
		 try{			
			
			//BufferedReader 从lastFile文件中通过默认编码 读入文件
			 
			BufferedReader reader = new BufferedReader(
							new InputStreamReader(new FileInputStream(formalListFile), "utf-8"));
			//每次读入一行
			String line = reader.readLine();
			int i=0;
			//按行读入并按行修改 存入formalList
			//如果行中内容不为空则读入formalList
			while(line != null) {
				i++;
				formalList.add(line);
				line=line.replace("\t", ",");
				line=line.substring(0,line.lastIndexOf(","));
				
				
				
		/*		//模拟用户和物品都聚类以后的结果
				String element1=line.substring(0, line.indexOf(","));
				String element2=line.substring(line.indexOf(",")+1, line.lastIndexOf(","));
				long long1=Long.parseLong(element1)/100000;
				long long2=Long.parseLong(element2)/100000;			
//				line.replace(""+long1, element1);
//				line.replace(""+long2, element2);
				//System.out.println("element1"+Long.parseLong(element1)/100000+"element2"+Long.parseLong(element2)/100000);
				//改变格式 -1 变成1分 1变成5分
				if(line.endsWith(",-1"))
				{
					line=line.substring(0, line.length()-2);
					//line=line+"1";
					//产生一个1~3之间的随机数
					java.util.Random r=new java.util.Random(); 
					int random= r.nextInt(3)+1; 
					line=line+random;
					
					//变化后再组成一次
					line=""+long1+","+long2+","+random;

				}
				else{
					line=line.substring(0, line.length()-1);
					line=line+"5";
					
					//变化后再组成一次
					line=""+long1+","+long2+","+"5";
				}
				*/
				
				
				
				//修改后存储allist
				newList.add(line);
				out_newList.println(line);//把一行内容放入是输出内容 即写入到 打印流中去
				//out_newList.flush();								 
				System.out.println("第"+i+"条记录："+line+"\n");
				line = reader.readLine();

			}
			reader.close();	
			out_newList.println("");//最后会输入一行作为结束 ，按照约定
			out_newList.close();

			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//end debug block	
	}
	


}