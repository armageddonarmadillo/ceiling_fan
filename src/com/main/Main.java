package com.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Window(new Look());

        String instructions = "*********************************\nYou are looking at a ceiling fan.\nEnter 1 to pull the first chord which adjusts fan speed.\nEnter 2 to pull the second chord which reverses fan speed.\nEnter 0 to stop looking at the ceiling fan.\n*********************************";
        System.out.println(instructions);
        int speed = 0;
        boolean cw = true, loop = true;

        while(loop){
            System.out.println("The ceiling fan is currently " + (speed > 0 ? "spinning " + (cw ? " clockwise " : " counter-clockwise " ) + " at speed level " + speed: "stopped."));

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            int val;
            try { val = Integer.parseInt(input); } catch (NumberFormatException e) { val = 999; }
            switch(val) {
                case 0:     loop = false;                                                                       break;
                case 1:     speed = ++speed % 4;                                                                break;
                case 2:     cw = !cw;                                                                           break;
                default:    System.out.println("Couldn't read your input, please try again!\n" + instructions); break;
            }
        }
    }
}