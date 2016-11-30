package com.wangsong.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gui.ava.html.image.generator.HtmlImageGenerator;  
/** 
* HTML2JPG,HTML页面转图片的实现方法。 
*/  
public class HtmlConverterUtil {  

	public static void Html2Img(String html, String img, Map<String, Object> map,InputStream is) throws IOException {
		String htmlStr =readerHtml(html,is);
		String htmlStrReplaceStr =HtmlStrReplace(htmlStr,map);
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		imageGenerator.loadHtml(htmlStrReplaceStr);
		imageGenerator.saveAsImage(img) ;
	}
	
	public static void Html2Pdf(String html,String pdf,Map<String,Object> map,InputStream is) throws IOException, DocumentException {
    	File file = new File(pdf);
        file.getParentFile().mkdirs();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        String htmlStr =readerHtml(html,is);
		String htmlStrReplaceStr =HtmlStrReplace(htmlStr,map);
        InputStream streamTemp = new ByteArrayInputStream(htmlStrReplaceStr.getBytes()); 
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, streamTemp, Charset.forName("UTF-8"));
        document.close();
    }
	
	
	 static String readerHtml(String html,InputStream is) throws IOException{
		 FileInputStream fis;
		 InputStreamReader reader;
		 if(html!=null){
			 	fis = new FileInputStream(html);
				reader = new InputStreamReader(fis,"UTF-8"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
		 }else{
				reader = new InputStreamReader(is,"UTF-8"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
				
		 }
		 BufferedReader br = new BufferedReader(reader);
		String htmlStr = "";
		String line;
		while ((line = br.readLine()) != null) {
			htmlStr+=line;
		}
		br.close();
		reader.close();
		return htmlStr;
		
	}
	
	private static String HtmlStrReplace(String htmlStr, Map<String, Object> mapAll){
		Set<String> setAll = mapAll.keySet();   
		for (String keyAll:setAll) {  
			Object valueAll=mapAll.get(keyAll);
			if(valueAll instanceof List){
				String ListKey=keyAll;
				keyAll=keyAll.replace("{", "\\{").replace("}", "\\}").replace("$", "\\$");
				String head[] = htmlStr.split(keyAll);
				String tail[] =head[1].split(keyAll);
				String replaceKey=ListKey+tail[0]+ListKey;
				String listStr="";
				String listStrOne="";
				List<Map<String,String>> listMap =(List)valueAll;
				for(int i=0;i<listMap.size();i++){
					listStrOne=tail[0];
					Map<String,String> listMapOne= listMap.get(i);
					Set<String> listset = listMapOne.keySet();   
					for (String MapOne:listset) {  
						listStrOne= listStrOne.replace(MapOne, listMapOne.get(MapOne));
					}
					listStr+=listStrOne;
				 }
				 htmlStr= htmlStr.replace(replaceKey, listStr);
			}else{
				htmlStr= htmlStr.replace(keyAll, valueAll==null?"":valueAll.toString());
			}
		}  
		return htmlStr;
	}
	
	 
	 
	
	public static void main(String[] args) throws IOException, DocumentException  {  
		Map<String,Object> map=new HashMap<>();
    	map.put("${wangsong}", 1);
    	map.put("${zhangsan}", "张三");
    	List<Map<String,String>> list=new ArrayList<>();
    	Map<String,String> map2=new HashMap<>();
    	map2.put("${id}", "1");
    	map2.put("${name}", "王");
    	list.add(map2);
    	Map<String,String> map3=new HashMap<>();
    	map3.put("${id}", "2");
    	map3.put("${name}", "松");
    	list.add(map3);
    	map.put("${list}", list);
    	Html2Pdf("D:/Html2Pdf.html","D:/Html2Pdf.pdf",map,null);
    	Html2Img("D:/Html2Img.html","D:/Html2Img.png",map,null);
	}

	
	
}  