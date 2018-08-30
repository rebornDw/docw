package work;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import ClassDemo.MethodDemo;

public class MethodGet {

	/**
	 * @author wei.ding
	 * 
	 *         方法名：getMethodInfo 参数 ：@param method 参数 ：@return
	 *         功能：将获取到的每个方法的信息封装为一个对象 返回值：MethodDemo
	 */
	public static MethodDemo getMethodInfo(Method method) {
		// 方法的修饰符
		int modifiers = method.getModifiers();
		String modify = Modifier.toString(modifiers);// private
		// 方法名称
		String name = method.getName();
		// 方法参数
		Class<?>[] parameterTypes = method.getParameterTypes();
		// 参数个数
		int parameterCount = method.getParameterCount();
		String type = "";
		for (int i = 0; i < parameterTypes.length; i++) {
			type = type + "," + parameterTypes[i].getName();
		}
		//转义一下尖括号
		type = type.replaceAll("<", "&lt;");
		type = type.replaceAll(">", "&gt;");
		// 方法的返回值
		Type genericReturnType = method.getGenericReturnType();// boolean
		genericReturnType.toString();
		MethodDemo methodDemo = new MethodDemo();
		methodDemo.setModify(modify);
		methodDemo.setName(name);
		methodDemo.setReturnCount(parameterCount);
		String returnType = genericReturnType.toString();	
		returnType = returnType.replaceAll("<", "&lt;");
		returnType = returnType.replaceAll(">", "&gt;");
		methodDemo.setReturnValue(returnType);
		methodDemo.setType(type);
		return methodDemo;

	}
}
