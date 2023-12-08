package tr.com.ek.fe;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tr.com.ek.interfaces.FeInterfaces;

public class AnaEkranFE extends JDialog implements FeInterfaces{

	public AnaEkranFE() {
		initPencere();
	}
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		JMenuBar bar = initBar();

		add(panel);
		setJMenuBar(bar);
		setTitle("Satış Ve Stok Otomasyon Sistemi");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		return null;
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
