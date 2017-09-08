import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IoPrac {
	
	private final String DB_DIR = "D:/java-neon/eclipse/java";
	private final String DB_FILE = "memo2.txt";
	private File database = null;
	Memo memo;
	Scanner sc = new Scanner(System.in);
	private final String SEPARATOR = ",";
	
	public IoPrac(){
		
		
		
		//경로가 없을 경우를 대비해 굳이 File 클래스를 만들어 경로 만들어주는 소스를 씀
		File dir = new File(DB_DIR); //파일이나 경로 지정해주는 클래스
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		//파일이 없을 경우를 대비해
		File file = new File(DB_DIR + "/" + DB_FILE);
		database = file;
		if(!file.exists()){
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	public void create(){
		
		memo = new Memo();
		System.out.println("번호를 입력하세요 : ");
		memo.num = sc.nextLine();
		System.out.println("이름을 입력하세요 : ");
		memo.name = sc.nextLine();
		
		
		String mess = memo.num + SEPARATOR + memo.name + SEPARATOR + "\r\n";
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(database, true);
			//An OutputStreamWriter is a bridge from character streams to byte streams
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			//Writes text to a character-output stream, buffering characters 
			//so as to provide for the efficient writing of single characters, arrays, and strings.
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.append(mess);
			
			bw.flush();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void load(){
		//메모리(ArrayList 등)에 저장하는 것이 아닌 파일(메모장)에 저장하는 것이므로 ArrayList가 필요없다. 하지만 필요할 듯
		ArrayList<Memo> list = new ArrayList<>();
		
		
		try {
			
			//A FileInputStream obtains input bytes from a file in a file system
			FileInputStream fis = new FileInputStream(database);
			
			//An InputStreamReader is a bridge from byte streams to character streams: 
			//It reads bytes and decodes them into characters using a specified charset.
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			BufferedReader br = new BufferedReader(isr);
			
			
			
			System.out.println("gggg");
			String oneLine ;
			
			while((oneLine=br.readLine())!=null){
				
				memo = new Memo();
				
				String[] row = oneLine.split(SEPARATOR);
				
				memo.num = row[0];
				memo.name = row[1];
				
				list.add(memo);	
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Memo memo : list){
			System.out.println("번호는 : " + memo.num);
			System.out.println("이름은 : " + memo.name);
		}
		
		
	}
}
