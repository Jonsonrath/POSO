package at.htl;

import java.util.Random;

public class Zahlenraten {
    private Random random = new Random();
    private int _number;
    private int _versuche;


    public Zahlenraten() {
        _number = random.nextInt(0,100);
        _versuche = 0;
    }
    public int Guess(int guess){
        _versuche ++;
        String output = "";
        if(guess == _number){
            output = Guessed();
            return 0;
        }
        if(guess < _versuche){
            output = "Falsch die Zahl ist kleiner als: " + guess;
            return -1;
            //IO.println("Falsch, die Zahl ist kleiner als: " + guess);
        }
        if(guess > _versuche){
            output = "Falsch die Zahl ist größer als: " + guess;
            return 1;
            //IO.println("Falsch, die Zahl ist groesser als: " + guess);
        }
        return 2;
    }
    private String Guessed(){
        String output = "";
        output += "Die Nummer war";
        output += _number;
        output += "\n";

        output += "Gebrauchte versuche: " + _versuche;

        return output;
    }
}
