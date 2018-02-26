package Assignment1;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Date: 2018-02-18
 * Unit: [1], Question:[5]
 * By: Woojin Park
 * To:Ms. Harris
 * Edits: Feb 23, 2018
 * Description: This program asks the user to guess a number between 1 and 10. If the number guess is equal
   to the number computer generated the player wins. Otherwise the player lose. The player can have infinite
   attempts to predict the number.
 **/
public class WoojinPU1A1Q5 extends JFrame {
    int randomNum, guess;//stores random number and the number user guess
    private JButton button;//Create a button
    private JTextField textfield;//a box where user can type
    private JLabel promptlabel;//Tell Enter number 1 to 10
    private JLabel resultlabel;//Tell win or lose
    private JLabel randomlabel;//Tell the number
    private ImageIcon numbers;//Store random integer image
    private JLabel pictureLabel;//Stores text
    private ArrayList<String> system = new ArrayList<>();//array where it stores the system's commands

    public WoojinPU1A1Q5() {
        setLayout(new FlowLayout());//set the layout

        //Get image of a Random number
        try {
            //get the image of a random number from the internet (help by JoonWoo)
            numbers = new ImageIcon(new URL("http://4.bp.blogspot.com/-lKd26TmUTmQ/VWMNfxZrfoI/AAAAAAAAAY0/hBxzOyl-nuQ/s1600/random-callerid-asterisk-vicidial-goautodial.png"), "Picture or random numbers");
        } catch (MalformedURLException e) {//catch exceptions
            e.printStackTrace();
        }

        //enables picture to show in the gui
        pictureLabel = new JLabel(numbers);
        add(pictureLabel);

        //add instructions into a array list of string
        system.add(0, "Enter number 1 to 10");
        system.add(1, "Guess!");

        promptlabel = new JLabel(system.get(0));//display instruction in index 0
        add(promptlabel);

        textfield = new JTextField(5);//A textfield where user can input
        add(textfield);

        //create button
        button = new JButton(system.get(1));//A button that user can press
        add(button);

        resultlabel = new JLabel("");//Tell the result
        add(resultlabel);

        randomlabel = new JLabel("");//Tell the result
        add(randomlabel);

        //make an event
        event action = new event();
        button.addActionListener(action);//run the program when click the button
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            randomNum = (int) (Math.random() * 10 + 1); //Create random integer
            try {
                //Check if the input is a integer(helped by Andy Bao)
                guess = (int) (Double.parseDouble(textfield.getText()));

                //Check if the number user guess is higher than 0 and less than 10
                if (guess < 0 || guess > 10)
                    throw new RuntimeException();//throw exception

                //check if guess is equal to random number generated
                if (guess == randomNum)
                    resultlabel.setText("You won the game!");//tell the user won the game
                else
                    resultlabel.setText("You lost the game!");//tell the user they lose the game

                randomlabel.setText("The random number was: " + randomNum);//show what the user get
            } catch (Exception ex) { //handle any bad input
                randomlabel.setText("Please enter numbers only!");//worn the user
            }
        }
    }

    public static void main(String[] args) {
        // (special) Create a new GUI //
        WoojinPU1A1Q5 gui = new WoojinPU1A1Q5();
        //exits the gui when close
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gui becomes visible
        gui.setVisible(true);
        // Set the size of the gui
        gui.setSize(1500, 350);
        //Set the title of the gui
        gui.setTitle("Random Number Guessing Game");

    }
}
