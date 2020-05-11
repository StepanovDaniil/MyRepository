package myFirstPackage;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuelConsumption {
	
	public static void main(String[] args) {
		//	������� ������ ����� �� ������.
		FuelConsumption fc = new FuelConsumption();
	}
	

	// ���������.
	/** ��������� �� ������. ����� "��������� ������!" �������� �����. */
	public static final String ERROR_MESSAGE = "<html><span style='color:red'>��������� ������!</span></html>"; 

	// ��������� � �������������� ���������� ����.
	private JFrame frame = new JFrame("������ ������� �������");
	private JPanel windowContent = new JPanel();
	private JLabel label1 = new JLabel("���������� ��������� (��):");
	private JTextField field1 = new JTextField("0");
	private JLabel label2 = new JLabel("��������� ������� (���/����):");
	private JTextField field2 = new JTextField("40");
	private JLabel label3 = new JLabel("������� ������ (������/100��):");
	private JTextField field3 = new JTextField("10");
	private JButton batton = new JButton("���������� ������");
	private JLabel results = new JLabel("", 0);
	
	/**
	 * ����������� ��� ����������. ������� �� ����� ���� � ������, ������������ �� ���������:
	 * ���������� ��������� (��): 0
	 * ��������� ������� (���/����): 40
	 * ������� ������ (������/100��): 10 
	 */
	public FuelConsumption() {
		// ��������� ������ ��������� ��� �������� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������ ������������ GridLayout ��� ����������� ������.
		// ��� ����� ������������� � ������� �������� 4 �� 2.
		// ���������� ����� �������� ������� - 5 �������� �� ����������� � 5 �� ���������.
		GridLayout gl = new GridLayout(4,2,5,5);
		windowContent.setLayout(gl);

		// ��������� ���������� �� ������.
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(field3);
		windowContent.add(batton);
		windowContent.add(results);	
		
		// ������� "���������". ��� ������ ���������� ������ Listener, ������� ����� "�������". 
		// ������� "������� �� ������" � �������� ����������.
		batton.addActionListener(new Listener());
				
		// ��������� ����� � ������.	
		frame.setContentPane(windowContent);
		
		// ����� ������ � ���������� �����.
		frame.setSize(450,150);
		frame.setVisible(true);
	}
	
	/**
	 * ����������� � �����������. ��������� ������ �������� ����� �� ���������.
	 */
	public FuelConsumption(String range, String fuelPrice, String averFuelCons) {
		// �������� ����������� ��� ����������.
		this();

		// ��������� ���� �� �����.
		field1.setText(range);
		field1.setText(fuelPrice);
		field3.setText(averFuelCons);		
	}
	
	/** ��������� ����� ��� ��������� ������� "������� �� ������". */
	private class Listener implements ActionListener {
		@Override
		// ����� ��������� ��������� ActionListener, ������� �� ������ ����������� ����� actionPerformed.
		// JVM ��������� ���� �����, ����� ������������ �������� �� ������.
		public void actionPerformed(ActionEvent e) {

			// �������� ������ c ����� ����� � ����� getProfit ��� ����������.
			String result = GetMoneyAmount(field1.getText(), field2.getText(), field3.getText());
			
			// ������� �� ����� ���������� ����������.
			results.setText(result);
		}	
	}
	
	/**
	 * ����� ����������� ������, ����������� �� ������� �������
	 * ����� ��������� ��� ������, ������������ ������ � � ������� �����, ��������� ��������� �� �������.
	 * �������: ������ = ���������� ��������� * ��������� ������� �� ���� * ������ ������� �� 100 �� / 100.	
	 * @return ������ � ������ �����. ���������� ����������� �� ���� ������ ����� �������.
	 * @return ���� ���������� ������ ������ �����������, �� ������������ ������ ERROR_MESSAGE.
	 * @see ERROR_MESSAGE
	 */
	public static String GetMoneyAmount(String range, String fuelPrice, String averFuelCons) {
		float rangeFloat;
		float fuelPriceFloat;
		float averFuelConsFloat;		
			
		// ������� ������������� ������ � ������� ����� float.
		// � ������ ������ ����� ���������� ������ ERROR_MESSAGE.
		try {
			rangeFloat = Float.parseFloat(range);
			fuelPriceFloat = Float.parseFloat(fuelPrice);
			averFuelConsFloat = Float.parseFloat(averFuelCons);
		} catch(NumberFormatException e) {
			return ERROR_MESSAGE;
		}
			
		// ������� ��������� �����, ���������� �� 100, � ������� Math.round(), � ����� ����� ����� �� 100.
		// ����� ������� �������� ���������� �� ���� ������ ���� �������. 
		float resultFloat = Math.round(rangeFloat * fuelPriceFloat * averFuelConsFloat) / 100f;
				
		// ��������� ����������� � ������������ � ������.
		return String.format("%.2f", resultFloat);
	}
}
