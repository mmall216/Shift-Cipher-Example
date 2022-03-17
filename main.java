
import java.util.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

public static void main(String[] args) throws IOException {
char alphabet []= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

String originalText =null;
Scanner userInput = new Scanner(System.in);


String plainText = "";
System.out.println("Enter your name: ");
String name = userInput.next();
System.out.println("Hello "+ name + ". Welcome!");

System.out.println("Enter a String to Begin Encyption. Enter (-1 to quit)");
plainText = userInput.next();
Encryption userEncryption = new Encryption();

if(!plainText.equals("-1")){
System.out.println(" ");
System.out.println("Encypted Message: " + userEncryption.runEncryption(plainText.toLowerCase()));
System.out.println(" ");
System.out.println("Generated Key:     ");
for (int i=0; i<alphabet.length;i++) {
System.out.println(alphabet[i]+ "=" + userEncryption.getKey().toCharArray()[i]);
}

}

else if (plainText.equals("-1")) {
System.out.println("You Have Successfully Exited the Program.");
}

System.out.println("-------------------------------------------------------------------------");
System.out.println(" ");
System.out.println("Welcome Bob! The following is a secure message of the Key Table:");
System.out.println("Secure Message");
System.out.println("Key Table for Key K:");
for (int i=0; i<alphabet.length;i++) {
System.out.println(alphabet[i]+ "=" + userEncryption.getKey().toCharArray()[i]);
}
System.out.println(" ");
System.out.println("If you would like to automatically decrypt the text, enter 1, otherwise enter any other number");
int usercipherText1 = userInput.nextInt();
if(usercipherText1 == 1){
System.out.println("Enter the text you would like to decrypt using Key K:");
String usercipherText = userInput.next();
System.out.println("Decrypting...");
System.out.println(" ");
System.out.println(userEncryption.runDecryption(usercipherText));
System.out.println(" ");
}

else {
System.out.println("Exiting Bob's View");
System.out.println("-------------------------------------------------------------------------");
System.out.print("Eve's View: ");
userEncryption.runEve();
userEncryption.runVariance();
}

    }
}