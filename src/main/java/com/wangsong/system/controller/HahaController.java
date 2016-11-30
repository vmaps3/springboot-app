package com.wangsong.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Page;
import com.wangsong.common.util.HtmlConverterUtil;
import com.wangsong.system.model.Dict;
import com.wangsong.system.service.DictService;

@Controller
@RequestMapping("/haha")
public class HahaController extends BaseController{
	
	
	@RequestMapping(value="/haha")
	@ResponseBody
	public Object haha(String username) {
		Map<String,Object> map=new HashMap<>();
		if("123123".equals(username)){
			map.put("key", "1");
		}else{
			map.put("key", "0");
		}
		return map;
	}
	
	@RequestMapping(value="/tozhuce")
	public String tozhuce() {
		
		return "system/haha/zhuce"; 
	}
	
	@RequestMapping(value="/zhuce")
	public String zhuce() {
		//ahahhaah
		return "redirect:http://127.0.0.1:8081/spring-app/haha/yewu.do"; 
	}
	
	@RequestMapping(value="/yewu")
	@ResponseBody
	public String yewu(HttpServletRequest httpServletRequest) {
		
		return "yewu"; 
	}
	
	@RequestMapping(value="/pdf")
	public void html(HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException, DocumentException {
		String dir = httpServletRequest.getSession().getServletContext().getRealPath("/")+"tmp/";
		Map<String,Object> map=new HashMap<>();
    	map.put("${wangsong}", 1);
    	map.put("${zhangsan}", "张三");
    	map.put("${url}", httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath());
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
    	InputStream Html2Pdf=HtmlConverterUtil.class.getResourceAsStream("/htmlConverter/Html2Pdf.html");
    	
    	
    	String Html2PdfName=dir+"Html2Pdf-"+UUID.randomUUID()+".pdf";
		HtmlConverterUtil.Html2Pdf(null, Html2PdfName, map,Html2Pdf);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="+ "Html2Pdf.pdf");

		File f=new File(Html2PdfName);
		InputStream inputStream = new FileInputStream(f);

		OutputStream os = response.getOutputStream();
		byte[] b = new byte[2048];
		int length;
		while ((length = inputStream.read(b)) > 0) {
			os.write(b, 0, length);
		}

		 // 这里主要关闭。
		os.close();
		inputStream.close();
		f.delete();
		
	}
	@RequestMapping(value="/img")
	public void img(HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException, DocumentException {
		String dir = httpServletRequest.getSession().getServletContext().getRealPath("/")+"tmp/";
		Map<String,Object> map=new HashMap<>();
    	map.put("${wangsong}", 1);
    	map.put("${zhangsan}", "张三");
    	map.put("${url}", httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath());
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
    	InputStream Html2Img=HtmlConverterUtil.class.getResourceAsStream("/htmlConverter/Html2Img.html");
    	
    	
    	String Html2ImgName=dir+"Html2Img-"+UUID.randomUUID()+".png";
		HtmlConverterUtil.Html2Img(null, Html2ImgName, map,Html2Img);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="+ "Html2Pdf.png");

		File f=new File(Html2ImgName);
		InputStream inputStream = new FileInputStream(f);

		OutputStream os = response.getOutputStream();
		byte[] b = new byte[2048];
		int length;
		while ((length = inputStream.read(b)) > 0) {
			os.write(b, 0, length);
		}

		 // 这里主要关闭。
		os.close();
		inputStream.close();
		f.delete();
		
	}
}
