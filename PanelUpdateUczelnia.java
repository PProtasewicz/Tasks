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
import protasewicz.piotr.klasy.Student;
import protasewicz.piotr.klasy.Uczelnia;

public class PanelUpdateUczelnia extends JPanel implements ActionListener {
	
	private JButton btnUpdate;
	private JButton btnCancel;
	private JLabel lId;
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

	public PanelUpdateUczelnia(Uczelnia u)
	{
		super(new GridLayout(8, 2, 5, 5));
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		
		lId = new JLabel("ID");
		lNazwa = new JLabel("NAZWA");
		lMiejscowosc = new JLabel("MIEJSCOWOSC");
		lRokZalozenia = new JLabel("ROK ZALOZENIA");
		lAdres = new JLabel("ADRES");
		lMail = new JLabel("MAIL");
		lTelefon = new JLabel("TELEFON");
		
		tfId = new JTextField(10);
		tfId.setText(u.getId() + "");
		tfId.setEditable(false);
		tfNazwa = new JTextField(10);
		tfMiejscowosc = new JTextField(10);
		tfRokZalozenia = new JTextField(10);
		tfRokZalozenia.setText(u.getRokZalozenia()+"");
		tfAdres = new JTextField(10);
		tfMail = new JTextField(10);
		tfTelefon = new JTextField(10);
		tfTelefon.setText(u.getTelefon()+"");
		
		add(lId);
		add(tfId);
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
		add(btnUpdate);
		add(btnCancel);
		
		
	}
	
	private Uczelnia pobierzDaneFormularzy()
	{
		if(tfNazwa == null || tfNazwa.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE NAZWA");
		}
		
		if(tfMiejscowosc == null || tfMiejscowosc.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE MIEJSCOWOSC");
		}
		
		if(tfRokZalozenia == null || tfRokZalozenia.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE ROK ZALOZENIA");
		}
		
		if(tfAdres == null || tfAdres.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE ADRES");
		}
		
		if(tfMail == null || tfMail.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE MAIL");
		}
		
		if(tfTelefon == null || tfTelefon.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE TELEFON");
		}
		int id = Integer.parseInt(tfId.getText());
		String nazwa = tfNazwa.getText();
		String miejscowosc = tfMiejscowosc.getText();
		int rokZalozenia = Integer.parseInt(tfRokZalozenia.getText());
		String adres = tfAdres.getText();
		String mail = tfMail.getText();
		int telefon = Integer.parseInt(tfTelefon.getText());
		
		return new Uczelnia(id,nazwa,miejscowosc,rokZalozenia,adres,mail,telefon);
		
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate)
		{
			BazaDanych.updateUczelnia(pobierzDaneFormularzy());
			JFrame fr = (JFrame)(getRootPane().getParent());
			fr.dispose();
		}
		else if (e.getSource() == btnCancel)
		{
			JFrame fr = (JFrame)(getRootPane().getParent());
			fr.dispose();
		}
}
}
