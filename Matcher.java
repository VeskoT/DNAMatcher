import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Matcher extends SequenceMatcher {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		String originalSequence;
		String potentialMutant;
		String finalString;
		StringBuilder sb = new StringBuilder();
		
		originalSequence = br.readLine();
		potentialMutant = br.readLine();
		for(int i = 0; i < originalSequence.length(); i++){
			if(Character.isUpperCase(originalSequence.charAt(i))){
				sb.append(originalSequence.charAt(i));
			}
		}
		finalString = sb.toString();
		Matches(finalString, potentialMutant);
		if(potentialMutant.matches(finalString)){
			System.out.println("There is a match!");
		}
		else{
			System.out.println("There is no match.");
		}
		
		int j = 0;
		int k = 0;
		int matches = 0;
		int counter = 0;
		int previous;
		while(j < finalString.length() && k < potentialMutant.length()){
			if(finalString.charAt(j) == potentialMutant.charAt(k)){
				j++;
				k++;
				matches++;
				if(matches == 10){
					int startIndex = k;
					while(j < finalString.length() && k < potentialMutant.length()){
						if(finalString.charAt(j) == potentialMutant.charAt(k)){
							j++;
							k++;
							continue;
						}
						else if((ifCharAtIndexIs(potentialMutant, k, 'A') || ifCharAtIndexIs(potentialMutant, k, 'T')
					     || ifCharAtIndexIs(potentialMutant, k, 'C') || ifCharAtIndexIs(potentialMutant, k, 'G'))){
							counter++;
							System.out.println(k + " " + potentialMutant.charAt(k));
							j++;
							k++;
							continue;
						}
						else{
							System.out.println(k + " " + potentialMutant.charAt(k));
							j++;
							k++;
						}
					}
					String template = finalString.substring(10, finalString.length());
					String splicedSequence = potentialMutant.substring(startIndex, k);
					bw.write(template);
					bw.newLine();
					bw.write(splicedSequence);
					bw.close();
					break;
				}
			}
			else{
				j = 0;
				matches = 0;
				k++;
			}
			
			if(j == finalString.length() && finalString.charAt(j) == potentialMutant.charAt(k)){
				System.out.println("There is a match!");
				break;
			}
		}
		System.out.println("Counter is : " + counter);
		br.close();
	}

}


