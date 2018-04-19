package protasewicz.piotr.panele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Student;
import javax.swing.JFrame;
public class PanelStudent extends JPanel implements ActionListener{
	
	private JButton btnLewy;
	private JButton btnPrawy;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	private JLabel lTytul;
	private Image lTapeta;
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lRokStudiow;
	private JTextField tfId;
	
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfRokStudiow;
	
	private List<Student> studenci;
	private int idx;
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }
	
	ImageIcon img = new ImageIcon("C:\\Users\\piciu_000\\Desktop\\arrow.png");
	

	public PanelStudent()
	{
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		btnLewy = new JButton("<<");
		btnLewy.addActionListener(this);
		btnPrawy = new JButton (">>");
		btnPrawy.addActionListener(this);
		btnInsert = new JButton ("Insert");
		btnInsert.addActionListener(this);
		btnDelete = new JButton ("Delete");
		btnDelete.addActionListener(this);
		btnUpdate = new JButton ("Update");
		btnUpdate.addActionListener(this);
		
		lTytul = new JLabel("STUDENT");
		lImie = new JLabel("Imie:");
		lNazwisko = new JLabel("Nazwisko:");
		lWiek = new JLabel("Wiek:");
		lRokStudiow = new JLabel("Rok studiow:");
		
		tfId = new JTextField(2);
		tfImie = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfWiek = new JTextField(10);
		tfRokStudiow = new JTextField(2);
		
		
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 20;
		gbc.fill = GridBagConstraints.CENTER;
		add(lTytul, gbc);
		lTytul.setFont(new Font("Garamond", Font.BOLD, 28 ));
		lTytul.setForeground(Color.BLACK);
	    
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 20;
		btnLewy.setBackground(Color.white );
	    add(btnLewy, gbc);
	    btnLewy.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 1;
        tfId.setEditable(false);
        tfId.setBackground(Color.white );
        add(tfId, gbc);
        tfId.setFont(new Font("Garamond", Font.BOLD, 20 ));
       
		gbc.gridx = 2;
		gbc.gridy = 1;
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
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    add(lNazwisko , gbc);
	    lNazwisko.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lNazwisko.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 4;
        tfNazwisko.setEditable(false);
        tfNazwisko.setBackground(Color.white );
        add(tfNazwisko, gbc);
        tfNazwisko.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    add (lWiek , gbc);
	    lWiek.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lWiek.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 5;
        tfWiek.setEditable(false);
        tfWiek.setBackground(Color.white );
        add(tfWiek, gbc);
        tfWiek.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    add(lRokStudiow , gbc);
	    lRokStudiow.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lRokStudiow.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 6;
        tfRokStudiow.setEditable(false);
        tfRokStudiow.setBackground(Color.white );
        add(tfRokStudiow, gbc);
        gbc.ipadx = 20;
        tfRokStudiow.setFont(new Font("Garamond", Font.BOLD, 20 ));
		
    
		gbc.gridx = 0;
		gbc.gridy = 8;
		btnInsert.setBackground(Color.white );
		gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnInsert, gbc);
	    btnInsert.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.gridx = 1;
		gbc.gridy = 8;
		 btnUpdate.setFont(new Font("Garamond", Font.BOLD, 20 ));
		btnUpdate.setBackground(Color.white );
	    gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnUpdate, gbc);
	   
	    
	    
		gbc.gridx = 2;
		gbc.gridy = 8;
		btnDelete.setBackground(Color.white );
		gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnDelete, gbc);
	    gbc.insets = new Insets(0, 0, 0, 50);
	    btnDelete.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		try {
			lTapeta = ImageIO.read(new File(("C:\\tapety\\tapeta.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
		studenci = BazaDanych.selectStudenci();
		idx = 0; //idx to zmienna ktora mowi ktory aktualnie element z listy studenci, ktora przechowuje dane z bazy ma byc wyswietlony
		fillTextFields();
	}

	
	public void fillAfterInsert()
	{
		studenci = BazaDanych.selectStudenci();
		idx = studenci.size() - 1; //ustawiam sie na ostatnim elemencie listy studentow ktora wczesniej 
		//zaktualizowalem pobierajac z bazy danych
		fillTextFields();
	}
	
	public void fillAfterUpdate()
	{
		studenci = BazaDanych.selectStudenci();
		fillTextFields();
	}
	
	private void fillTextFields()
	{
		if (studenci == null || studenci.isEmpty())
		{
			tfId.setText(""); //+ "" powoduje ze masz szybko przerobiona liczbe na napis
			tfImie.setText(""); //do pola tekstowego imie laduje zawartosc imienia elementu z listy studenci pod indeksem idx
			tfNazwisko.setText("");
			tfRokStudiow.setText("");
			tfWiek.setText("");
		}
		else
		{
			tfId.setText(studenci.get(idx).getId() + ""); //+ "" powoduje ze masz szybko przerobiona liczbe na napis
			tfImie.setText(studenci.get(idx).getImie()); //do pola tekstowego imie laduje zawartosc imienia elementu z listy studenci pod indeksem idx
			tfNazwisko.setText(studenci.get(idx).getNazwisko());
			tfRokStudiow.setText(studenci.get(idx).getRokStudiow() + "");
			tfWiek.setText(studenci.get(idx).getWiek() + "");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnLewy)
		{
			studenci = BazaDanych.selectStudenci();
			idx--;
			if (idx < 0)
			{
				idx = studenci.size()-1;
			}
			fillTextFields();
		}
		else if (source == btnPrawy)
		{
			studenci = BazaDanych.selectStudenci();
			idx++;
			if (idx >= studenci.size())
			{
				idx = 0;
			}
			fillTextFields();
		}
		else if (source == btnInsert)
		{
			JFrame frame = new JFrame("INSERT STUDENT");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //kiedy dasz DISPOSE podczas klikania w czerowny krzyzyk
			//zamknie sie tylko nowo otwarte okno a ni cala palikacja
			
			PanelInsertStudent panel = new PanelInsertStudent(this);
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			studenci = BazaDanych.selectStudenci();
		}
		else if (source == btnDelete)
		{
			BazaDanych.deleteStudent(studenci.get(idx).getId());
			studenci = BazaDanych.selectStudenci();
		}
		else if (source == btnUpdate)
		{
			JFrame frame = new JFrame("UPDATE STUDENT");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //kiedy dasz DISPOSE podczas klikania w czerowny krzyzyk
			//zamknie sie tylko nowo otwarte okno a ni cala palikacja
			
			Student s = new Student(
					Integer.parseInt(tfId.getText()), 
					tfImie.getText(), 
					tfNazwisko.getText(), 
					Integer.parseInt(tfWiek.getText()), 
					Integer.parseInt(tfRokStudiow.getText())
			);
			PanelUpdateStudent panel = new PanelUpdateStudent(this, s);
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			studenci = BazaDanych.selectStudenci();
		}
		
	}
	
	
}
