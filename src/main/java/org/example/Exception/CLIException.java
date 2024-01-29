package org.example.Exception;

//Exception that is thrown if the user enters an invalid command

public class CLIException extends Exception{

    public CLIException(String message){
        super(message);
    }
}
