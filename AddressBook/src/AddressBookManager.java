import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class AddressBookManager {
	HashMap<Integer, String> addressBook;
	
	/*
	 * AddressManager를 생성할 때 파일에 저장된 주소록의 데이터를 읽어와 메모리에 저장해둔다.
	 */
	public AddressBookManager() {
		addressBook = new HashMap<Integer, String>();
		
		loadWholeAddressBookDataInMemory();
	}
	
	private void loadWholeAddressBookDataInMemory() {
		try {
			File file = new File(Constants.ADDRESS_BOOK_FILE_PATH);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String data;
			
			try {
				while((data = br.readLine()) != null) {
					String[] buffer = Util.parseData(data);
					int id = Integer.parseInt(buffer[0]);
					String personalInfo = buffer[1];
					this.addressBook.put(id, personalInfo);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 주소록 저장을 위해 사용자로부터 입력을 받는 메서드
	 */
	@SuppressWarnings("resource")
	public void inputForInsert() {
		
		Scanner scanner = new Scanner(System.in);
		String data = scanner.next();
		String[] buffer = Util.parseData(data);
		
		int id = Integer.parseInt(buffer[0]);
		String personalInfo = buffer[1];
		
		insert(id, personalInfo);
	}
	
	/*
	 * 사용자로부터 입력 받은 데이터를 파일과 메모리에 저장하는 메서드
	 */
	public void insert(int id, String personalInfo) {
		this.addressBook.put(id, personalInfo);
	}

	/*
	 * 검색을 위해 사용자로부터 검색어 입력을 받는 메서드
	 */
	public void inputForFindOne() {
		
	}

	/*
	 * 사용자로부터 입력 받은 검색어로 데이터를 검색해 출력해주는 메서드
	 */
	public void findOne(int id) {
		
	}
	
	
	/*
	 * 현재 저장돼 있는 전체 주소록을 출력하는 메서드
	 */
	public void findAll() {
		Set<Integer> keySet = this.addressBook.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			int key = iterator.next();
			System.out.println(key + " " + this.addressBook.get(key));
		}
		
	}
}
