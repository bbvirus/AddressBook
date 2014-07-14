import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class InsertThread extends Thread{
	public int id;
	public String personalInfo;
	
	public InsertThread(int id, String personalInfo) {
		this.id = id;
		this.personalInfo = personalInfo;
	}

	public void run() {
		try {
			File file = new File(Constants.ADDRESS_BOOK_FILE_PATH);
			FileWriter fw;
			fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			synchronized (bw) {
				bw.write(this.id + " " + this.personalInfo);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
