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

public class PanelInsertStudent extends JPanel implements ActionListener{
	private JButton btnInsert;
	private JButton btnCancel;
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
	
	public PanelInsertStudent(PanelStudent ps)
	{
		super(new GridLayout(5, 2, 5, 5));
		
		this.panelStudent = ps;
		//this.studenci = studenci;
		//this.panelStudent = panelStudent;
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this);
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		
		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lRokStudiow = new JLabel("ROK STUDIOW");
		tfId = new JTextField(10);
		tfImie = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfWiek = new JTextField(10);
		tfRokStudiow = new JTextField(10);
		
		add(lImie);
		add(tfImie);
		add(lNazwisko);
		add(tfNazwisko);
		add(lWiek);
		add(tfWiek);
		add(lRokStudiow);
		add(tfRokStudiow);
		add(btnInsert);
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
		String imie = tfImie.getText();
		String nazwisko = tfNazwisko.getText();
		int wiek = Integer.parseInt(tfWiek.getText());
		int rokStudiow = Integer.parseInt(tfRokStudiow.getText());
		
		return new Student(0, imie, nazwisko, wiek, rokStudiow);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert)
		{
			BazaDanych.insertStudent(pobierzDaneFormularzy());
			panelStudent.fillAfterInsert();
			//studenci = BazaDanych.selectStudenci();
			//SwingUtilities.updateComponentTreeUI(panelStudent.getRootPane().getParent());
			//panelStudent.updateUI(); //odswiezy, przerysuje na nowo panel
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
