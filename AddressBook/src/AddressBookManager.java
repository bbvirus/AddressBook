import java.util.HashMap;
import java.util.Scanner;


public class AddressBookManager {
	HashMap<Integer, String> addressBook;
	
	public AddressBookManager() {
		addressBook = new HashMap<Integer, String>();
		
		loadWholeAddressBookDataInMemory();
	}
	
	private void loadWholeAddressBookDataInMemory() {
		
		
	}

	@SuppressWarnings("resource")
	public void inputForInsert() {
		
		Scanner scanner = new Scanner(System.in);
		String data = scanner.next();
		String[] buffer = Util.parseData(data);
		
		int id = Integer.parseInt(buffer[0]);
		String personalInfo = buffer[1];
		
		insert(id, personalInfo);
	}
	
	public void insert(int id, String personalInfo) {
		this.addressBook.put(id, personalInfo);
	}

	public void inputForFindOne() {
		
	}

	public void findOne(int id) {
		
	}
	
	public void findAll() {
		// TODO Auto-generated method stub
		
	}
}
