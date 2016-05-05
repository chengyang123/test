package com.dubbo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dubbo.freemarker.method.IndexOfMethod;
import com.dubbo.freemarker.method.RepeatDirective;
import com.dubbo.freemarker.method.UpperDirective;

@Controller
@RequestMapping("/freemark")
public class FreemarkerController {
	
	@RequestMapping("/test")
	public ModelAndView FreemarkerTest(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("freemarker");
		mv.addObject("lastUpdated", new Date());
		List<String> list = new ArrayList<>();
		list.add("英文");
		list.add("数学");
		list.add("历史");
		//list = null;
		mv.addObject("list",list);
		mv.addObject("user","周晨阳");
		mv.addObject("indexOf", new IndexOfMethod());//放入一个方法对象
		mv.addObject("upper", new UpperDirective());
		mv.addObject("repeat",new RepeatDirective());
		return mv;
	}

}
