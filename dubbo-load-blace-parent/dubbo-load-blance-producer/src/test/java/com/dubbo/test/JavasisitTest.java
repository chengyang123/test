package com.dubbo.test;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class JavasisitTest {
	public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, InstantiationException, IllegalAccessException {
		ClassPool pool = ClassPool.getDefault();
		/*CtClass cc = pool.get("com.dubbo.test.ClazzTT");
		//cc.setSuperclass(pool.get("test.Point"));
		cc.writeFile();
		byte[] b = cc.toBytecode();
		Class clazz = cc.toClass();
		System.out.println(clazz)*/;
		
		CtClass cc = pool.makeClass("foo");
		CtMethod mthd = CtNewMethod.make("public Integer getInteger() { return null; }", cc);
		cc.addMethod(mthd);
		CtField f = new CtField(CtClass.intType, "i", cc);
		cc.addField(f);
		Class clazz = cc.toClass(); 
		Object instance = clazz.newInstance();
		
		System.out.println(cc);
	}
}
