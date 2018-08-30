package ClassDemo;

import java.lang.reflect.Method;

public class ClassInfo {

	public String Classname;
	public Method[] method;
	
	public String getClassname() {
		return Classname;
	}
	public void setClassname(String classname) {
		Classname = classname;
	}
	public Method[] getMethod() {
		return method;
	}
	public void setMethod(Method[] method) {
		this.method = method;
	}
	
	
}
