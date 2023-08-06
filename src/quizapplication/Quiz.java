package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];   // For question and options
    String answers[][] = new String[10][2];     // Answers array
    String useranswers[][] = new String[10][1]; // To store the option selected by user
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupbutton;
    JButton next, submit;
    JLabel qno, question;
    String name;

    public static int count = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;

    Quiz(String name){

        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz_1.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1200,250);
        add(image);

        qno = new JLabel();
        qno.setBounds(80, 300, 35, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(130, 300, 1200, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Who is the father of C language ? ";
        questions[0][1] = "Steve Jobs";
        questions[0][2] = "James Gosling";
        questions[0][3] = "Dennis Ritchie";
        questions[0][4] = "Charles Babbage";

        questions[1][0] = "Which of the following cannot be variable name in C ?";
        questions[1][1] = "int";
        questions[1][2] = "export";
        questions[1][3] = "friend";
        questions[1][4] = "1010";

        questions[2][0] = "Which package contains the Random Class ?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as ?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator ?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random Storage Space";
        questions[4][4] = "Heap Memory";

        questions[5][0] = "Which of the following is used to prevent any changes in variable within a C program ?";
        questions[5][1] = "short";
        questions[5][2] = "immutable";
        questions[5][3] = "const";
        questions[5][4] = "volatile";

        questions[6][0] = "Which keyword is used for accessing the features of a package ?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In Java jar stands for ?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is an example of iteration in C ?";
        questions[8][1] = "for";
        questions[8][2] = "while";
        questions[8][3] = "do-while";
        questions[8][4] = "all of the above";

        questions[9][0] = "Which of the following option leads to the portability and security of Java ?";
        questions[9][1] = "Bytecode is executed by JVC";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "Dennis Ritchie";
        answers[1][1] = "int";
        answers[2][1] = "java.util Package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap Memory";
        answers[5][1] = "const";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "all of the above";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(130, 430, 700,30 );
        opt1.setBackground(new Color(187, 198, 226));
        opt1.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(130, 460, 700,30 );
        opt2.setBackground(new Color(187, 198, 226));
        opt2.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(130, 490, 700,30 );
        opt3.setBackground(new Color(187, 198, 226));
        opt3.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(130, 520, 700,30 );
        opt4.setBackground(new Color(187, 198, 226));
        opt4.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt4);

        // Grouping all the radio buttons

        groupbutton = new ButtonGroup();
        groupbutton.add(opt1);
        groupbutton.add(opt2);
        groupbutton.add(opt3);
        groupbutton.add(opt4);

        next = new JButton("Next");
        next.setBounds(900,580,90,30);
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(30,144,254));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1000,580,90,30);
        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // following function is used to display the question and all the next questions
        start(count);

        getContentPane().setBackground(new Color(187, 198, 226));
        setLayout(null);

        setBounds(50, 5, 1200, 700);
        setVisible(true);
    }

    // following method or function displays the next question or submit and goes to Score
    // page after clicking the button of Next and Submit
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == next){
            repaint();
            ans_given = 1;

            // if the user didn't choose any option then the blank string will be stored
            if(groupbutton.getSelection() == null){
                useranswers[count][0] = "";
            }

            // here the option selected by user will be taken by using the getActionCommand()
            // and getSelection() methods
            else {
                useranswers[count][0] = groupbutton.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        if(ae.getSource() == submit){

            ans_given = 1;
            if(groupbutton.getSelection()==null){
                useranswers[count][0] = "";
            }
            else {
                useranswers[count][0] = groupbutton.getSelection().getActionCommand();
            }

            for(int i = 0; i < useranswers.length; i++){
                if(useranswers[i][0].equals(answers[i][1])){
                    score+=10;
                }
                else{
                    score+=0;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }

    // the paint function is responsible for displaying and modifiying the timer
    // after every question the timer will reset
    // following method or function displays the question and next question and goes to
    // Score page after the timer or time ends i.e. 15 seconds
    public void paint(Graphics g){

        super.paint(g);
        String time = "Time Left "+timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD,20));

        if(timer > 0){
            g.drawString(time, 900, 450);
        }
        else{
            g.drawString("Time is Up!!!", 900, 450);
        }
        timer--;
        try {
            // for 1 second the timer is sleep so to match the actual 1 second
            Thread.sleep(1000);
            repaint();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            // here if the user has selected any option then the our flag which ans_given is again
            // set to false and the timer is again reset for the next question
            timer = 15;
        }
        else if(timer < 0){
            timer = 15;
            // I tried to find what will happen if we enable submit and disable next here
            // but I didn't find any difference cuz we have already enabled and disabled
            // the submit and next button in the actionPerformed() function but keep it don't
            // remove the following if condition may be I will find any other time
            if (count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9)          // for submit button
            {
                if(groupbutton.getSelection()==null){
                    useranswers[count][0] = "";
                }
                else {
                    useranswers[count][0] = groupbutton.getSelection().getActionCommand();
                }

                for(int i = 0; i < useranswers.length; i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score+=10;
                    }
                    else{
                        score+=0;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }
            else {
                if(groupbutton.getSelection()==null){
                    useranswers[count][0] = "";
                }
                else {
                    useranswers[count][0] = groupbutton.getSelection().getActionCommand();
                }
                // from following we are moving toward the next question to display
                count++;
                start(count);
            }
        }
    }

    // here we are getting the questions and their options from array and displaying them
    // with the help of count global variable
    // First we are displaying the qno (question no.) and then we are displaying the
    // question and getting the qno from the count and getting the question and its option
    // text from the questions array
    public void start(int count){
        qno.setText(""+(count+1)+".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        groupbutton.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
