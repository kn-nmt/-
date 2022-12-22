package swingapp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Output extends JFrame {

	private JPanel panel_top;
	private JPanel panel_center;
	private JPanel panel_bottom;
	private JTextField textF_delete;
	private JTable table;
	private Container container;
	private DefaultTableModel defaultTable = new DefaultTableModel(new String[] { "番号", "名前", "年齢", "住所" }, 0);
	private JTextField textF_search;
	private JRadioButton radio_name = new JRadioButton("氏名");
	private JRadioButton radio_age = new JRadioButton("年齢");
	private JRadioButton radio_address = new JRadioButton("住所");
	private ArrayList<List> list = new ArrayList<List>();
	private JLabel label_search_error;

	public Output() {
		DBSelect db = new DBSelect();
		list = db.selectAll();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 450);

		panel_center = new JPanel();
		panel_center.setBounds(0, 52, 668, 309);
		panel_center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		label_search_error = new JLabel("");
		panel_center.add(label_search_error);

		table = new JTable(defaultTable);
		JScrollPane sp = new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(600, 310));
		panel_center.add(sp);

		panel_bottom = new JPanel();
		panel_bottom.setBounds(0, 360, 668, 51);
		panel_bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label_delete = new JLabel("削除したい番号を入力してください。");
		panel_bottom.add(label_delete);

		textF_delete = new JTextField();
		panel_bottom.add(textF_delete);
		textF_delete.setColumns(10);

		JButton button_delete = new JButton("削除");
		panel_bottom.add(button_delete);

		panel_top = new JPanel();
		panel_top.setBounds(0, 0, 668, 52);
		radio_name.setSelected(true);

		radio_name.setToolTipText("");
		panel_top.add(radio_name);
		panel_top.add(radio_age);
		panel_top.add(radio_address);

		textF_search = new JTextField();
		panel_top.add(textF_search);
		textF_search.setColumns(10);

		JButton button_search = new JButton("検索");
		panel_top.add(button_search);

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(radio_name);
		bgroup.add(radio_age);
		bgroup.add(radio_address);

		button_search.addActionListener(new search());

		container = new Container();
		container = getContentPane();
		container.add(panel_top, BorderLayout.NORTH);
		container.add(panel_center, BorderLayout.CENTER);
		container.add(panel_bottom, BorderLayout.PAGE_END);


		for (int i = 0; i < list.size(); i++) {
			List tmp = list.get(i);
			defaultTable.addRow(new Object[] { tmp.getNumber(), tmp.getName(), tmp.getAge(), tmp.getAddress() });
		}

		button_delete.addActionListener(new delete());

	}

	public class delete implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
			DBDelete data_delete = new DBDelete();
			data_delete.Data(Integer.parseInt(textF_delete.getText()));
			setVisible(false);
		}
	}

	public class search implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			boolean flag = false;

			if(radio_name.isSelected()) {
				for (int i = 0; i < list.size(); i++) {
					List tmp = list.get(i);

					if(tmp.getName().equals(textF_search.getText())) {

						defaultTable.addRow(new Object[] { tmp.getNumber(), tmp.getName(), tmp.getAge(), tmp.getAddress() });
						flag = true;
					}
				}
			}

			else if(radio_age.isSelected()) {
				for (int i = 0; i < list.size(); i++) {
					List tmp = list.get(i);

					if(tmp.getAge().equals(textF_search.getText())) {
						defaultTable.addRow(new Object[] { tmp.getNumber(), tmp.getName(), tmp.getAge(), tmp.getAddress() });
						flag = true;
					}
				}
			}

			else if(radio_address.isSelected()) {
				for (int i = 0; i < list.size(); i++) {
					List tmp = list.get(i);

					if(tmp.getAddress().equals(textF_search.getText())) {
						defaultTable.addRow(new Object[] { tmp.getNumber(), tmp.getName(), tmp.getAge(), tmp.getAddress() });
						flag = true;
					}
				}
			}

			if(flag) {
				label_search_error.setText("");
			}
			else {
				label_search_error.setText("該当するデータがありません");
				if(textF_search.getText().equals("")) {
					label_search_error.setText("検索ワードを入力してください");
				}
			}
		}

	}
}