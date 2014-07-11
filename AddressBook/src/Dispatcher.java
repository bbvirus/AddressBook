import java.util.Scanner;


public class Dispatcher {
	
	public String message = "입력은 insert, 검색은 search, 주소록 전체 출력은 load,\n"
							+ "10만 건 입력 테스트는 test-insert, 10만 건 검색 테스트는 test-search,\n"
							+ "프로그램을 종료하려면 exit을 입력하세요.";
	
	public Dispatcher() {
		System.out.println(message);
	}
	
	@SuppressWarnings("resource")
	public void listen(AddressBookManager addressBookManager, TestClass testClass) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.next();
			
			switch(userInput) {
				case "insert" : addressBookManager.inputForInsert(); break;
				case "search" : addressBookManager.inputForFindOne(); break;
				case "load" : addressBookManager.findAll(); break;
				case "test-insert" : testClass.testInsert(addressBookManager); break;
				case "test-search" : testClass.testSearch(addressBookManager); break;
				case "exit" : System.out.println("바이바이~"); System.exit(1);
			}
			
			System.out.println(message);
		}
	}

}
