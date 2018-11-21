package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        EmailMessage e1 = new EmailMessage("mail123@gmail.com", new LinkedList<String>(Arrays.asList("oop@gmail.com", "test@interia.pl", "badmail@zlymail")));
        e1.SendMail();
    }
}
