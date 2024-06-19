import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame {
    private JFrame frame;
    private JTextField delayTF;
    private JTextField textTF;
    private JTextField repeatTF;
    private myThread t;

    public Frame(){
        frame = new JFrame("Autotyper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel delayLabel = new JLabel("Delay (in seconds):");
        delayTF = new JTextField(10);

        JLabel textLabel = new JLabel("Text:");
        textTF = new JTextField(10);

        JLabel repeatLabel = new JLabel("Repeat times:");
        repeatTF = new JTextField(10);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             startAutotyper();
            }
        });
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            stopAutotype();
            }
        });

        panel.add(delayLabel);
        panel.add(delayTF);
        panel.add(textLabel);
        panel.add(textTF);
        panel.add(repeatLabel);
        panel.add(repeatTF);
        panel.add(startButton);
        panel.add(stopButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private void startAutotyper(){
        int delay = Integer.parseInt(delayTF.getText());
        String text= textTF.getText();
        int repeatTimes = Integer.parseInt(repeatTF.getText());
        t = new myThread();
        t.delay= delay;
        t.repeatTimes=repeatTimes;
        t.text=text;
        t.start();
    }
    private void stopAutotype(){
        if(t != null){
            t.stopmyThread();
        
        }
    }
}