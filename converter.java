import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class App extends JFrame
{
Container c;
JLabel labInput,labOutput,labHeader;
JTextField txtInput,txtOutput;
JButton btnConvert,btnExit;
JComboBox comboBox1,comboBox2;
App()
{
c = getContentPane();

labInput = new JLabel("Enter Value");
labOutput = new JLabel("Output");
txtInput = new JTextField(20);
txtOutput= new JTextField(20);
btnConvert = new JButton("CONVERT");
btnExit = new JButton("EXIT");

Panel panel = new Panel();
panel.setBounds(0,0,660,50);
panel.setBackground(Color.gray);
labHeader = new JLabel("LENGTH CONVERTER");
labHeader.setForeground(Color.white);
panel.add(labHeader);

String[] scale1 = {"Select Unit","Millimeters","Centimeters","Meters","Kilometers","Inches"};
comboBox1 = new JComboBox(scale1);
comboBox2 = new JComboBox(scale1);

Font f = new Font("Cambria",Font.BOLD,25);
Font d = new Font("Cambria",Font.BOLD,18);
labInput.setFont(f);
labOutput.setFont(f);
labHeader.setFont(f);
txtInput.setFont(d);
txtOutput.setFont(d);

labInput.setBounds(50,100,200,30);
txtInput.setBounds(220,100,170,30);
comboBox1.setBounds(440,100,100,30);
labOutput.setBounds(50,150,200,30);
txtOutput.setBounds(220,150,170,30);
comboBox2.setBounds(440,150,100,30);
btnConvert.setBounds(180,270,100,30);
btnExit.setBounds(340,270,100,30);


c.add(labInput);
c.add(txtInput);
c.add(comboBox1);
c.add(labOutput);
c.add(txtOutput);
c.add(comboBox2);
c.add(btnConvert);
c.add(btnExit);
c.add(panel);

txtInput.setHorizontalAlignment(JTextField.RIGHT);
txtOutput.setHorizontalAlignment(JTextField.RIGHT);
setLayout(null);
setTitle("Length Converter App");
setSize(660,450);
setLocationRelativeTo(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

ActionListener a = (ae) ->
{
String selectedUnit1 = comboBox1.getSelectedItem().toString();
String selectedUnit2 = comboBox2.getSelectedItem().toString();
double inputValue = 1;

if(txtInput.getText().equals(""))
{JOptionPane.showMessageDialog(c,"Please Enter Value to convert");}
else{
try{
inputValue = Double.parseDouble(txtInput.getText());
}catch(Exception e)
{
JOptionPane.showMessageDialog(c,"Please Enter Integers Only"); 
}
if(selectedUnit1 == "Select Unit" && selectedUnit2 == "Select Unit"){JOptionPane.showMessageDialog(c,"Please Select unit of Input and Output");}
else if(selectedUnit1 == "Select Unit" || selectedUnit2 == "Select Unit"){JOptionPane.showMessageDialog(c,"Not Select unit of Input or Output");}
else if(inputValue < 0 ){JOptionPane.showMessageDialog(c,"Entered Value cannot be Converted");}
else if(selectedUnit1 == "Select Unit"){JOptionPane.showMessageDialog(c,"Please Select unit of Input");}
else if(selectedUnit1 == "Meters"){}
else if(selectedUnit1 == "Centimeters"){inputValue = inputValue * 0.01;}
else if(selectedUnit1 == "Millimeters"){inputValue = inputValue * 0.001;}
else if(selectedUnit1 == "Kilometers"){inputValue = inputValue * 1000;}
else if(selectedUnit1 == "Inches"){inputValue = inputValue * 0.0254;}
else{}
double result = 1;
if(selectedUnit2 == "Meters"){result = inputValue;}
else if(selectedUnit2 == "Centimeters"){result = inputValue * 100;}
else if(selectedUnit2 == "Millimeters"){result = inputValue * 1000;}
else if(selectedUnit2 == "Kilometers"){result = inputValue * 0.001;}
else if(selectedUnit2 == "Inches"){result = inputValue * 39.3701;}
else{result = 0.0;}
String r = Double.toString(result); 
txtOutput.setText(r);
}
};btnConvert.addActionListener(a);

  
ActionListener b = (ae) ->
{
System.exit(0);
};btnExit.addActionListener(b);

}
}


class converter
{
public static void main(String args[])
{
new App();
}
}
