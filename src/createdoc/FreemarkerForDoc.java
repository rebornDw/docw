package createdoc;


import java.io.IOException;
import java.util.Map;
import createdoc.FreeMarkerUtil;
import createdoc.UuidUtil;

public class FreemarkerForDoc {
	
	
	/**
	 *方法名：toDoc
	 *参数 ：@param map
	 *参数 ：@param wordPath
	 *功能：创建一个word文档，名称为uuid随机分配
	 *返回值：void
	 */
	public  void toDoc(Map<String, Object> map,String wordPath) {
		try {
			//word
		FreeMarkerUtil.createDoc(map,"test","/createdoc",UuidUtil.get32UUID(),wordPath,".doc");
		System.out.println("已经创建"+wordPath+UuidUtil.get32UUID()+".doc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
	
	
	/**
	 *方法名：toDoc
	 *参数 ：@param map
	 *参数 ：@param className
	 *参数 ：@param wordPath
	 *功能：创建一个根据类名规定的word文档
	 *返回值：void
	 */
	public  void toDoc(Map<String, Object> map,String className,String wordPath) {
		try {
			//word
		FreeMarkerUtil.createDoc(map,"test","/createdoc",className,wordPath,".doc");
		System.out.println("已经创建"+wordPath+className+".doc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	

	/**
	 *方法名：toDoc
	 *参数 ：@param map
	 *参数 ：@param className
	 *参数 ：@param wordPath
	 *参数 ：@param fltName
	 *参数 ：@param ftlPath
	 *功能：根据提供的邮件模板去生成开发文档
	 *返回值：void
	 */
	public  void toDoc(Map<String, Object> map,String className,String wordPath,String fltName,String ftlPath) {
		try {
			//word
		FreeMarkerUtil.createDoc(map,fltName,ftlPath,className,wordPath,".doc");
		System.out.println("已经创建"+wordPath+className+".doc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}

