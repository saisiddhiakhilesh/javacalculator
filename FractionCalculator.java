import com.fraction.Fraction;
import com.fraction.ZeroDenominatorException;
import com.texthint.JTextFieldHintUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.event.*;


public class FractionCalculator extends JFrame {
	JTextField numInput, denInput;
	int a;
	Fraction temp, temp1, result;
	static Fraction m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clr, pow2, pow3,
			plus, min, div, rec, mul, eq, addSub, mr, mc, mp, mm;	
	Container cont;												
	JPanel numPanel, denPanel, buttonpanel;							

	
	FractionCalculator() {
		cont = getContentPane();									
		cont.setLayout(new BorderLayout());							
		numPanel = new JPanel();							
		denPanel = new JPanel();
		numInput = new JTextField(25);
		numInput.setHorizontalAlignment(SwingConstants.RIGHT);		
		numInput.addKeyListener(new KeyAdapter() {					
			public void keyTyped(KeyEvent keyevent) {				
				char c = keyevent.getKeyChar();						
				if (c >= '0' && c <= '9') {
				}
				else if (c == '\n') {								
    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
	    					temp1 = new Fraction(0);
	    				} 
	    				else if (numInput.getText().equals("")) {
	    					numInput.setText("0");
	    					temp1 = new Fraction(0);
	    				}
	    				else if (denInput.getText().equals("")) {
	    					denInput.setText("1");
	    					temp1 = new Fraction(0);
	    				}
	    				else {
	    					try {
	    					temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
	    				}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null,zde.getMessage());
	    						temp1 = new Fraction(Integer.parseInt(numInput.getText()));
	    					}
	    				}
	    				numInput.requestFocus();
    					switch (ch) {
    					case '+':
    						result = temp.add(temp1);
    						break;
    					case '-':
    						result = temp.subtract(temp1);
    						break;
    					case '/':
    						result = temp.divide(temp1);
    						break;
    					case '*':
    						result = temp.multiply(temp1);
    						break;
    					}
    					numInput.setText(Integer.toString(result.getNumerator()));
    					denInput.setText(Integer.toString(result.getDenominator()));
    					z = 1;
    					try {
    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));	    				
    						}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null,zde.getMessage());
	    						temp = new Fraction(Integer.parseInt(numInput.getText()));
	    					}
    					temp1 = new Fraction(0);
    				numInput.requestFocus();
    			}
				else {
					keyevent.consume();								
				}
			}
		});
		numPanel.add(numInput);										
		denInput = new JTextField(25);
		denInput.setHorizontalAlignment(SwingConstants.RIGHT);		
		denInput.addKeyListener(new KeyAdapter() {				
			public void keyTyped(KeyEvent keyevent) {				
				char c = keyevent.getKeyChar();				
				if (c >= '0' && c <= '9') {
				}
				else if (c == '\n') {										
    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
	    					temp1 = new Fraction(0);
	    				} 
	    				else if (numInput.getText().equals("")) {
	    					numInput.setText("0");
	    					try {
	    					temp1 = new Fraction(0 , Integer.parseInt(denInput.getText())); }
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null, zde.getMessage());
	    					}
	    				}
	    				else if (denInput.getText().equals("")) {
	    					denInput.setText("1");
	    					temp1 = new Fraction(0);
	    				}
	    				else {
	    					try {
	    						temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
	    					}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null, zde.getMessage());
	    						temp1 = new Fraction(0);
	    					}
	    				}
	    				numInput.requestFocus();
    					switch (ch) {
    					case '+':
    						result = temp.add(temp1);
    						break;
    					case '-':
    						result = temp.subtract(temp1);
    						break;
    					case '/':
    						result = temp.divide(temp1);
    						break;
    					case '*':
    						result = temp.multiply(temp1);
    						break;
    					}
    					numInput.setText(Integer.toString(result.getNumerator()));
    					denInput.setText(Integer.toString(result.getDenominator()));
    					z = 1;
    					try {
    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())); 
    					}
    					catch (ZeroDenominatorException zde) {
    						JOptionPane.showMessageDialog(null , zde.getMessage());
    						temp = new Fraction(Integer.parseInt(numInput.getText()));
    					}
    					temp1 = new Fraction(0);
    				denInput.requestFocus();
    			}
				else {
					keyevent.consume();							
				}
			}
		});
		denInput.setUI(new JTextFieldHintUI("Denominator" , Color.GRAY));
		TextAction action = new TextAction("")
		{
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		            JTextComponent textField = getFocusedComponent();
		            String s = e.getActionCommand();					
		    			if (s.equals("1")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "1");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "1");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("2")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "2");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "2");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("3")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "3");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "3");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("4")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "4");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "4");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("5")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "5");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "5");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("6")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "6");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "6");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("7")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "7");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "7");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("8")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "8");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "8");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("9")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "9");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "9");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("0")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "0");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "0");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("AC")) {
		    				numInput.setText("");										
		    				denInput.setText("");
		    				x = 0;
		    				y = 0;
		    				z = 0;
		    			}
		    			if (s.equals("log")) {
		    				if (textField.getText().equals("")) {
		    					textField.setText("");								
		    				} else {
		    					a = (int) Math.log(Integer.parseInt(textField.getText()));	
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);			
		    				}
		    			}
		    			if (s.equals("1/x")) {
		    				if (numInput.getText().equals("") || Integer.parseInt(numInput.getText()) == 0) {				
		    					numInput.setText("0");
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    				}
		    				else {
		    					String s1 = numInput.getText() , s2 = denInput.getText();
		    					numInput.setText(s2);
		    					denInput.setText(s1);
		    				}
		    			}
		    			if (s.equals("x^2")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    				}
		    				else {
		    					int a = Integer.parseInt(numInput.getText()) , b = Integer.parseInt(denInput.getText());
		    					numInput.setText(Integer.toString(a * a));
		    					denInput.setText(Integer.toString(b * b));
		    				}
		    			}
		    			if (s.equals("x^3")) {
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					a = (int) Math.pow(Integer.parseInt(textField.getText()), 3);	
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);
		    				}
		    			}
		    			if (s.equals("+/-")) {									
		    					a = Integer.parseInt(textField.getText());
		    					a *= -1;
		    					textField.setText("" + a);
		    			}
		    			if (s.equals("+")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText())); 
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction();
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					numInput.setText("0");								
		    					denInput.setText("1");
		    					ch = '+';									
		    					y = 0;
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("-")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    					temp = new Fraction(0 , Integer.parseInt(denInput.getText())); }
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null , zde.getMessage());
		    						temp = new Fraction(0);
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					numInput.setText("0");								
		    					denInput.setText("1");
		    					ch = '-';							
		    					y = 0;										
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("/")) {									
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText())); 
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					numInput.setText("0");		
		    					denInput.setText("1");
		    					ch = '/';								
		    					y = 0;										
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("*")) {									
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText()));
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(0);
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					numInput.setText("0");								
		    					denInput.setText("1");
		    					ch = '*';									
		    					y = 0;							
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("MC")) {										
		    				m1 = new Fraction(0);
		    				numInput.setText("0");
		    				denInput.setText("1");
		    			}
		    			if (s.equals("MR")) {
		    				numInput.setText("");
		    				denInput.setText("");
		    				numInput.setText(numInput.getText() + m1.getNumerator());				
		    				denInput.setText(denInput.getText() + m1.getDenominator());
		    			}
		    			if (s.equals("M+")) {
		    				if (k == 1) {
		    					try {
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					k++;
		    				} 
		    				else {
		    					try {
		    						m1 = m1.add(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));	
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = m1.add(new Fraction(Integer.parseInt(numInput.getText())));
		    					}
		    					numInput.setText("" + m1.getNumerator());							
		    					denInput.setText("" + m1.getDenominator());
		    				}
		    			}
		    			if (s.equals("M-")) {
		    				if (k == 1) {
		    					try {
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					k++;
		    				} else {
		    					try {
		    						m1 = m1.subtract(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));			
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = m1.subtract(new Fraction(Integer.parseInt(numInput.getText())));
		    					}
		    					numInput.setText("" + m1.getNumerator());							
		    					denInput.setText("" + m1.getDenominator());
		    				}
		    			}
		    			if (s.equals("Sqrt")) {
		    				if (textField.getText().equals("")) {						
		    					textField.setText("");
		    				} else {
		    					a = (int) Math.sqrt(Integer.parseInt(textField.getText()));	
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);
		    				}
		    			}
		    			if (s.equals("=")) {										
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
			    					temp1 = new Fraction(0);
			    				} 
			    				else if (numInput.getText().equals("")) {
			    					numInput.setText("0");
			    					try {
			    						temp1 = new Fraction(0 , Integer.parseInt(denInput.getText()));
			    					}
			    					catch (ZeroDenominatorException zde) {
			    						JOptionPane.showMessageDialog(null, zde.getMessage());
			    						temp1 = new Fraction(0);
			    					}
			    				}
			    				else if (denInput.getText().equals("")) {
			    					denInput.setText("1");
			    					temp1 = new Fraction(Integer.parseInt(numInput.getText()));
			    				}
			    				else {
			    					try {
			    						temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		
			    					}
			    					catch (ZeroDenominatorException zde) {
			    						JOptionPane.showMessageDialog(null, zde.getMessage());
			    						temp1 = new Fraction(Integer.parseInt(numInput.getText()));
			    					}
			    				}
			    				textField.requestFocus();
		    					switch (ch) {
		    					case '+':
		    						result = temp.add(temp1);
		    						break;
		    					case '-':
		    						result = temp.subtract(temp1);
		    						break;
		    					case '/':
		    						result = temp.divide(temp1);
		    						break;
		    					case '*':
		    						result = temp.multiply(temp1);
		    						break;
		    					}
		    					numInput.setText(Integer.toString(result.getNumerator()));
		    					denInput.setText(Integer.toString(result.getDenominator()));
		    					z = 1;
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					temp1 = new Fraction(0);
		    				}
		    			}
		    			textField.requestFocus();
		    			}
		};
		denPanel.add(denInput);						
		buttonpanel = new JPanel();						
		buttonpanel.setLayout(new GridLayout(6, 4, 2, 2));			
		mr = new JButton("MR");										
		buttonpanel.add(mr);								
		mr.addActionListener(action);								 
		mc = new JButton("MC");				
		buttonpanel.add(mc);
		mc.addActionListener(action);
		
		mp = new JButton("M+");
		buttonpanel.add(mp);
		mp.addActionListener(action);

		mm = new JButton("M-");
		buttonpanel.add(mm);
		mm.addActionListener(action);

		b1 = new JButton("1");
		buttonpanel.add(b1);
		b1.addActionListener(action);
		b2 = new JButton("2");
		buttonpanel.add(b2);
		b2.addActionListener(action);
		b3 = new JButton("3");
		buttonpanel.add(b3);
		b3.addActionListener(action);
		pow2 = new JButton("x^2");
		buttonpanel.add(pow2);
		pow2.addActionListener(action);

		b4 = new JButton("4");
		buttonpanel.add(b4);
		b4.addActionListener(action);
		b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(action);
		b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(action);
		pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
		pow3.addActionListener(action);

		b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(action);
		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(action);
		b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(action);
		rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(action);

		addSub = new JButton("+/-");
		buttonpanel.add(addSub);
		addSub.addActionListener(action);
		b0 = new JButton("0");
		buttonpanel.add(b0);
		b0.addActionListener(action);
		
		
		plus = new JButton("+");
		buttonpanel.add(plus);
		plus.addActionListener(action);

		min = new JButton("-");
		buttonpanel.add(min);
		min.addActionListener(action);
		
		clr = new JButton("AC");
		buttonpanel.add(clr);
		clr.addActionListener(action);
		eq = new JButton("=");
		buttonpanel.add(eq);
		eq.addActionListener(action);
		
		
		mul = new JButton("*");
		buttonpanel.add(mul);
		mul.addActionListener(action);

		div = new JButton("/");
		div.addActionListener(action);
		buttonpanel.add(div);
		

		cont.add("South", buttonpanel);								
		cont.add("Center" , denPanel);								
		cont.add("North", numPanel);								
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}

	public static void main(String args[]) {
		try {														
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Exception e) {}
		FractionCalculator f = new FractionCalculator();
		f.setResizable(false);
		f.setTitle("Scientific Calculator");
		f.pack();
		f.setVisible(true);
	}
}