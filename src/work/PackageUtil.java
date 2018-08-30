package work;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class PackageUtil{

    /**
     * @author wei.ding
     * 
     * @param prefix 前缀 倘若使用SpringBoot项目,则需要加上前缀src.main.java,普通Java项目需要加src
     * @param packages 包名
     * @return
     */
    public static List<String> GetClassNames(String prefix, String packages){
        File file = new File(System.getProperty("user.dir") 
                        + ((!(prefix=="")) ? ("\\" + prefix.replace(".", "\\") + "\\") : "\\") 
                        + packages.replace(".", "\\"));
        List<String> classNames = new ArrayList<>();
        if (file.exists()){
            String[] list = file.list();
            for (String className : list){
                classNames.add(packages + "." + className.replace(".java", ""));
            }
        }
        return classNames;
    }
    
}