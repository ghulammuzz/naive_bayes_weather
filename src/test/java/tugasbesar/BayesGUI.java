package tugasbesar;

import javax.swing.*;
import java.awt.event.*;

public class BayesGUI extends NB implements ActionListener {
    private JTextField input1, input2, input3, Hasil;
    private JButton btn;

    public BayesGUI(){
        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 400, 260);
        frame.setTitle("Cuaca");

        JLabel label1 = new JLabel("Temperature : ");
        label1.setBounds(25,25,100,25);
        frame.add(label1);
        input1 = new JTextField();
        input1.setBounds(125,25,100,25);
        frame.add(input1);

        JLabel label2 = new JLabel("Humidity : ");
        label2.setBounds (25,60,100,25);
        frame.add(label2);
        input2 = new JTextField();
        input2.setBounds(125, 60, 100, 25);
        frame.add(input2);

        JLabel label3 = new JLabel("Wind Speed : ");
        label3.setBounds (25,95,100,25);
        frame.add(label3);
        input3 = new JTextField();
        input3.setBounds(125, 95, 100, 25);
        frame.add(input3);

        JLabel labelHasil = new JLabel("Hasil : "); 
        labelHasil.setBounds (25,140,100,25);
        frame.add(labelHasil);
        Hasil = new JTextField();
        Hasil.setEditable(false);
        Hasil.setBounds(125, 140, 250, 100);
        frame.add(Hasil);

        btn = new JButton("=");
        btn.setBounds(235,60,50,25);
        frame.add(btn);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e){
        // if(e.getSource() == btn){
        super.hitung();

        try{
        	double temp = Double.parseDouble(input1.getText().trim());
        	double humid = Double.parseDouble(input2.getText().trim());
        	double winds = Double.parseDouble(input3.getText().trim());
            String hasil = NB(temp, humid, winds);
            Hasil.setText(hasil);
        }
        catch (NullPointerException exc){
        	JOptionPane.showMessageDialog(null, "Inputan Anda Kosong", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException exc2){
//            Hasil.setText("Error!");
            JOptionPane.showMessageDialog(null, "Inputan Tidak Valid/Kosong", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public static void main(String[] args ) throws Exception{
    	
        BayesGUI frame = new BayesGUI();
    }
}
