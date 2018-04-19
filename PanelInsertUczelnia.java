package protasewicz.piotr.panele;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Uczelnia;


public class PanelInsertUczelnia extends JPanel implements ActionListener {
	
	private JButton btnInsert;
	private JButton btnCancel;
	private JLabel lNazwa;
	private JLabel lMiejscowosc;
	private JLabel lRokZalozenia;
	private JLabel lAdres;
	private JLabel lMail;
	private JLabel lTelefon;
	private JTextField tfId;
	private JTextField tfNazwa;
	private JTextField tfMiejscowosc;
	private JTextField tfRokZalozenia;
	private JTextField tfAdres;
	private JTextField tfMail;
	private JTextField tfTelefon;

	public PanelInsertUczelnia()
	{
		super(new GridLayout(7, 2, 5, 5));
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this);
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		
		lNazwa = new JLabel("NAZWA");
		lMiejscowosc = new JLabel("MIEJSCOWOSC");
		lRokZalozenia = new JLabel("ROK ZALOZENIA");
		lAdres = new JLabel("ADRES");
		lMail = new JLabel("MAIL");
		lTelefon = new JLabel("TELEFON");
		
		tfId = new JTextField(10);
		tfNazwa = new JTextField(10);
		tfMiejscowosc = new JTextField(10);
		tfRokZalozenia = new JTextField(10);
		tfAdres = new JTextField(10);
		tfMail = new JTextField(10);
		tfTelefon = new JTextField(10);
		
		add(lNazwa);
		add(tfNazwa);
		add(lMiejscowosc);
		add(tfMiejscowosc);
		add(lRokZalozenia);
		add(tfRokZalozenia);
		add(lAdres);
		add(tfAdres);
		add(lMail);
		add(tfMail);
		add(lTelefon);
		add(tfTelefon);
		add(btnInsert);
		add(btnCancel);
		
		
	}
	
	private Uczelnia pobierzDaneFormularzy()
	{
		if(tfNazwa == null || tfNazwa.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE NAZWA");
			return null;
		}
		
		if(tfMiejscowosc == null || tfMiejscowosc.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE MIEJSCOWOSC");
			return null;
		}
		
		if(tfRokZalozenia == null || tfRokZalozenia.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE ROK ZALOZENIA");
			return null;
		}
		
		if(tfAdres == null || tfAdres.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE ADRES");
			return null;
		}
		
		if(tfMail == null || tfMail.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE MAIL");
			return null;
		}
		
		if(tfTelefon == null || tfTelefon.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE TELEFON");
			return null;
		}
		
		String nazwa = tfNazwa.getText();
		String miejscowosc = tfMiejscowosc.getText();
		int rokZalozenia = Integer.parseInt(tfRokZalozenia.getText());
		String adres = tfAdres.getText();
		String mail = tfMail.getText();
		int telefon = Integer.parseInt(tfTelefon.getText());
		
		return new Uczelnia(0,nazwa,miejscowosc,rokZalozenia,adres,mail,telefon);
		
	}	
	@Override
	
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == btnInsert)
		{
			BazaDanych.insertUczelnia(pobierzDaneFormularzy());
			JFrame fr = (JFrame)(getRootPane().getParent());
			fr.dispose();
		}
		else if (a.getSource() == btnCancel)
		{
			JFrame fr = (JFrame)(getRootPane().getParent());
			fr.dispose();
		}
	}
	
}
