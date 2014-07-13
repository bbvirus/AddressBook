
public class Util {
	public static String[] parseData(String data) {
		String[] buffer = data.split(" ", 2);
		return buffer;
	}
	
	/*
	 * insert 시 입력한 값이 유효한지 확인하는 메서드
	 */
	public static boolean insertValidation(String data, int paramNum){
		if(canChangeInt(data) && countParam(data) == paramNum){
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 입력한 String 값이 int로 변경 가능한지 알아보는 메서드 
	 */
	private static boolean canChangeInt(String data){
		String sid = parseData(data)[0];
		
		try{
			int id = Integer.parseInt(sid);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	/*
	 * 입력한 String에 파라미터가 몇 개 들어왔는지 확인하는 메서드
	 */
	private static int countParam(String data){
		return data.split(" ").length;
	}
}
