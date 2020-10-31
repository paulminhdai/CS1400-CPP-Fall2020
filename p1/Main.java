/*
who: Dai Vuong (Paul)
what: CS1400.02
when: Oct 4th, 2020
why: Project 1 - Encryption/Decryption Utility
*/

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class Main {

    private static char userOption () {
        String welcome = "Welcome to My Encryption/Decription Program\n";
        String prompt = "Please enter the letter of your chosen operation:\n\ta) Encrypt a message\n\tb) Decrypt a message\n\tc) Exit\n";
        String prompt1 = "Enter option: ";
        String invalid = "Invalid choice, please try again\n\n";

        Scanner kb = new Scanner(System.in);
        System.out.println(welcome + prompt);
        String enter;
        char option;

        do {

            System.out.print(prompt1);
            enter = kb.nextLine();
            option = enter.toLowerCase().charAt(0);
            if (option!='a' && option!='b' && option!='c')
                System.out.println(invalid + prompt);

        }
        while (option!='a' && option!='b' && option!='c');

        return option;
    };

    // Encrypt method
    private static void encrypt() throws IOException {

        String enter_msg = "Input your message: ";
        String enterFile = "Enter filename: ";
        String fileExists = "File already exists.\n";

        Scanner kb = new Scanner(System.in); // creat kb object from Scanner

        System.out.print(enter_msg); //display prompt enter message
        String message = kb.nextLine(); // msg hold the message

        FileWriter file = null;

        try {
            System.out.print(enterFile); // prompt
            file = new FileWriter(kb.next()); // open file

            /*if (!file.createNewFile()) {  // check existing file
                System.out.print(fileExists + enterFile);
                file = new File(kb.next());
            }*/
        } 
        catch (Exception e) {
            System.out.println("An error occurred.");
        }

        String password = password();

        String ciphertext = "0x"; // encrypted string
        char message_char, password_char; // char variables hold each character of message, password and create cipher
        int cipher_int; 
        
        // Go over the message char by char
        int pw_count = 0;
        for(int i=0; i<message.length(); i++){
            message_char = message.charAt(i);
            password_char = password.charAt(pw_count);

            cipher_int = message_char ^ password_char; // XOR Operation

            ciphertext += String.format("%02x", cipher_int);
            //ciphertext += Integer.toHexString(cipher_int);

            pw_count++;
            if (pw_count >= password.length()) // start password over
                pw_count = 0;
        }

        // Print the encryped string to the file
        PrintWriter printFile = new PrintWriter(file);
        printFile.print(ciphertext);
        System.out.println("Encrypted Text: " + ciphertext);

        System.out.println("Successfully encrypted.\n\n");

        printFile.close();

    };


    private static void decrypt() throws IOException{
        String enterFile = "Enter filename: ";
        String noFile = "That file doesn't exist, Please enter the correct filename or press ctr-c to exit.\n";
        
        Scanner kb = new Scanner(System.in);

        System.out.print(enterFile);
        //String filename = kb.next();
        File file = new File(kb.next());

        while (!file.exists()) {
            System.out.print(noFile + enterFile);
            file = new File(kb.next());
        }

        String password = password();

        // Read from the file
        Scanner inputFile = new Scanner(file);
        String ciphertext = inputFile.nextLine();
        //ciphertext = "0x160a0b11420b114203420e0b0c07";
        char two_cipher_digit;
        String message = "";
        char password_char, cipher_char;
        int plaintext_int;
        int pw_count = 0;

        for (int i=2; i<ciphertext.length()-1; i+=2) {
            String two_digit = ciphertext.substring(i, (i+2));
            two_cipher_digit = (char)Integer.parseInt(two_digit,16);

            plaintext_int = two_cipher_digit ^ password.charAt(pw_count);

            message += (char)plaintext_int;

            pw_count++;
            if (pw_count >= password.length()) // start password over
                pw_count = 0;

        }

        System.out.println("The message is: " + message);
        System.out.println("Successfully decrypted.\n\n");

        

    };  
 


    private static String password() {
        Scanner kb = new Scanner(System.in);

        String prompt = "Input password (must be greater than 8 characters): ";
        String invalid = "Invalid password length. Please try again or press ctrl->c to quit.\n";

        System.out.print(prompt);
        String pw = kb.nextLine();
        while (pw.length() <= 8) {
            System.out.print(invalid + prompt);
            pw = kb.nextLine();
        }
 
       return pw;
    }


    public static void main(String[] args) throws IOException{
        switch(userOption()) {
            case 'a':
                encrypt();
                break;
            case 'b':
                decrypt();
                break;
            case 'c':
                System.exit(0);
        }
        
    }
}

