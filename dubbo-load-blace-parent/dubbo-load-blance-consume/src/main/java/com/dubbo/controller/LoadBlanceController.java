package com.dubbo.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dubbo.interfaces.LoadBlanceInterface;

@Controller
@RequestMapping("/loadblance")
public class LoadBlanceController {

	@Autowired
	private LoadBlanceInterface lbi;
	
	@RequestMapping("/test/{name}")
	public ModelAndView LoadBlanceTest(@PathVariable("name")String name) throws UnsupportedEncodingException{
		byte bb[];
	    bb = name.getBytes("ISO-8859-1"); //以"ISO-8859-1"方式解析name字符串
	    name= new String(bb, "UTF-8"); //再用"utf-8"格式表示name
		ModelAndView mv = new  ModelAndView();
		mv.setViewName("success");
		mv.addObject("result", lbi.LoadBlanceTest(name));
		return mv;
	}
}
