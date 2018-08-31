package createdoc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;



public class FreeMarkerUtil {
	private static Configuration configuration = null;
	private static Map<String, Template> allTemplates = null;

	private FreeMarkerUtil() {
		throw new AssertionError();
	}

	/**
	 * @param dataMap map数据
	 * @param type  ftl模板名称
	 * @param path   模板路径
	 * @param fileName    生成自定义的word文件名称
	 * @param wordPath    可配的指定的文件路径
	 * @param suffix    文件后缀    例如：.doc 
	 * @return
	 * @throws IOException
	 */
	public static File createDoc(Map<?, ?> dataMap, String type, String path,
			String fileName,String wordPath,String suffix) throws IOException {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		configuration.setOutputEncoding("UTF-8");
		configuration.setLocale(Locale.CHINA);
		configuration.setClassicCompatible(true);
		configuration.setClassForTemplateLoading(FreeMarkerUtil.class, path);
		allTemplates = new HashMap<String, Template>();
		Writer w =null;
		try {
			allTemplates.put(type, configuration.getTemplate(type + ".ftl"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
		String name = fileName + suffix;
		if (!"/".equals(wordPath.substring(wordPath.length()-1))) {
			name = "/" + name;
		}
		wordPath = wordPath + name;
		File f = new File(wordPath);
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdirs();
		}
		
		Template t = allTemplates.get(type);
		try {
			w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
			t.process(dataMap, w);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			w.flush();
			w.close();
		}
		return f;
	}
	
	
	
	
}
