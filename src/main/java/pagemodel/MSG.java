package pagemodel;

public class MSG {
	String state;
	
	Object obj;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public MSG(String state) {
		this.state = state;
	}
	
	public MSG(String state, Object obj) {
		this.state = state;
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
