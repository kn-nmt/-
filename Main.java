package swingapp;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton button_form;
	private JButton button_data;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		button_form = new JButton("登録");
		button_form.addActionListener(this);
		contentPane.setLayout(new GridLayout(0, 2, 5, 0));

		button_data = new JButton("確認");
		button_data.addActionListener(this);
		contentPane.add(button_data);
		contentPane.add(button_form);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource() == button_form) {
			Input frame = new Input();
			frame.setVisible(true);
		}
		else if(e.getSource() == button_data){
			Output frame = new Output();
			frame.setVisible(true);
		}
	}

}
