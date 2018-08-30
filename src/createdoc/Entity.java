package createdoc;


public class Entity {

	private String modifier;

	private String name;
	
	private int returnCount;
	
	private String type;
	
	private String returnValue;
	
	private String exInfo;

	public Entity(String modifier, String name, int returnCount,String returnValue, String exInfo
			,String type) {
		super();
         this.modifier=modifier;
         this.name=name;
         this.returnCount=returnCount;
         this.returnValue=returnValue;
         this.exInfo=exInfo;
         this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	public String getExInfo() {
		return exInfo;
	}

	public void setExInfo(String exInfo) {
		this.exInfo = exInfo;
	}
	
	
	
}
