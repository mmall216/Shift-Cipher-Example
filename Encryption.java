
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Encryption {

char alphabet []= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char key[] =      {'d','c','b','a','g','f','e','k','j','i','h','n','m','l','q','p','o','t','s','r','v','u','z','y','x','w'};
char alphabet1 []= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
String manualKey;

Scanner userInput = new Scanner(System.in);

public Encryption() {

}

public String getAlphabet() {
String alpha = new String (alphabet);
return alpha;
}

public String getKey() {
String k = new String (key);
return k;
}

public String runEncryption(String plainText) {
System.out.println("Type 1 to Manually Enter a Key: ");
System.out.println("Type 2 to Use Preloaded Key: ");
int choice = userInput.nextInt();

if (choice == 1) {
System.out.println(" ");
System.out.println("Manual Key Generation");
System.out.println("Enter the Key letter for: ");
System.out.println(new String (alphabet));
manualKey= userInput.next().toLowerCase();

key = manualKey.toString().toCharArray();
System.out.println("Manual Key Generation: ");
for (int i=0; i<key.length;i++) {
System.out.println(alphabet[i]+ "=" + key[i]);
}
}

else if (choice == 2) {
System.out.println(" ");
System.out.println("Preloaded key Generation");
}


else {
System.out.println("Enter Either 1 or 2 for Choice!");
runEncryption(plainText);
}


char cipherText [] = new char [(plainText.length())];
for (int i=0; i<plainText.length();i++) {
for(int j=0; j < 26;j++) {
if(alphabet[j] == plainText.charAt(i)) {
cipherText[i] = key[j];
break;
}
}
} return (new String (cipherText));

}


public String runDecryption(String cipherText) {
char plainText [] = new  char [(cipherText.length())];
for (int m=0; m < cipherText.length(); m++) {
for (int i = 0; i <26; i++) {
if (key[i] == cipherText.charAt(m)){
plainText[m] = alphabet [i];
}
}
} return (new String (plainText));
}


public void runEve() throws IOException {

File encryptFile = new File ("corpus.txt");
Scanner scanFile = new Scanner (encryptFile);

File encryptedFile = new File("output.txt");
FileWriter fileWriter = new FileWriter(encryptedFile, true);
PrintWriter printWriter = new PrintWriter(fileWriter);
Scanner scanningFile = new Scanner (encryptedFile);

while(scanFile.hasNextLine()) {
String input = scanFile.nextLine();
String currentLine = new String();

for (Character i: input.toLowerCase().toCharArray()) {
Boolean characterExists = false;
int indexofEncryption = 0;
for (int m=0; m <alphabet.length; m++) {
if (i == alphabet[m]) {
indexofEncryption = m;
characterExists = true;
}
}

if (characterExists) {
currentLine = currentLine + key[indexofEncryption];
}
else {
currentLine= currentLine + i;
}

} printWriter.println(currentLine);
}
fileWriter.close();
printWriter.close();

}


public void runVariance() throws IOException{
	File fileIn = new File ("output.txt");
	Scanner scanFile = new Scanner (fileIn);
	
	double letterFrequency[] = new double[26];
	double totalofLetter = 0;
	//original hashmap going through the count of the letters.
	HashMap<Character, Double> charMap = new HashMap<Character, Double>();
	//hashmap designed to get freqencies.
	HashMap<Character, Double> charMapped = new HashMap<Character,Double>();
	
	//going through
	while (scanFile.hasNextLine()) {
		String currentLine = scanFile.nextLine();
		currentLine = currentLine.replaceAll(" ", "");
		int size = currentLine.length();
		char[] strArray = currentLine.toCharArray();
		boolean foundChar = false;
		
		for (char c : strArray) {
			if (charMap.containsKey(c)) {
		    charMap.put(c, charMap.get(c) + 1.0);
		    } 
			else {
		    charMap.put(c, 1.0);
		    }             
		}

		for (int i=0;i<size;i++) {
			for (int j=0; j<alphabet.length;j++) {
				if (!(currentLine.charAt(i) == alphabet [j])) {
					foundChar = false;
				}
				else {
					foundChar = true;
					totalofLetter++;
				}	
		
		for (char c : strArray) {
			for (int p=0;p<alphabet.length;p++) {
			if (charMap.containsKey(c)){
				charMapped.put(c, charMap.get(c)/totalofLetter);
			}
			 else {
		         charMapped.put(c, 1.0);
			}
		}
	}

	}
	}
}
	System.out.println(" ");
	System.out.println("Occurence: " + charMap);
	System.out.println("Frequency: " + charMapped);
	System.out.println(" ");
	System.out.println("Total Letter Count: " + totalofLetter);
	System.out.println(" ");


}


}
