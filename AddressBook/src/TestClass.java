import java.util.Random;


public class TestClass {
	
	public void testInsert(AddressBookManager addressBookManager) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			addressBookManager.insert(i, "세훈민주 123123");
		}
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("10만 건 자료 입력에 " + totalTime + "ms 걸렸습니다.");
	}

	public void testSearch(AddressBookManager addressBookManager) {
		Random rand = new Random();
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			int someId = rand.nextInt(100000);
			addressBookManager.findOne(someId);
		}
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("10만 건 자료 검색에 " + totalTime + "ms 걸렸습니다.");
	}


}
