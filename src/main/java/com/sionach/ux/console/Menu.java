package com.sionach.ux.console;


public class Menu {

    private int level;
    private int option;
    private String message;

    public Menu(int level, int option, String message){

        this.level = level;
        this.option = option;
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
