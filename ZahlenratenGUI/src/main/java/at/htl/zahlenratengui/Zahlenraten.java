package at.htl.zahlenratengui;
import java.util.Random;

public class Zahlenraten {
    private Random random = new Random();
    private int _number;
    private int _versuche;
    private String output;
    private int max_versuche;

    public Zahlenraten() {
        _number = random.nextInt(0,100);
        _versuche = 0;
        IO.println(_number);
    }
    public void NewNumber(int upper, int lower){
        _number = random.nextInt(lower, upper);
        IO.println(_number);
    }
    public int Guess(int guess){
        _versuche ++;

        if(guess == _number){
            output = Guessed();
            return 0;
        }
        if(guess > _number){
            output = "Falsch die Zahl ist kleiner als: " + guess;
            return -1;
            //IO.println("Falsch, die Zahl ist kleiner als: " + guess);
        }
        if(guess < _number){
            output = "Falsch die Zahl ist größer als: " + guess;
            return 1;
            //IO.println("Falsch, die Zahl ist groesser als: " + guess);
        }
        return 2;
    }
    private String Guessed(){
        String output = "";
        output += "Die Nummer war ";
        output += _number;
        output += "\n";

        output += "Gebrauchte versuche: " + _versuche;

        return output;
    }
    public String GetOutput(){
        return output;
    }

}

