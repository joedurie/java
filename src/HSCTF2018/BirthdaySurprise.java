package HSCTF2018;
import java.util.Scanner;
public class BirthdaySurprise
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        System.out.print("What is the Address?");
        String shuffled = key.nextLine();
        String answer = shuffle4("!0&#81%$7##&439",(shuffle3(shuffle2(shuffle1(shuffled)))));
        if (answer.length() < 15)
        {
            System.out.println("WRONG!");
        }
        else if (answer.equals("ertskzgmlpdkqyw"))
        {
            System.out.println("The Flag is: " + shuffled);
        }   
        else
        {
            System.out.println("WRONG!");
        }
    }

    public static int[] shuffle1(String word)
    {
        char[] temp = word.toCharArray();
        int[] num = new int[word.length()];
        for (int i = 0; i < word.length(); i++) 
        {
            num[i] = temp[i]-'0';
        }
        return num;
    }

    public static int[] shuffle2(int[] add)
    {
        for(int i = 0; i < add.length / 2; i++)
        {
            int temp = add[i];
            add[i] = add[add.length - i - 1];
            add[add.length - i - 1] = temp;
        }
        return add;
    }

    public static int[] shuffle3(int[] add)
    {
        int[] amend = {66,62,9,17,44,12,58,7,98,27,5,62,14,63,59};
        int[] temp = new int[15];
        for(int i = add.length - 1; i >= 0; i--)
        {
            if(amend[i] % 2 == 1)
            {
                temp[i] = add[i] + amend[i];
            }
            else
            {
                temp[i] = add[i];
            }
        }
        return temp;
    }

    public static String shuffle4(String f, int[] add)
    {
        char[] word = new char[15];
        for (int i = add.length - 1; i >= 0; i--)
        {
            word[i] = (char)(add[i] + f.charAt(i)); 
        }
        String b = new String(word);
        return b;
    }
}