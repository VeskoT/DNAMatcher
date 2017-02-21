import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SequenceMatcher{

	public static String Matches(String pattern, String sequence) {
		if(sequence.matches(pattern)){
			return "There is a match!";
		}
		else{
			return "There is no match.";
		}
	}

	public static boolean ifCharAtIndexIs(String sequence, int i, char c) {
		return sequence.charAt(i) == c;
	}

	public static void writeToFile(String file, String line) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(line);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
