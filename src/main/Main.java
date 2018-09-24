package main;
/**
 * LabWork2
 *
 * @autor oleg.shved.shvets@gmail.com
 * @version 1.1
 *
 * */
public class Main
{
    public static void main(String[] args) {
        Parser parser = new Parser("/home/oleg/test/test2Laba/Input1.txt","/home/oleg/test/test2Laba/Output1.txt");
        parser.readFile();
        parser.getIsMachine();
    }
}