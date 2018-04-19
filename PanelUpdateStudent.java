package protasewicz.piotr.panele;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Student;

public class PanelUpdateStudent extends JPanel implements ActionListener{
	private JButton btnUpdate;
	private JButton btnCancel;
	private JLabel lId;
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lRokStudiow;
	private JTextField tfId;
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfRokStudiow;
	
	private PanelStudent panelStudent;
	
	public PanelUpdateStudent(PanelStudent ps, Student s)
	{
		super(new GridLayout(6, 2, 5, 5));
		
		
		this.panelStudent = ps;
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		lId = new JLabel("ID");
		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lRokStudiow = new JLabel("ROK STUDIOW");
		tfId = new JTextField(10);
		tfId.setText(s.getId() + "");
		tfId.setEditable(false);
		tfImie = new JTextField(10);
		tfImie.setText(s.getImie());
		tfNazwisko = new JTextField(10);
		tfNazwisko.setText(s.getNazwisko());
		tfWiek = new JTextField(10);
		tfWiek.setText(s.getWiek()+"");
		tfRokStudiow = new JTextField(10);
		tfRokStudiow.setText(s.getRokStudiow() + "");
		
		add(lId);
		add(tfId);
		add(lImie);
		add(tfImie);
		add(lNazwisko);
		add(tfNazwisko);
		add(lWiek);
		add(tfWiek);
		add(lRokStudiow);
		add(tfRokStudiow);
		add(btnUpdate);
		add(btnCancel);
	}

	private Student pobierzDaneFormularzy()
	{
		if(tfImie == null || tfImie.getText().isEmpty()) //sprawdzam czy pole tekstowe nie jest czasem null i czy ma swobie jakakolwiek zawartosc
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE IMIE");
			return null; //nie ide dalej dopoki user nie wypelni wszystkich danych
		}
		
		if(tfNazwisko == null || tfNazwisko.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE NAZWISKO");
			return null; //nie ide dalej dopoki user nie wypelni wszystkich danych
		}
		
		if(tfRokStudiow == null || tfRokStudiow.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE ROK STUDIOW");
			return null; //nie ide dalej dopoki user nie wypelni wszystkich danych
		}
		
		if (tfWiek == null || tfWiek.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "WYPELNIJ POLE WIEK");
			return null; //nie ide dalej dopoki user nie wypelni wszystkich danych
		}
		
		//jak juz mam wstepna walidacje przeprowadzona to przystepuje do wstawiania danych
		int id = Integer.parseInt(tfId.getText());
		String imie = tfImie.getText();
		String nazwisko = tfNazwisko.getText();
		int wiek = Integer.parseInt(tfWiek.getText());
		int rokStudiow = Integer.parseInt(tfRokStudiow.getText());
		
		return new Student(id, imie, nazwisko, wiek, rokStudiow);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate)
		{
			BazaDanych.updateStudent(pobierzDaneFormularzy());
			panelStudent.fillAfterUpdate();
			JFrame okno = (JFrame)panelStudent.getRootPane().getParent();
			SwingUtilities.updateComponentTreeUI(okno);
			okno.repaint();
			//zaraz po wstawieniu trzeba zamknac okno od wstawiania zebys nie wstawial 10 razy tego samego
			//zeby zamknac okno trzeba odwolac sie do JFrame ktory przechowuje panel ktorego okno cchemy zamknac
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
