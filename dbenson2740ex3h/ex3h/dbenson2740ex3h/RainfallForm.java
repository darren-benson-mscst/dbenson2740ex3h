package dbenson2740ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel highestLabel;
	private JLabel lowestLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7"};
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("Dbenson 2740 Ex3H Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly rainfall");
		lblMonthlyRainfall.setBounds(10, 11, 111, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBorder(new LineBorder(new Color(0, 0, 0)));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sept", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(10, 36, 46, 199);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rainfallList.setBounds(67, 36, 56, 199);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(154, 38, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(154, 93, 46, 14);
		contentPane.add(lblAverage);
		
		JLabel lblHighest = new JLabel("Highest:");
		lblHighest.setBounds(154, 136, 46, 14);
		contentPane.add(lblHighest);
		
		JLabel lblLowest = new JLabel("Lowest:");
		lblLowest.setBounds(154, 186, 46, 14);
		contentPane.add(lblLowest);
		
		totalLabel = new JLabel("0.0");
		lblTotal.setLabelFor(totalLabel);
		totalLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setBounds(245, 36, 46, 30);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		lblAverage.setLabelFor(averageLabel);
		averageLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		averageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		averageLabel.setBounds(245, 86, 46, 28);
		contentPane.add(averageLabel);
		
		highestLabel = new JLabel("0.0");
		lblHighest.setLabelFor(highestLabel);
		highestLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		highestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highestLabel.setBounds(245, 129, 46, 28);
		contentPane.add(highestLabel);
		
		lowestLabel = new JLabel("0.0");
		lblLowest.setLabelFor(lowestLabel);
		lowestLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lowestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lowestLabel.setBounds(245, 179, 46, 28);
		contentPane.add(lowestLabel);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCalculate_actionPerformed(arg0);
			}
		});
		btnCalculate.setBounds(220, 234, 89, 23);
		contentPane.add(btnCalculate);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.CENTER);
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(67, 254, 56, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(53, 287, 89, 23);
		btnUpdate.setEnabled(false);
		contentPane.add(btnUpdate);
	}
	protected void do_btnCalculate_actionPerformed(ActionEvent arg0) {
		Rainfall rainfallData = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));
		averageLabel.setText(fmt.format(rainfallData.getAverage()));
		highestLabel.setText(fmt.format(rainfallData.getHighest()));
		lowestLabel.setText(fmt.format(rainfallData.getLowest()));
		
	}
	
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		
		int selectedIndex = rainfallList.getSelectedIndex();
		double rain = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(rain);
		
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		btnUpdate.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		highestLabel.setText("");
		lowestLabel.setText("");
		
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		
		btnUpdate.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
}
