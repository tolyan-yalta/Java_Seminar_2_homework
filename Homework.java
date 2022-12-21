import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args)
    {
        Homework task = new Homework();
        task.Equation();
    }


    public static int GetNumber(String value)
    {
        Scanner numberS = new Scanner(System.in);
        int number;
        while(true)
        {
            try
            {
                System.out.printf("Введите число %s --> ", value);
                number = numberS.nextInt();
                break;
            } catch(Exception e)
            {
                System.out.print("Ошибка ввода");
            }
        }
        return number;
    }
    public static String GetString()
    {
        Scanner str = new Scanner(System.in);
        System.out.print("Введите формулу --> ");
        String equation = str.nextLine();
        return equation;
    }

    public static void Equation(){
        Map<String, Integer> states = new HashMap<String, Integer>();
        Scanner str = new Scanner((System.in));
        // a + b + c + d + c
        String equation = GetString();
        equation = String.format(equation).replace(" ","");
        //System.out.println(equation);
        String[] st1 = equation.split("\\+");
        int sum = 0;
        states.put(st1[0], GetNumber(st1[0]));
        for (int i = 1; i < st1.length; i++) {
            for (Map.Entry<String, Integer> item : states.entrySet()){
                if (!states.containsKey(st1[i])) {
                    states.put(st1[i], GetNumber(st1[i]));
                    break;
                }
            }
        }
        String temp;
        for (int i = 0; i < st1.length; i++) {
            temp = st1[i];
            sum += states.get(temp);
        }
        System.out.print("Сумма = " + sum);
    }
}
