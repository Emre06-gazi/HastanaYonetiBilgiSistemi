package tr.com.ek.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.ek.dal.AccountDAL;
import tr.com.ek.interfaces.FeInterfaces;
import tr.com.ek.types.PersonelContract;

public class LoginFe extends JDialog implements FeInterfaces {

	public static JComboBox kullaniciAdiBox;

	public LoginFe() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Hastane Yönetim Bilgi Sistemi"));

		add(panel);

		setTitle("Giriş Ekranı");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));
	
		JLabel kullaniciAdi = new JLabel("Kullanıcı Adı:", JLabel.RIGHT);
		panel.add(kullaniciAdi);
		kullaniciAdiBox = new JComboBox(new AccountDAL().GetAll().toArray());
		panel.add(kullaniciAdiBox);
		JLabel sifreLabel = new JLabel("Şifre:", JLabel.RIGHT);
		panel.add(sifreLabel);
		JPasswordField sifreText = new JPasswordField(20);
		panel.add(sifreText);
		
		JButton girişButton = new JButton("Giriş");
		panel.add(girişButton);
		JButton iptalButton = new JButton("İptal");
		panel.add(iptalButton);
		
		girişButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PersonelContract contract = (PersonelContract) kullaniciAdiBox.getSelectedItem();

				String sifre = sifreText.getText();

				if (new AccountDAL().GetPersonelIdVeSifre(contract.getId(), sifre).getId()!= 0) {
					
					new AnaEkranFE();

				} else {
					JOptionPane.showMessageDialog(null, "Giriş hatalı, şifre veya parolanız yanlış!");
				}
			
			}
		});


		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
