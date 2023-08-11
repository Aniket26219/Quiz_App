package quizapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JTextField tfname;

    Login(){


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,500,500);
        add(image);

        JLabel heading = new JLabel("Welcome To The Quiz");
        heading.setBounds(670, 60, 500, 50);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,35));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel name = new JLabel("Enter your name :");
        name.setBounds(770, 200, 500, 30);
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setForeground(Color.black);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(750, 250, 200, 30);
        tfname.setFont(new Font("Times New roman", Font.BOLD, 20));
        add(tfname);

        JButton next = new JButton("Next");
        next.setBounds(1030, 400, 90, 40);
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(30, 144, 254));
        next.addActionListener(this);
        add(next);

        JButton back = new JButton("Back");
        back.setBounds(600, 400, 90, 40);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30, 144, 254));
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });        add(back);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setVisible(true);
        setSize(1200,500);
        setLocation(100,150);
    }

    public void actionPerformed(ActionEvent ae) {

            String name = tfname.getText();
            setVisible(false);
            new Next(name);
    }

    public static void main(String[] args) {

        new Login();
    }


}