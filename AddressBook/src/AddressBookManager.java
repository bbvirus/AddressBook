import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	/*
	 * storage.txt에 저장돼 있는 주소록 정보들을 모두 읽어서 addressBook에 저장하는 메서드
	 */
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
		System.out.println("민번(숫자) 이름 전화번호 형식으로 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		String[] buffer = Util.parseData(data);
		
		int id = Integer.parseInt(buffer[0]);
		String personalInfo = buffer[1];
		
		insert(id, personalInfo);
	}
	
	/*
	 * 사용자로부터 입력 받은 데이터를 파일과 메모리에 저장하는 메서드
	 */
	@SuppressWarnings("resource")
	public void insert(int id, String personalInfo) {
		// 파일에 저장하는 부분
		try {
			File file = new File(Constants.ADDRESS_BOOK_FILE_PATH);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(id + " " + personalInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 메모리에 저장하는 부분
		this.addressBook.put(id, personalInfo);
	}

	/*
	 * 검색을 위해 사용자로부터 검색어 입력을 받는 메서드
	 */
	@SuppressWarnings("resource")
	public void inputForFindOne() {
		System.out.println("검색할 민번을 입력해주세요(숫자).");
		Scanner scanner = new Scanner(System.in);
		int id = Integer.parseInt(scanner.next());
		findOne(id);
	}

	/*
	 * 사용자로부터 입력 받은 검색어로 데이터를 검색해 출력해주는 메서드
	 */
	public void findOne(int id) {
		System.out.println(id + " " + this.addressBook.get(id));
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
