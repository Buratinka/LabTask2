/**
 *
 * LabWork2
 *
 * @autor oleg.shved.shvets@gmail.com
 * @version 1.1
 *
 * */
package main;

import consoleHelper.ConsoleHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cheating {
    private String path;
    private ConsoleHelper consoleHelper;
    private BufferedReader reader;
    private static List<String> param = new ArrayList<>();
    private static List<String> funcOfRedirect = new ArrayList<>();
    private int count = 0;
    private static String[] word;
    private static String qCurrentState;
    private static String startState;
    private static String endState;
    private static String checkLetParam;
    private static String[] finalyState;
    private static boolean isMachin = false;
    private static StringBuilder wayOfWord = new StringBuilder();



    /**
     * path to file and parse to lists param or function to redirect
     *
     * */


    public void setPath()//String path)
    {
        this.path = "/home/oleg/test/test2Laba/Input1.txt";//path;
        if (path != null) {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            } catch (FileNotFoundException ex) {
                consoleHelper.writeErrorMessage("Error " + ex);
            }

            try {
                String sb;
                while ((sb = reader.readLine()) != null) {
                    if (count < 4) {
                        ++count;
                        param.add(sb);
                    } else {
                        funcOfRedirect.add(sb);
                    }

                }
            } catch (IOException ex) {
                consoleHelper.writeErrorMessage("Error" + ex.getMessage());
            }
            init();
        } else {
            consoleHelper.writeErrorMessage("Null path!");
        }

    }
    /**
     *
     * show full message that input word is belongs language of machine or not
     *
     * */
    public void getIsMachine() {
        if (isMachin == false) {
            wayOfWord.append("\nСлово не належить мові автомату.");
        } else {
            wayOfWord.append("\nСлово належить мові автомату.");
        }
        consoleHelper.writeMessage(wayOfWord.toString());
    }

    /**
     *
     * initializaton parametrs and call logic method  isMachine
     *
     * */
    public void init() {
        word = param.get(0).split("");
        finalyState = param.get(3).split(" ");
        qCurrentState = param.get(2);
        isMachine();
        writeFile(); 
    }

    /**
     *
     * main logic of LabWork2 parse functions of redirects and check input letters of word
     *
     * */

    public static boolean isMachine() {

        for (int i = 0; i < word.length; ++i) {

            for (String s : funcOfRedirect) {

                String[] splitFunOfRidirect = s.split(" ");

                startState = splitFunOfRidirect[0];

                checkLetParam = splitFunOfRidirect[1];

                endState = splitFunOfRidirect[2];

                if (word[i].equals(checkLetParam) && qCurrentState.equals(startState))
                {
                    wayOfWord.append(word[i] + " "+qCurrentState+"->"+endState+";\n");
                    qCurrentState = endState;

                    if (word[i] == word[word.length-1])
                    {
                        for (String checkFinalState : finalyState)
                        {
                            if (endState.equals(checkFinalState))
                            {
                                isMachin = true;
                                wayOfWord.append("\n" + qCurrentState + " is one of correct ends.\n");
                            }
                        }

                        if(isMachin == false)
                        {
                            wayOfWord.append("\n" + qCurrentState + " is not correct end.\n");
                        }

                    }


                }

            }
        }
        return isMachin;
    }

    public void writeFile()
    {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/oleg/test/test2Laba/Output1.txt"))))
        {
            writer.write(wayOfWord.toString());
        }
        catch (IOException ex)
        {
            consoleHelper.writeErrorMessage("Error : " + ex);
        }
    }

}
