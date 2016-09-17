package com.sionach.ux.color;

/**
 * Created by Alice on 17.09.2016.
 */
public class DemoClass {

    public static void main(String[] args) {
        namesHexTable newTable = new namesHexTable("Black","000000");
        String string1=newTable.getColorName();
        String string2=newTable.getColorHex();
        System.out.println(string1 + " and " + string2 + " are the same colors");
        newTable.setColorName("White");
        newTable.setColorHex("ffffff");
        System.out.println(newTable.getColorName() + " and " + newTable.getColorHex() + " are the same colors too");
        String string3 = "violet 902090";
        System.out.println(string3);
        newTable.method1(string3);
        System.out.println(newTable.getColorName() + " and " + newTable.getColorHex() + " are the same colors too");
    }

}
