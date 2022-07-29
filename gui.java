import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener {
    private int count = 0;
    private JLabel output = new JLabel();
    private JLabel title;
    private JLabel info;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField   textEntry = new JTextField(30);
    private JButton enter = new JButton("Enter"), exit = new JButton("Exit"), clear = new JButton("Clear") ;
    private Box titleText;
    private void setTitle()
    {
        titleText = Box.createHorizontalBox();
        title = new JLabel("<html><span style='color: black;'>NUMERONYM</span></html>", SwingConstants.CENTER); // color of title
        title.setFont(new Font("Times New Roman", Font.LAYOUT_NO_LIMIT_CONTEXT, 45)); // font size 45
        title.setAlignmentX(frame.getWidth()/2); // centers title
        titleText.add(title); // add title to box
        info = new JLabel("Create an alpha-numerical abbreviation of words 9 letters or longer. Do not enter punctuation",SwingConstants.CENTER);
    }
    private void textBoxInput()
    {
        textEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textEntry.getText();
                output.setText(userInput);
                Numeronym nym = new Numeronym(userInput);
                output.setText(nym.printNumeronym(userInput));
            }
        });
    }
    private void setPanel()
    {
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(new Color(255, 251, 233));
    }
    private void addToPanel()
    {
        panel.add(titleText); // numeronym title
        panel.add(info); // explanation of this program
        panel.add(textEntry); // textBox
        panel.add(enter); // enter button
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textEntry.getText();
                output.setText(userInput);
                Numeronym nym = new Numeronym(userInput);
                output.setText(nym.printNumeronym(userInput));
            }
        });
        panel.add(clear);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEntry.setText("");
                output.setText("");

            }
        });
        panel.add(output);
        panel.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private void setFrame()
    {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My 1st GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // gui constructor
    public gui()
    {
        setTitle();
        textBoxInput();
        setPanel();
        addToPanel();
        setFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
    }

}
