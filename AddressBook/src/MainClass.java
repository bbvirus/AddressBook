
public class MainClass {

	public static void main(String[] args) {
		AddressBookManager addressBookManager = new AddressBookManager();
		Dispatcher dispatcher = new Dispatcher();
		TestClass testClass = new TestClass();
		dispatcher.listen(addressBookManager, testClass);
	}
}
