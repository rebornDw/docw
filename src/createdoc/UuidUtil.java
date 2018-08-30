package createdoc;
import java.util.UUID;
/**
 * UUID生成工具类
 * 去除uuid生成过程中产生的中横杠
 * **/
public class UuidUtil {

	public static String get32UUID() {
        String uuid=UUID.randomUUID().toString();
        return uuid;      
	}

}
