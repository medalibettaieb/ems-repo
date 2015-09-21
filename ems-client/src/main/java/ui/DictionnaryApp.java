package ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.interfaces.TranslatorServiceRemote;

public class DictionnaryApp extends JFrame {

	private TranslatorServiceRemote remote = getProxy();

	private JPanel panel = new JPanel();
	private JLabel frenchLabel = new JLabel("french");
	private JLabel blankLabel = new JLabel("");
	private JLabel englishLabel = new JLabel("english");
	private JTextField frenchField = new JTextField();
	private JTextField englishField = new JTextField();

	private JButton translateButton = new JButton("translate");

	public DictionnaryApp() {

		setTitle("Dic");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
		pack();
	}

	private TranslatorServiceRemote getProxy() {
		Context ctx = null;
		TranslatorServiceRemote remote = null;
		try {
			ctx = new InitialContext();
			remote = (TranslatorServiceRemote) ctx
					.lookup("/ems/TranslatorService!services.interfaces.TranslatorServiceRemote");
		} catch (Exception e) {
		}
		return remote;
	}

	private void init() {

		panel.setLayout(new GridLayout(2, 3));
		panel.add(frenchLabel);
		panel.add(blankLabel);
		panel.add(englishLabel);
		panel.add(frenchField);
		panel.add(translateButton);
		panel.add(englishField);
		getContentPane().add(panel);
		translateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				englishField.setText(remote.translate(frenchField.getText()));
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DictionnaryApp();
			}
		});
	}

}
