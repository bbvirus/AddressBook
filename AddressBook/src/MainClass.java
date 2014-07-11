
public class MainClass {

	public static void main(String[] args) {
		AddressBookManager addressBookManager = new AddressBookManager();
		Dispatcher dispatcher = new Dispatcher();
		TestClass testClass = new TestClass();
		dispatcher.listen(addressBookManager, testClass);
	}
	
	//TODO: 예외 처리와 유효성 검사
	//TODO: 멀티 스레드 처리
}
