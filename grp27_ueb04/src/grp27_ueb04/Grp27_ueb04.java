/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp27_ueb04;

import java.util.Arrays;

/**
 *
 * @author Robin
 */
public class Grp27_ueb04 {

    /**
     * definition of delimiter
     */
    public static final String trennzeichen = "/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set menge1 = new Set();
        Set menge2 = new Set();
        getSetsFromArgs(menge1, menge2, args);
        testClassSet(menge1, menge2);

    }

    public static void getSetsFromArgs(Set menge1, Set menge2, String[] args) {
        boolean passedDelimiter = false;
        for (String arg : args) {
            if (arg.equals(trennzeichen)) {
                passedDelimiter = true;
            } else {
                if (passedDelimiter == false) {
                    menge1.insertElement(Integer.valueOf(arg));
                } else {
                    menge2.insertElement(Integer.valueOf(arg));
                }
            }
        }
    }

    public static void testClassSet(Set menge1, Set menge2){
        System.out.println(menge1.union(menge2).showValues());
        System.out.println(menge1.intersection(menge2).showValues());
        System.out.println(menge1.diff(menge2).showValues());
        System.out.println(menge1.isSame(menge2));
        System.out.println(menge1.isProperSubSet(menge2));
    }
}
