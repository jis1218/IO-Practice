import java.util.Scanner;

public class IOMain {
	
	public static void main(String args[]){
		IoPrac prac = new IoPrac();
		Scanner sc = new Scanner(System.in);
		String input = "";

		
		while(!input.equals("exit")){
			
			System.out.println("���ڸ� �Է��Ͻÿ� : ");
			input = sc.nextLine();
			
		switch(input){	
		
		case "c":
			prac.create();
			break;
			
		case "l" :
			prac.load();
			break;
			
		}	
		}
	}
}
