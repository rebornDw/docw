package work;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassDemo.MethodDemo;
import createdoc.Entity;
import createdoc.FreemarkerForDoc;



public class ClassGet {




	/**
	 *<h4>方法名：classInfo<h4>
	 *<ul>
	 *<li>参数 ： packages 要扫描的包   eg:"com.bs.work.controller" 视情况而定
	 *<li>参数 ： prefix  项目的根目录  eg:"src.main.java" 普通项目为"src" 视情况而定
	 *<li>参数 ： path 保存在本地的路径 eg:"D:/wordTest/"
	 *</ul>
	 *<h5>
	 *功能：通过输入根目录（src）和类名前缀（com.XX.XX）获取信息，将包下的所有类划分，每个类的方法生成表格对应到path中生成文档
	 *</h5>
	 *返回值：boolean
	 */
	public boolean classInfo(String packages,String prefix,String path){
		Map<String, Object>map=new HashMap<String,Object>();

        List<String> getClassNames = PackageUtil.GetClassNames(prefix, packages);

        for (String className : getClassNames) {
            System.out.println(className);
            try {
				Class<?> c = Class.forName(className);
				Method[] declaredMethods = c.getDeclaredMethods();
				List<Entity> entityList=new ArrayList<Entity>();
				map.put("className",className);
				map.put("entityList",entityList);
				for(int i=0;i<declaredMethods.length;i++){
					MethodDemo methodInfo = MethodGet.getMethodInfo(declaredMethods[i]);
					map= this.GetEnity(map,methodInfo);
				}
				FreemarkerForDoc ffd=  new	FreemarkerForDoc();
				ffd.toDoc(map, className,path);
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return false;
			}
        }
        return true;
	}
	
	

	
	/**
	 *<h4>方法名：classInfo<h4>
	 *<ul>
	 *<li>参数 ： className 指定要生成文档的类 eg:""com.bs.work.controller.UserController""
	 *<li>参数 ： path 保存在本地的路径 eg:"D:/wordTest/"
	 *</ul>
	 *<h5>
	 *功能：指定一个类的名字在对应的path生成文档
	 *</h5>
	 *返回值：boolean
	 */
	public boolean  classInfo(String className,String path){ 
		Map<String,Object>map=new HashMap<String,Object>();
            try {
				Class<?> c = Class.forName(className);
				Method[] declaredMethods = c.getDeclaredMethods();
				List<Entity> entityList=new ArrayList<Entity>();
				map.put("entityList",entityList);
				map.put("className",className);
				for(int i=0;i<declaredMethods.length;i++){
					MethodDemo methodInfo = MethodGet.getMethodInfo(declaredMethods[i]);
					this.GetEnity(map,methodInfo);
				}
	        	FreemarkerForDoc ffd=  new	FreemarkerForDoc();
					ffd.toDoc(map, className,path);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				return false;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
        return true;
	}
	
	

	/**
	 *<h4>方法名：classInfo<h4>
	 *<ul>
	 *<li>参数 ： className 指定要生成文档的类 eg:""com.bs.work.controller.UserController""
	 *<li>参数 ： path 保存在本地的路径 eg:"D:/wordTest/"
     *<li>参数 ： ftlName 指定一个word模板 注意不需要加.ftl后缀   eg:假如模板路径为"src/util/muban1.ftl"  只传muban1名称，就可以了
     *<li>参数 ： ftlPath 模板存放的路径 （项目的相对路径，可以放在包中） eg：假如模板路径为"src/util/muban1.ftl"  那么只写/util 就可以了 
	 *</ul>
	 *<h5>
	 *功能：指定一个类的名字在对应的path，根据自己提供的word模板生成文档
	 *模板说明：模板为.ftl的文件
	 *</h5>
	 *模板变量配置:
	 *<ul>
	 *<li>参数 ：${className}   类名称
	 *<li>参数 ：${li.modifier}   方法修饰符
     *<li>参数 ： ${li.name}   方法名
     *<li>参数 ： ${li.returnCount}   参数个数
     *<li>参数 ： ${li.type}   参数类型
     *<li>参数 ： ${li.returnValue}   返回值
     *<li>参数 ： ${li.fc}   功能说明
	 *</ul>
	 *具体配置方式：新建一个word文档，然后编写word模板，保存为xml格式的文件，将上述变量替换到对应的位置，将内容粘贴到后置为.ftl文件中即可。
	 *
	 *返回值：boolean
	 */
	public boolean  classInfo(String className,String path,String ftlName ,String ftlPath){ 
		Map<String,Object>map=new HashMap<String,Object>();
            try {
				Class<?> c = Class.forName(className);
				Method[] declaredMethods = c.getDeclaredMethods();
				List<Entity> entityList=new ArrayList<Entity>();
				map.put("entityList",entityList);
				map.put("className",className);
				for(int i=0;i<declaredMethods.length;i++){
					MethodDemo methodInfo = MethodGet.getMethodInfo(declaredMethods[i]);
					this.GetEnity(map,methodInfo);
				}
	        	FreemarkerForDoc ffd=  new	FreemarkerForDoc();
					ffd.toDoc(map, className,path,ftlName,ftlPath);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				return false;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
        return true;
	}
	
	/**
	 *<h4>方法名：classInfo<h4>
	 *<ul>
	 *<li>参数 ： packages 要扫描的包   eg:"com.bs.work.controller" 视情况而定
	 *<li>参数 ： prefix  项目的根目录  eg:"src.main.java" 普通项目为"src" 视情况而定
	 *<li>参数 ： path 保存在本地的路径 eg:"D:/wordTest/"
     *<li>参数 ： ftlName 指定一个word模板 注意不需要加.ftl后缀   eg:假如模板路径为"src/util/muban1.ftl"  只传muban1名称，就可以了
     *<li>参数 ： ftlPath 模板存放的路径 （项目的相对路径，可以放在包中） eg：假如模板路径为"src/util/muban1.ftl"  那么只写/util 就可以了 
	 *</ul>
	 *<h5>
	 *功能：通过输入根目录（src）和类名前缀（com.XX.XX）获取信息，将包下的所有类划分，每个类的方法生成表格对应到path中生成文档,
	 *     文档的格式为模板的格式
	 *</h5>
	 *	 *模板说明：模板为.ftl的文件
	 *模板变量配置:
	 *<ul>
	 *<li>参数 ：${className}   类名称
	 *<li>参数 ：${li.modifier}   方法修饰符
     *<li>参数 ： ${li.name}   方法名
     *<li>参数 ： ${li.returnCount}   参数个数
     *<li>参数 ： ${li.type}   参数类型
     *<li>参数 ： ${li.returnValue}   返回值
     *<li>参数 ： ${li.fc}   功能说明
     *
	 *</ul>
	 *具体配置方式：新建一个word文档，然后编写word模板，保存为xml格式的文件，将上述变量替换到对应的位置，将内容粘贴到后置为.ftl文件中即可。
	 *</h5>
	 *返回值：boolean
	 */
	public boolean classInfo(String packages,String prefix,String path,String ftlName ,String ftlPath){
		Map<String, Object>map=new HashMap<String,Object>();

        List<String> getClassNames = PackageUtil.GetClassNames(prefix, packages);

        for (String className : getClassNames) {
            System.out.println(className);
            try {
				Class<?> c = Class.forName(className);
				Method[] declaredMethods = c.getDeclaredMethods();
				List<Entity> entityList=new ArrayList<Entity>();
				map.put("className",className);
				map.put("entityList",entityList);
				for(int i=0;i<declaredMethods.length;i++){
					MethodDemo methodInfo = MethodGet.getMethodInfo(declaredMethods[i]);
					map= this.GetEnity(map,methodInfo);
				}
				FreemarkerForDoc ffd=  new	FreemarkerForDoc();
				ffd.toDoc(map, className,path,ftlName,ftlPath);
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return false;
			}
        }
        return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> GetEnity(Map<String,Object>map,MethodDemo methodInfo){
		//用于插入单元格s
		Entity entity = new Entity(methodInfo.getModify(),methodInfo.getName(),methodInfo.getReturnCount()
				,methodInfo.getReturnValue(),methodInfo.getExInfo(),methodInfo.getType(),methodInfo.getFc());
		((List<Entity>) map.get("entityList")).add(entity);
		
		return map;
	}

}
