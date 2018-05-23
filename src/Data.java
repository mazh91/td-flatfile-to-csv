
public class Data {

	final static int CONNECT_ID_LEN = 8;
	final static int PRODUCT_CODE_LEN = 8;
	final static int APPLICATION_ID_LEN = 3;
	final static int APPLICATION_LOGON_ID_LEN = 25;
	final static int CHANGED_TYPE = 1;
	final static int LOGON_ID_LEN = 25;
	final static int USER_ID_LEN = 8;
	final static int TIMESTAMP_LEN = 26;
	final static int APPLICATION_DATE_LEN = 10;

	String data;
	
	public Data(String data) {
		this.data = data;
	}
	
	public String getConnectId() {
		return nextData(CONNECT_ID_LEN);
	}
	
	public String getProductCode() {
		return nextData(PRODUCT_CODE_LEN);
	}
	
	public String getApplicationId() {
		return nextData(APPLICATION_ID_LEN);
	}
	
	public String getApplicationLogonId() {
		return nextData(APPLICATION_LOGON_ID_LEN);
	}
	
	public String getChangedType() {
		return nextData(CHANGED_TYPE);
	}
	
	public String getChangedByUserId() {
		return nextData(USER_ID_LEN);
	}
	
	public String getTimestamp() {
		return nextData(TIMESTAMP_LEN);
	}
	
	public String getApplicationIdActDate() {
		return nextData(APPLICATION_DATE_LEN);
	}
	
	/**
	 * Grab the next token from the data string
	 * @param length
	 * @return the data
	 */
	public String nextData(int length) {
		String result = data.substring(0, length);
		data = data.substring(length);
		return result;
	}
}
