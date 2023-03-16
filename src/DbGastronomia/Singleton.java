package DbGastronomia;

public class Singleton {

	private String value;

	
	 public static Singleton instance= null;
	 
	 private Singleton() {}
	 
	 public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
	

	
}
