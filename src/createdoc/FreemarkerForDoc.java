package createdoc;


import java.io.IOException;
import java.util.Map;
import createdoc.FreeMarkerUtil;
import createdoc.UuidUtil;

public class FreemarkerForDoc {
	public  void toDoc(Map<String, Object> map,String wordPath) {
		try {
			//word
		FreeMarkerUtil.createDoc(map,"test","/createdoc",UuidUtil.get32UUID(),wordPath,".doc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

