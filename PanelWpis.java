package protasewicz.piotr.panele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Student;
import protasewicz.piotr.klasy.StudentUczelnia;
import protasewicz.piotr.klasy.Uczelnia;
import protasewicz.piotr.klasy.Wpis;
import protasewicz.piotr.modele.MyComboBoxModel;

public class PanelWpis extends JPanel implements ActionListener {

	private JTextField tfId;
	private JButton btnLewy;
	private JButton btnPrawy;
	private JButton btnInsert;
	private JButton btnDelete;

	// ------------------PANEL GORA STUDENT---------
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lRokStudiow;
	private JLabel lTytul;
	private Image lTapeta;

	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfRokStudiow;

	// ------------------PANEL GORA UCZELNIA---------
	private JLabel lNazwaUczelni;
	private JLabel lMiejscowosc;
	private JLabel lRokZalozenia;
	private JLabel lAdres;
	private JLabel lMail;
	private JLabel lTelefon;

	private JTextField tfNazwaUczelni;
	private JTextField tfMiejscowosc;
	private JTextField tfRokZalozenia;
	private JTextField tfAdres;
	private JTextField tfMail;
	private JTextField tfTelefon;

	// ------------------PANEL DOL STUDENT---------
	private JLabel lImie2;
	private JLabel lNazwisko2;
	private JLabel lWiek2;
	private JLabel lRokStudiow2;

	private JTextField tfImie2;
	private JTextField tfNazwisko2;
	private JTextField tfWiek2;
	private JTextField tfRokStudiow2;

	// ------------------PANEL DOL UCZELNIA---------
	private JLabel lNazwaUczelni2;
	private JLabel lMiejscowosc2;
	private JLabel lRokZalozenia2;
	private JLabel lAdres2;
	private JLabel lMail2;
	private JLabel lTelefon2;

	private JTextField tfNazwaUczelni2;
	private JTextField tfMiejscowosc2;
	private JTextField tfRokZalozenia2;
	private JTextField tfAdres2;
	private JTextField tfMail2;
	private JTextField tfTelefon2;

	// ------------------COMBOBOXY---------
	private JLabel lComboBoxStudent;
	private JLabel lComboBoxUczelnia;
	private JComboBox<Integer> cbIdStudenta;
	private JComboBox<Integer> cbIdUczelnia;
	private MyComboBoxModel modelComboboxStudent;
	private MyComboBoxModel modelComboboxUczelnia;

	// --------------LISTA NA DANE-------------
	private List<StudentUczelnia> studenciUczelnie;
	private int idx;
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }

	public PanelWpis() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		tfId = new JTextField(5);
		btnLewy = new JButton("<<");
		btnLewy.addActionListener(this);
		btnPrawy = new JButton(">>");
		btnPrawy.addActionListener(this);
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);

		lTytul = new JLabel ("WPIS");
		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lRokStudiow = new JLabel("ROK STUDIOW");

		tfImie = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfWiek = new JTextField(10);
		tfRokStudiow = new JTextField(10);

		lNazwaUczelni = new JLabel("NAZWA UCZELNI");
		lMiejscowosc = new JLabel("MIEJSCOWOSC");
		lRokZalozenia = new JLabel("ROK ZALOZENIA");
		lAdres = new JLabel("ADRES");
		lMail = new JLabel("MAIL");
		lTelefon = new JLabel("TELEFON");

		tfNazwaUczelni = new JTextField(10);
		tfMiejscowosc = new JTextField(10);
		tfRokZalozenia = new JTextField(10);
		tfAdres = new JTextField(10);
		tfMail = new JTextField(10);
		tfTelefon = new JTextField(10);

		// ======================================

		lImie2 = new JLabel("IMIE");
		lNazwisko2 = new JLabel("NAZWISKO");
		lWiek2 = new JLabel("WIEK");
		lRokStudiow2 = new JLabel("ROK STUDIOW");

		tfImie2 = new JTextField(10);
		tfNazwisko2 = new JTextField(10);
		tfWiek2 = new JTextField(10);
		tfRokStudiow2 = new JTextField(10);

		lNazwaUczelni2 = new JLabel("NAZWA UCZELNI");
		lMiejscowosc2 = new JLabel("MIEJSCOWOSC");
		lRokZalozenia2 = new JLabel("ROK ZALOZENIA");
		lAdres2 = new JLabel("ADRES");
		lMail2 = new JLabel("MAIL");
		lTelefon2 = new JLabel("TELEFON");

		tfNazwaUczelni2 = new JTextField(10);
		tfMiejscowosc2 = new JTextField(10);
		tfRokZalozenia2 = new JTextField(10);
		tfAdres2 = new JTextField(10);
		tfMail2 = new JTextField(10);
		tfTelefon2 = new JTextField(10);

		// =========================================
		lComboBoxStudent = new JLabel("ID STUDENT");
		lComboBoxUczelnia = new JLabel("ID UCZELNIA");
		modelComboboxStudent = new MyComboBoxModel(BazaDanych.selectIdsFromStudent());
		cbIdStudenta = new JComboBox<>(modelComboboxStudent);
		cbIdStudenta.addActionListener(this);
		cbIdUczelnia = new JComboBox<>();
		modelComboboxUczelnia = new MyComboBoxModel(BazaDanych.selectIdsFromUczelnia());
		cbIdUczelnia = new JComboBox<>(modelComboboxUczelnia);
		cbIdUczelnia.addActionListener(this);

		gbc.weighty = 0.1;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.ipadx = 20;
		gbc.fill = GridBagConstraints.CENTER;
		add(lTytul, gbc);
		lTytul.setFont(new Font("Garamond", Font.BOLD, 28 ));
		lTytul.setForeground(Color.BLACK);
			
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.ipadx = 20;
		btnLewy.setBackground(Color.white );
		add(btnLewy, gbc);
		btnLewy.setFont(new Font("Garamond", Font.BOLD, 20 ));
		    
		gbc.gridx = 3;
		gbc.gridy = 2;
	    tfId.setEditable(false);
	    tfId.setBackground(Color.white );
	    add(tfId, gbc);
	    tfId.setFont(new Font("Garamond", Font.BOLD, 20 ));
	   
	    gbc.gridx = 4;
	    gbc.gridy = 2;
		add(btnPrawy, gbc);
		btnPrawy.setBackground(Color.white );
		btnPrawy.setFont(new Font("Garamond", Font.BOLD, 20 ));
		
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lImie , gbc);
		lImie.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lImie.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 3;
	    tfImie.setEditable(false);
	    tfImie.setBackground(Color.white );
	    add(tfImie, gbc);
	    tfImie.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lNazwisko , gbc);
		lNazwisko.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNazwisko.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 4;
	    tfNazwisko.setEditable(false);
	    tfNazwisko.setBackground(Color.white );
	    add(tfNazwisko, gbc);
	    tfNazwisko.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 5;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lWiek , gbc);
		lWiek.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lWiek.setForeground(Color.BLACK);
	
		gbc.gridx = 2;
	    gbc.gridy = 5;
	    tfWiek.setEditable(false);
	    tfWiek.setBackground(Color.white );
	    add(tfWiek , gbc);
	    tfWiek.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 6;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lRokStudiow , gbc);
		lRokStudiow.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lRokStudiow.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 6;
	    tfRokStudiow.setEditable(false);
	    tfRokStudiow.setBackground(Color.white );
	    add(tfRokStudiow , gbc);
	    tfRokStudiow.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		add(lComboBoxStudent, gbc);
		lComboBoxStudent.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lComboBoxStudent.setForeground(Color.BLACK);
	    
	    gbc.weighty = 0.1;
		gbc.gridx = 2;
		gbc.gridy = 7;
		add(cbIdStudenta, gbc);
		
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 8;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lImie2 , gbc);
		lImie2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lImie2.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 8;
	    tfImie2.setEditable(false);
	    tfImie2.setBackground(Color.white );
	    add(tfImie2, gbc);
	    tfImie2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 9;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lNazwisko2 , gbc);
		lNazwisko2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNazwisko2.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 9;
	    tfNazwisko2.setEditable(false);
	    tfNazwisko2.setBackground(Color.white );
	    add(tfNazwisko2, gbc);
	    tfNazwisko2.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 10;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lWiek2 , gbc);
		lWiek2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lWiek2.setForeground(Color.BLACK);
	
		gbc.gridx = 2;
	    gbc.gridy = 10;
	    tfWiek2.setEditable(false);
	    tfWiek2.setBackground(Color.white );
	    add(tfWiek2 , gbc);
	    tfWiek2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 11;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lRokStudiow2 , gbc);
		lRokStudiow2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lRokStudiow2.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 11;
	    tfRokStudiow2.setEditable(false);
	    tfRokStudiow2.setBackground(Color.white );
	    add(tfRokStudiow2 , gbc);
	    tfRokStudiow2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	 // =========================================
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lNazwaUczelni , gbc);
		lNazwaUczelni.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNazwaUczelni.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 3;
	    tfNazwaUczelni.setEditable(false);
	    tfNazwaUczelni.setBackground(Color.white );
	    add(tfNazwaUczelni, gbc);
	    tfNazwaUczelni.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lMiejscowosc , gbc);
		lMiejscowosc.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lMiejscowosc.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 4;
	    tfMiejscowosc.setEditable(false);
	    tfMiejscowosc.setBackground(Color.white );
	    add(tfMiejscowosc, gbc);
	    tfMiejscowosc.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 5;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lRokZalozenia , gbc);
		lRokZalozenia.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lRokZalozenia.setForeground(Color.BLACK);
	
		gbc.gridx = 5;
	    gbc.gridy = 5;
	    tfRokZalozenia.setEditable(false);
	    tfRokZalozenia.setBackground(Color.white );
	    add(tfRokZalozenia , gbc);
	    tfRokZalozenia.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 6;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lAdres , gbc);
		lAdres.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lAdres.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 6;
	    tfAdres.setEditable(false);
	    tfAdres.setBackground(Color.white );
	    add(tfAdres , gbc);
	    tfAdres.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 7;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lMail , gbc);
		lMail.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lMail.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 7;
	    tfMail.setEditable(false);
	    tfMail.setBackground(Color.white );
	    add(tfMail , gbc);
	    tfMail.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 8;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lTelefon , gbc);
		lTelefon.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lTelefon.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 8;
	    tfTelefon.setEditable(false);
	    tfTelefon.setBackground(Color.white );
	    add(tfTelefon , gbc);
	    tfTelefon.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 9;
		add(lComboBoxUczelnia, gbc);
		lComboBoxUczelnia.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lComboBoxUczelnia.setForeground(Color.BLACK);
	    
	    gbc.weighty = 0.1;
		gbc.gridx = 5;
		gbc.gridy = 9;
		add(cbIdUczelnia, gbc);
		
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 10;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lNazwaUczelni2 , gbc);
		lNazwaUczelni2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNazwaUczelni2.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 10;
	    tfNazwaUczelni2.setEditable(false);
	    tfNazwaUczelni2.setBackground(Color.white );
	    add(tfNazwaUczelni2, gbc);
	    tfNazwaUczelni2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 11;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lMiejscowosc2 , gbc);
		lMiejscowosc2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lMiejscowosc2.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 11;
	    tfMiejscowosc2.setEditable(false);
	    tfMiejscowosc2.setBackground(Color.white );
	    add(tfMiejscowosc2, gbc);
	    tfMiejscowosc2.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 12;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lRokZalozenia2 , gbc);
		lRokZalozenia2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lRokZalozenia2.setForeground(Color.BLACK);
	
		gbc.gridx = 5;
	    gbc.gridy = 12;
	    tfRokZalozenia2.setEditable(false);
	    tfRokZalozenia2.setBackground(Color.white );
	    add(tfRokZalozenia2 , gbc);
	    tfRokZalozenia2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 13;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lAdres2 , gbc);
		lAdres2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lAdres2.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 13;
	    tfAdres2.setEditable(false);
	    tfAdres2.setBackground(Color.white );
	    add(tfAdres2 , gbc);
	    tfAdres2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 14;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lMail2 , gbc);
		lMail2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lMail2.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 14;
	    tfMail2.setEditable(false);
	    tfMail2.setBackground(Color.white );
	    add(tfMail2 , gbc);
	    tfMail2.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.weighty = 0.1;
		gbc.gridx = 4;
		gbc.gridy = 15;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lTelefon2 , gbc);
		lTelefon2.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lTelefon2.setForeground(Color.BLACK);
		
		gbc.gridx = 5;
	    gbc.gridy = 15;
	    tfTelefon2.setEditable(false);
	    tfTelefon2.setBackground(Color.white );
	    add(tfTelefon2 , gbc);
	    tfTelefon2.setFont(new Font("Garamond", Font.BOLD, 20 ));

	    gbc.gridx = 2;
		gbc.gridy = 16;
		btnInsert.setBackground(Color.white );
		gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnInsert, gbc);
	    btnInsert.setFont(new Font("Garamond", Font.BOLD, 20 ));
		
	    gbc.gridx = 4;
		gbc.gridy = 16;
		btnDelete.setBackground(Color.white );
		gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnDelete, gbc);
	    gbc.insets = new Insets(0, 0, 0, 50);
	    btnDelete.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    
	    studenciUczelnie = BazaDanych.selectInnerJoin();
		idx = 0;

		fillTextFieldsAboveCombobox();
		fillTextFieldsBelowCombobox();
		fillTextFieldsAboveCombobox2();
		fillTextFieldsBelowCombobox2();

		try {
			lTapeta = ImageIO.read(new File(("C:\\tapety\\tapeta.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillTextFieldsAboveCombobox() {
		if (studenciUczelnie != null && !studenciUczelnie.isEmpty()) {
			tfId.setText(studenciUczelnie.get(idx).getId() + "");
			tfImie.setText(studenciUczelnie.get(idx).getImie());
			tfNazwisko.setText(studenciUczelnie.get(idx).getNazwisko());
			tfWiek.setText(studenciUczelnie.get(idx).getWiek() + "");
			tfRokStudiow.setText(studenciUczelnie.get(idx).getRokStudiow() + "");
		}
		else
		{
			tfId.setText("");
			tfImie.setText("");
			tfNazwisko.setText("");
			tfWiek.setText("");
			tfRokStudiow.setText("");
		}
	}

	public void fillTextFieldsBelowCombobox() {
		// pobrac id z combobox ktore zostalo zaznaczone
		int id = (Integer) cbIdStudenta.getSelectedItem(); // pobieramy
															// zaznaczony
															// aktualnie w
															// combobbox numer

		// po pierwsze trzeba zlokalizowac w bazie studenta ktory ma id takie
		// jak pobrales z comboboxa
		Student s = BazaDanych.selectById(id);

		tfImie2.setText(s.getImie());
		tfNazwisko2.setText(s.getNazwisko());
		tfWiek2.setText(s.getWiek() + "");
		tfRokStudiow2.setText(s.getRokStudiow() + "");
	}

	private void fillTextFieldsAboveCombobox2() {
		if (studenciUczelnie != null && !studenciUczelnie.isEmpty()) {
			tfNazwaUczelni.setText(studenciUczelnie.get(idx).getNazwa());
			tfMiejscowosc.setText(studenciUczelnie.get(idx).getMiejscowosc());
			tfRokZalozenia.setText(studenciUczelnie.get(idx).getRokZalozenia() + "");
			tfAdres.setText(studenciUczelnie.get(idx).getAdres());
			tfMail.setText(studenciUczelnie.get(idx).getMail());
			tfTelefon.setText(studenciUczelnie.get(idx).getTelefon() + "");
		}
		else
		{
			tfNazwaUczelni.setText("");
			tfMiejscowosc.setText("");
			tfRokZalozenia.setText("");
			tfAdres.setText("");
			tfMail.setText("");
			tfTelefon.setText("");
		}
	}

	public void fillTextFieldsBelowCombobox2() {

		int id2 = (Integer) cbIdUczelnia.getSelectedItem();

		Uczelnia u = BazaDanych.selectById2(id2);

		tfNazwaUczelni2.setText(u.getNazwa());
		tfMiejscowosc2.setText(u.getMiejscowosc());
		tfRokZalozenia2.setText(u.getRokZalozenia() + "");
		tfAdres2.setText(u.getAdres());
		tfMail2.setText(u.getMail());
		tfTelefon2.setText(u.getTelefon() + "");
	}

	@Override
	public void actionPerformed(ActionEvent b) {

		if (cbIdUczelnia == b.getSource()) {
			fillTextFieldsBelowCombobox2();
		} else if (cbIdStudenta == b.getSource()) {
			fillTextFieldsBelowCombobox();
		} else if (btnLewy == b.getSource()) {
			idx--;
			if (idx < 0) {
				idx = studenciUczelnie.size() - 1;
			}
			fillTextFieldsAboveCombobox2();
			fillTextFieldsAboveCombobox();
		} else if (btnPrawy == b.getSource()) {
			idx++;
			if (idx >= studenciUczelnie.size()) {
				idx = 0;
			}
			fillTextFieldsAboveCombobox2();
			fillTextFieldsAboveCombobox();
		}
		else if (btnInsert == b.getSource())
		{
			//najpierw pobierz id z dwoch comboboxow
			int idS = (Integer)cbIdStudenta.getSelectedItem();
			int idU = (Integer)cbIdUczelnia.getSelectedItem();
			
			BazaDanych.insertWpis(new Wpis(0, idS, idU));
			
			//kiedy juz wstawiles do tabeli Wpis relacje to mozesz odswiezyc liste ktora przechowue efekty 
			//z inner joina
			studenciUczelnie = BazaDanych.selectInnerJoin();
			idx = studenciUczelnie.size()-1;
			fillTextFieldsAboveCombobox();
			fillTextFieldsAboveCombobox2();
		}
		else if (btnDelete == b.getSource())
		{
			//pobieramy id z samej gory spomiedzy strzalek bo dzieki temu id moge zidentyfikowac
			//ktory wpis z tabeli Wpis moge usunac
			if (!tfId.getText().isEmpty())
			{
				int id = Integer.parseInt(tfId.getText());
				if (idx > 0)
				{
					--idx; //pamiewtaj ze idx to numer elementu do wyswietlania z listy
				}
				BazaDanych.deleteWpis(id);
				studenciUczelnie = BazaDanych.selectInnerJoin();
				fillTextFieldsAboveCombobox();
				fillTextFieldsAboveCombobox2();
			}
		}

	}

}
