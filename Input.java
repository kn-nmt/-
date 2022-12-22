package swingapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Input extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textF_name;
	private JTextField textF_address;
	private String[] list = {"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};
	private JComboBox cbox_age;
	private JLabel label_name_error = new JLabel("");
	private JLabel label_address_error = new JLabel("");
	private JComboBox cbox_address = new JComboBox();


	public Input() {

		setBounds(100, 100, 600, 350);
		setSize(600, 350);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Label_name = new JLabel("【氏名】");
		Label_name.setBounds(26, 49, 50, 13);
		contentPane.add(Label_name);

		textF_name = new JTextField();
		textF_name.setBounds(88, 46, 96, 19);
		contentPane.add(textF_name);
		textF_name.setColumns(10);

		JLabel label_age = new JLabel("【年齢】");
		label_age.setBounds(26, 100, 50, 13);
		contentPane.add(label_age);

		cbox_age = new JComboBox();
		cbox_age.setModel(new DefaultComboBoxModel(list));
		cbox_age.setToolTipText("");
		cbox_age.setBounds(88, 97, 96, 18);
		contentPane.add(cbox_age);

		JLabel label_address = new JLabel("【住所】");
		label_address.setBounds(26, 152, 50, 13);
		contentPane.add(label_address);

		textF_address = new JTextField();
		textF_address.setBounds(88, 188, 431, 19);
		contentPane.add(textF_address);
		textF_address.setColumns(10);

		JButton button_input = new JButton("登録");
		button_input.setBounds(458, 245, 91, 21);
		button_input.addActionListener(this);
		contentPane.add(button_input);

		label_name_error.setBounds(88, 28, 374, 13);
		contentPane.add(label_name_error);

		label_address_error.setBounds(88, 175, 374, 13);
		contentPane.add(label_address_error);

		cbox_address.setModel(new DefaultComboBoxModel(new String[] {"北海道", "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県", "茨城県", "栃木県", "群馬県", "埼玉県", "千葉県", "東京都", "神奈川県", "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県", "静岡県", "愛知県", "三重県", "滋賀県", "京都府", "大阪府", "兵庫県", "奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県", "徳島県", "香川県", "愛媛県", "高知県", "福岡県", "佐賀県", "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県", "沖縄県"}));
		cbox_address.setBounds(88, 149, 80, 18);
		contentPane.add(cbox_address);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

		Pattern p_name = Pattern.compile("^[(\\p{InHiragana}|\\p{InKatakana}|\\p{InCJKunifiedideographs})]+$");
		Matcher m_name = p_name.matcher(textF_name.getText());
		Pattern p_address = Pattern.compile("^[(\\p{InHiragana}|\\p{InKatakana}|\\p{InCJKunifiedideographs}|[0-9０-９a-zA-Zａ-ｚＡ-Ｚ]|[-|－])]+$");
		Matcher m_address = p_address.matcher(textF_address.getText());
		boolean flag = true;
		String address = ((String)cbox_address.getSelectedItem()).concat(textF_address.getText());

		if(m_name.find()) {
			label_name_error.setText("");
		}
		else if(textF_name.getText().equals("")) {
			label_name_error.setText("名前を入力してください");
			flag = false;
		}
		else {
			label_name_error.setText("英数字や記号また空白は使用できません");
			flag = false;
		}

		if(m_address.find()) {
			label_address_error.setText("");
		}
		else if(textF_address.getText().equals("")) {
			label_address_error.setText("住所を入力してください");
			flag = false;
		}
		else {
			label_address_error.setText("ハイフン以外の記号は使用できません");
			flag = false;
		}

		if(flag) {
			DBInsert data_in = new DBInsert();
			data_in.Data(textF_name.getText(), (String)cbox_age.getSelectedItem(), address);
			setVisible(false);
		}
	}
}

