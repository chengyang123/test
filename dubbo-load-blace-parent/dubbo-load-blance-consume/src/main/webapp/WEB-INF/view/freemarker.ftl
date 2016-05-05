<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freemarkerTest</title>
</head>
<body>
	<!--1,插值结果为字符串值:直接输出表达式结果 
	2,插值结果为数字值:根据默认格式(由#setting指令设置)将表达式结果转换成文本输出.
	可以使用内建的字符串函数-->
	<#setting number_format="currency"/> <!--currency是货币的意思-->
	<#assign answer=42/> <!--这个用法用于指定一个名为name的变量,该变量的值为value,-->
	${answer}<br/>
	${answer?string} <br/><#-- the same as ${answer} --> 
	${answer?string.number} <br/>
	${answer?string.currency} <br/>
	${answer?string.percent}<br/> 
	${answer} 
	<hr/><!--日期的插入-->
	${lastUpdated?string("yyyy-MM-dd HH:mm:ss zzzz")}<br/>
	${lastUpdated?string("EEE, MMM d,yy")} <br/>
	${lastUpdated?string("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'")} <br/>
	<hr/><!--boolean值插入-->
	<#assign foo=true/> <br/>
	${foo?string("yes", "no")} 
	<hr/>
	<#--数字格式化插值可采用#{expr;format}形式来格式化数字,其中format可以是:
	 mX:小数部分最小X位 
	MX:小数部分最大X位 
	如下面的例子: -->
	<#assign x=2.582/> <br/>
	<#assign y=4/> <br/>
	#{x; M2}<br/> <#-- 输出2.58 --> 
	#{y; M2} <br/><#-- 输出4 --> 
	#{x; m2}<br/> <#-- 输出2.58 --> 
	#{y; m2} <br/><#-- 输出4.00 --> 
	#{x; m1M2}<br/> <#-- 输出2.58 --> 
	#{y; m1M2} <#-- 输出4.0 -->
	<hr/><!--字符串的输出-->
	${"我的文件保存在C:\\盘"} <br/>
	${'我名字是\"annlee\"'} 
	<hr/>
	<#--特殊字符的输出,使用r标志,r标志后的内容会直接输出-->
	${r"${foo}"} <br/>
	${r"C:\foo\bar"} 
	<hr/><#--集合-->
	<#list ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as x> 
		${x}<br/>
	</#list> 
	<hr/><#--集合-->
	<#list [2 + 2, 9, "whatnot"] as y>
		${y}<br/>
	</#list>
	<hr/><#--2..5等同于[2,3,4,5]-->
	<#list 2..5 as z>
		${z}<br/>
	</#list>
	<hr/><#--map集合的使用-->
	<#assign scores = {"语文":86,"数学":78} + {"数学":87,"Java":93}> 
	语文成绩是${scores.语文} 
	数学成绩是${scores.数学} 
	Java成绩是${scores.Java} 
	<hr/><#--int类型的处理,强转成int类型-->
	<#assign x=5> 
	${ (x/2)?int }<br/> 
	${ 1.1?int } <br/>
	${ 1.999?int } <br/>
	${ -1.1?int } <br/>
	${ -1.999?int }<br/>
	<hr/><#--内建函数，使用符合?-->
	<#--html:对字符串进行HTML编码 
	cap_first:使字符串第一个字母大写 
	lower_case:将字符串转换成小写 
	upper_case:将字符串转换成大写 
	trim:去掉字符串前后的空白字符
	size:获取序列中元素的个数
	int:取得数字的整数部分,结果带符号   -->
	<#assign test="Tom & Jerry"> 
	${test?html} <br/>
	${test?upper_case?html} 
	<hr/>
	<#--空值问题,freemarker中出现空值会报错,
	使用!和??来处理空值
	!:指定缺失变量的默认值 
	??:判断某个变量是否存在 -->
	${user!"游客"}	
	<#if user??>
		${user}
		<#else>游客2
	</#if>
	<#--如果var is null那么将会被hello world<br>替代,<br/>使用了html格式编码输出会显示在页面上 -->
	${var?default("hello world<br/>")?html}
	<hr/>
	<#--if指令-->
	<#assign age=23> 
	<#if (age>60)>老年人 
		<#elseif (age>40)>中年人 
		<#elseif (age>20)>青年人 
		<#else> 少年人 
	</#if>
 
	<hr/>
	<#--switch指令-->
	<#assign tmp=2>
	<#switch tmp>
		<#case 1>值为1<#break> 
		<#case 2>值为2<#break> 
		<#default>值为3 
	</#switch>

	<hr/>
	<#--list指令,_index是索引,_has_next是判断是否存在下一个数据-->
	<#list  ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as x>
		${(x_index + 1)?string.number}.${x}<#if x_has_next>,</#if>
		<#--<#if x="星期四"><#break></#if> -->
	</#list> 

	<hr/>
	<#--include和import指令-->
	<#--noparse指令,不解析里面的内容-->
	<#noparse> 
		<#list books as book> 
  	 		<tr><td>${book.name}<td>作者:${book.author} 
		</#list> 
	</#noparse> 

	<hr/>
	<#--escape指令和noescape指令-->
	<#assign firstName="jack">
	<#assign lastName="rose">
	<#assign maidenName="andy">
	<#escape x as x?html> 
		First name:${firstName} <br/>
		Last name:${lastName} <br/>
		Maiden name:${maidenName} 
	</#escape> 

	<hr/><#--通过服务器获得数据-->
	<#if list??>
		<#list list as x>
			${x}<br/>
		</#list>
		<#else>为空
	</#if>
	
	<hr/>
	<#--全局赋值使用global指令-->
	<#global name="zcy">
	${name}<br/>
	<#assign name="ce"><#--使用assign会隐藏掉同名的name属性-->
	${name}<br/>
	${.globals.name}<!--使用.golbals来获得被隐藏的全局变量-->
	<hr/>
	<#--
	setting 语法 
	<#setting name=value> 
	用来设置整个系统的一个环境 
	locale 
	number_format 
	boolean_format 
	date_format, time_format, datetime_format 
	time_zone 
	classic_compatible 
	-->
	<hr/>
	<#--截取子串-->
	<#assign str="dsjflkdsjlf">
	${str[1..3]}<#--截取1-3的字符-->
	<hr/>
	<#--比较运算符-->
	<#--
		表达式中支持的比较运算符有如下几种：
		1. =（或者==）： 判断两个值是否相等；
		2. !=： 判断两个值是否不相等；
		注： =和!=可以用作字符串、数值和日期的比较，但两边的数据类型必须相同。而且FreeMarker的比较是精确比较，不会忽略大小写及空格。
		3. >（或者gt）： 大于
		4. >=（或者gte）： 大于等于
		5. <（或者lt）： 小于
		6. <=（或者lte）： 小于等于
		注： 上面这些比较运算符可以用于数字和日期，但不能用于字符串。
		大部分时候，使用gt比>有更好的效果，因为FreeMarker会把>解释成标签的结束字符。
		可以使用括号来避免这种情况，如：<#if (x>y)>。
		
	-->
	<#assign num=18>
	<#if num gte 18>
		成年
		<#else>未成年
	</#if>
	<hr/>
	<#--集合的内建函数size的用法-->
	<#assign ll=[1,2,3,4,5]>
	${ll?size?string.number}<br/>
	<#--数值型的内建函数int，获取数字的整数部分-->
	<#assign ii=123.88>
	${ii?int?string.number}
	${ii?if_exists?string.number}
	<hr/>
	<#assign passwords={"name":"zcy"}>
	<#assign passwords=passwords+{"xx":"yy"}>
	${passwords.name}<br/>
	${passwords.xx}
	<hr/><#--include的使用-->
	<#include "text.txt">
	<hr/>
	<#--自定义的宏指令-->
	<#macro m1>
		<b>aaaa</b>
		<b>bbbb</b>
	</#macro>
	<@m1/><#--调用上面的宏命令-->
	<hr/>
	<#--带参数的宏命令-->
	<#macro m2 a b c>
		${a}--${b}--${c}
	</#macro>
	<@m2 a="张三" b="李四" c="王五"/>
	<hr/><#--netset指令,netset里面的内容需要自己填充,也可以为空-->
	<#macro border> 
  		<table border=4 cellspacing=0 cellpadding=4><tr><td> 
    		<#nested> 
  		</td></tr></table> 
	</#macro>
	<@border>表格中内容</@border><br/>
	<@border></@border>
	
	<hr/>
	<#import "b.ftl" as bb/>
	<@bb.copyright date="2015-2016"/>
	${bb.mail}<br/>
	<#assign mail="123@163.com"/>
	${mail}<br/>
	<#assign mail="456@163.com" in bb/>
	${bb.mail}
	<hr/>
	<#--其他注意事项-->
	<#assign animal={"python":{"price":50}}>
	${animal.python.price?string.number}
	<#--
		把animal.telephone.price看成一个整体使用()包起来这样中间任何一个值为空都会取默认值
		,否则只判断最后一个字段的值-->
	${(animal.telephone.price)?default(0?string.number)}
	${(animal.telephone.price)!0?string.number}
	<#--上面两种的写法是一致的-->
	<hr/>
	<#assign x=8>
	<#assign y=3>
	<#--保留4位小数-->
	${(x/y)?string("#.####")}<br/>
	<#--${x gt y}这种写法是不正确的-->
	<#--可以使用这种方式来写-->
	${(x gt y)?string("yes","no")}
	<#if x gt y>
		x大于y
		<#else>x小于y
	</#if>
	
	<hr/>
	<#--字符串的拼接-->
	<#assign uu="zcy">
	${"hello ${uu}"}<br/>
	${"${uu} ${uu} ${uu} "}<br/>
	${"hello "+uu}<br/>
	${uu + uu + uu}<br/>
	${uu[0]}<#--字符串实际上是一个字符序列-->
	<hr/><#--变量定义是有顺序的-->
	${mouse!"No mouse."}
	<#assign mouse="Jerry">
	${mouse!"No mouse."}
	<hr/>
	<#macro greet person color>
		<font size="+2" color="${color}">Hello ${person}!</font>
	</#macro>
	<@greet person="zcy" color="red"/>
	<hr/>
	<#--嵌套宏命令的使用-->
	<#macro tablet>
		<table border=4 cellspacing=0 cellpadding=4>
			<tr><td><#nested></td></tr>
		</table>
	</#macro>
	
	<#macro do_thrice>
		<#nested 1>
		<#nested 2>
		<#nested 3>
	</#macro>
	
	<#macro font>
		<font size="+2">Hello Joe!</font>
	</#macro>
	
	<@tablet>
		<ul>
			<@do_thrice>
				<li><@font/>
			</@do_thrice>
		</ul>
	</@tablet>
	<hr/>
	<#--调用方法-->
	<#assign methodargs="something">
	${(indexOf("met",methodargs))}<br/>
	${indexOf("foo",methodargs)}
	<hr/>
	<#--自定义的代码指令-->
	<@upper>
		bar
		<#-- 这里允许使用所有的FTL -->
		<#list ["red", "green", "blue"] as color>
			${color}
		</#list>
		baaz
	</@upper>
	<hr/>
	<#assign x = 1>
	<@repeat count=4>
		Test ${x?string.number}
		<#assign x = x + 1>
	</@repeat>
	<@repeat count=3 hr=true>
		Test
	</@repeat>
	<@repeat count=3; cnt><#--;类似于as-->
		${cnt?string.number}. Test
	</@repeat>
</body>
</html>