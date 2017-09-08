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
		
		
		
		//��ΰ� ���� ��츦 ����� ���� File Ŭ������ ����� ��� ������ִ� �ҽ��� ��
		File dir = new File(DB_DIR); //�����̳� ��� �������ִ� Ŭ����
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		//������ ���� ��츦 �����
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
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		memo.num = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ��� : ");
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
		//�޸�(ArrayList ��)�� �����ϴ� ���� �ƴ� ����(�޸���)�� �����ϴ� ���̹Ƿ� ArrayList�� �ʿ����. ������ �ʿ��� ��
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
			System.out.println("��ȣ�� : " + memo.num);
			System.out.println("�̸��� : " + memo.name);
		}
		
		
	}
}
