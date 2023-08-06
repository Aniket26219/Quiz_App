package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton again, quit;
    String name;
    public int score;

    Score(String name, int score){

        this.score = score;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 120, 500, 400);
        add(image);

        JLabel heading = new JLabel("Thank You "+name+".");
        heading.setBounds(300, 50, 500, 30);
        heading.setFont(new Font("Baskerville Old Face", Font.PLAIN, 26));
        add(heading);

        JLabel title = new JLabel("Congratulations");
        title.setBounds(530, 180, 200, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(title);

        JLabel lblscore = new JLabel("Your Score is "+score);
        lblscore.setBounds(530, 250, 400, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        again = new JButton("Start Again");
        again.setBounds(450, 400, 100, 40);
        again.setForeground(Color.WHITE);
        again.setBackground(new Color(30, 144, 254));
        again.addActionListener(this);
        add(again);

        quit = new JButton("Quit");
        quit.setBounds(680, 400, 100, 40);
        quit.setForeground(Color.WHITE);
        quit.setBackground(new Color(30, 144, 254));
        quit.addActionListener(this);
        add(quit);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setBounds(300, 100, 800, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == again) {
            setVisible(false);
            new Login();
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Score("User",0);
    }
}
