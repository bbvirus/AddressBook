
public class MainClass {

	public static void main(String[] args) {
		AddressBookInMemory addressBook = new AddressBookInMemory();
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.listen();
	}

}
