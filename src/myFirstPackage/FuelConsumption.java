package myFirstPackage;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuelConsumption {
	
	public static void main(String[] args) {
		//	Создаем объект этого же класса.
		FuelConsumption fc = new FuelConsumption();
	}
	

	// Константы.
	/** Сообщение об ошибке. Текст "Проверьте данные!" красного цвета. */
	public static final String ERROR_MESSAGE = "<html><span style='color:red'>Проверьте данные!</span></html>"; 

	// Объявляем и инициализируем компоненты окна.
	private JFrame frame = new JFrame("Расчет расхода топлива");
	private JPanel windowContent = new JPanel();
	private JLabel label1 = new JLabel("Пройденное растояние (км):");
	private JTextField field1 = new JTextField("0");
	private JLabel label2 = new JLabel("Стоимость топлива (руб/литр):");
	private JTextField field2 = new JTextField("40");
	private JLabel label3 = new JLabel("Средний расход (литров/100км):");
	private JTextField field3 = new JTextField("10");
	private JButton batton = new JButton("Рассчитать расход");
	private JLabel results = new JLabel("", 0);
	
	/**
	 * Конструктор без аргументов. Выводит на экран окно с полями, заполненными по умолчанию:
	 * Пройденное растояние (км): 0
	 * Стоимость топлива (руб/литр): 40
	 * Средний расход (литров/100км): 10 
	 */
	public FuelConsumption() {
		// Завершить работу программы при закрытии окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Задаем расположения GridLayout для компонентов панели.
		// Они будут располагаться в таблице размером 4 на 2.
		// Расстояние между ячейками таблицы - 5 пикселей по горизонтали и 5 по вертикали.
		GridLayout gl = new GridLayout(4,2,5,5);
		windowContent.setLayout(gl);

		// Добавляем компоненты на панель.
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(field3);
		windowContent.add(batton);
		windowContent.add(results);	
		
		// Создаем "слушатель". Это объект вложенного класса Listener, который будет "слушать". 
		// событие "Нажатие на кнопку" и вызывать вычисления.
		batton.addActionListener(new Listener());
				
		// Связываем фрейм и панель.	
		frame.setContentPane(windowContent);
		
		// Задаём размер и отображаем фрейм.
		frame.setSize(450,150);
		frame.setVisible(true);
	}
	
	/**
	 * Конструктор с аргументами. Позволяет задать значения полей по умолчанию.
	 */
	public FuelConsumption(String range, String fuelPrice, String averFuelCons) {
		// Вызываем конструктор без аргументов.
		this();

		// Заполняем поля на форме.
		field1.setText(range);
		field1.setText(fuelPrice);
		field3.setText(averFuelCons);		
	}
	
	/** Вложенный класс для обработки событий "Нажатие на кнопку". */
	private class Listener implements ActionListener {
		@Override
		// Класс реализует интерфейс ActionListener, поэтому мы должны реализовать метод actionPerformed.
		// JVM выполняет этот метод, когда пользователь нажимает на кнопку.
		public void actionPerformed(ActionEvent e) {

			// Передаем данные c полей формы в метод getProfit для вычислений.
			String result = GetMoneyAmount(field1.getText(), field2.getText(), field3.getText());
			
			// Выводим на форму результаты вычислений.
			results.setText(result);
		}	
	}
	
	/**
	 * Метод расчитывает деньги, потраченные на покупку топлива
	 * Метод принимает три строки, конвертирует строки в в дробные числа, вычисляет результат по формуле.
	 * Формула: Деньги = Пройденное растояние * Стоимость топлива за литр * Расход топлива на 100 км / 100.	
	 * @return Строка с суммой денег. Количество округляется до двух знаком после запятой.
	 * @return Если переданные методу данные некорректны, то возвращается строка ERROR_MESSAGE.
	 * @see ERROR_MESSAGE
	 */
	public static String GetMoneyAmount(String range, String fuelPrice, String averFuelCons) {
		float rangeFloat;
		float fuelPriceFloat;
		float averFuelConsFloat;		
			
		// Пробуем преобразовать строки в дробные числа float.
		// В случае ошибки метод возвращает строку ERROR_MESSAGE.
		try {
			rangeFloat = Float.parseFloat(range);
			fuelPriceFloat = Float.parseFloat(fuelPrice);
			averFuelConsFloat = Float.parseFloat(averFuelCons);
		} catch(NumberFormatException e) {
			return ERROR_MESSAGE;
		}
			
		// Сначала округляем число, умноженное на 100, с помощью Math.round(), а потом снова делим на 100.
		// Таким образом получаем округление до двух знаков поле запятой. 
		float resultFloat = Math.round(rangeFloat * fuelPriceFloat * averFuelConsFloat) / 100f;
				
		// Результат форматируем и конвертируем в строку.
		return String.format("%.2f", resultFloat);
	}
}
