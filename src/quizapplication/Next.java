package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Next extends JFrame implements ActionListener{

    JButton back, start;
    String name;

    Next(String name){

        this.name = name;
        JLabel heading = new JLabel("Welcome "+name+" to the Quiz.");
        heading.setBounds(80, 50, 600, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(50, 130, 600, 400);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rules.setText(
                "<html>"+
                        "1. Read all the following instructions properly. Keep your Admit card with you." + "<br><br>"+
                        "2. You should not use mobile phones while attending the quiz." + "<br><br>"+
                        "3. Here all the questions are compulsory." + "<br><br>"+
                        "4. Each quesion have a time limit, if you are not submitting it within the it will move to the next question." + "<br><br>"+
                        "5. Any kind of malpractice will be not be encouraged. And you will be disqualified." + "<br><br>"+
                        "6. All the best for your competition, Good Luck!!!" + "<br><br>"+
                        "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(50, 570, 100, 40);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(580, 570, 100, 40);
        start.setForeground(Color.WHITE);
        start.setBackground(new Color(30, 144, 254));
        start.addActionListener(this);
        add(start);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setVisible(true);
        setSize(750,700);
        setLocation(300,50);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }
        else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new Next("User");
    }

}