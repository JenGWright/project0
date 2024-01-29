package org.example;
import org.example.Exception.CLIException;
import org.example.Exception.ContactException;
import org.example.View.CLIParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();
// create variable that will be used to stop the app
        boolean condition = true;
        while(condition){
            System.out.println("add / view / delete / stop");
            String input = sc.nextLine();
            try {
                String output = cliParser.parseCommandReturnOutput(input);
                System.out.println(output);
                if ("stop".equalsIgnoreCase(output)){
                    condition = false;
                }
            }catch(CLIException exception){
                System.out.println("Invalid entry, you must enter add, view, delete or stop");
                exception.printStackTrace();
            }catch(ContactException exception){
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }

        }
    }
}