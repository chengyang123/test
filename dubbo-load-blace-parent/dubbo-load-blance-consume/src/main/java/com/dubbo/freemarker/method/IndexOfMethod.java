package com.dubbo.freemarker.method;

import java.util.List;

import freemarker.core.Environment;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleList;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
//定义freemarker的方法
public class IndexOfMethod implements TemplateMethodModel {
	//传入的参数是一个集合,前台("3","4")这样来调用
	public TemplateModel exec(List args) throws TemplateModelException {
		//freemarker获取本地运行时的变量
		Environment environment = Environment.getCurrentEnvironment();
		if (args.size() != 2) {
			throw new TemplateModelException("Wrong arguments");
		}
		/*return new SimpleNumber(((String) args.get(1)).indexOf((String) args
				.get(0)));*/
		
		return new SimpleScalar(((String)args.get(1))+args.get(0));
		//SimpleNumber代表数字
		//SimpleScalar代表字符串
		//SimpleHash代表hash
		//SimpleSequence代表序列
	}
}