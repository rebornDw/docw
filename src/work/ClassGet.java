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
	 * @author wei.ding
	 * 
	 *方法名：classInfo
	 *参数 ：@param packages 该项目的根目录
	 *前缀 倘若使用SpringBoot项目,则需要加上前缀src.main.java,普通Java项目需要加src
	 *参数 ：@param prefix 当前类所在包下
	 *参数 ：@param path
	 *功能：通过输入根目录（src）和类名前缀（com.XX.XX）获取信息，将方法映射到对应路径path中
	 *返回值：void
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
	    		ffd.toDoc(map, path);
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return false;
			}
    		
        }

        return true;
	}
	
	

	
	/**
	 * @author wei.ding
	 * 
	 *方法名：classInfo
	 *参数 ：@param packages
	 *参数 ：@param prefix
	 *功能：通过输入完整的类名获取信息 eg：（com.work.Test）
	 *返回值：void
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
	    		ffd.toDoc(map, path);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				return false;
			}

        return true;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> GetEnity(Map<String,Object>map,MethodDemo methodInfo){

           
		//用于插入单元格s
		Entity entity = new Entity(methodInfo.getModify(),methodInfo.getName(),methodInfo.getReturnCount()
				,methodInfo.getReturnValue(),methodInfo.getExInfo(),methodInfo.getType());

		((List<Entity>) map.get("entityList")).add(entity);
		
		return map;
	}

}
