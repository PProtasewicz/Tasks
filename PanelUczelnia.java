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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Student;
import protasewicz.piotr.klasy.Uczelnia;


public class PanelUczelnia extends JPanel implements ActionListener {
	
	private JButton btnLewastrona;
	private JButton btnPrawastrona;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	private Image lTapeta;
	private JLabel lTytul;
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
	
	private List<Uczelnia> uczelnie;
	private int idx;
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }

	
	public PanelUczelnia()
	{
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		btnLewastrona = new JButton("<<");
		btnLewastrona.addActionListener(this);
		btnPrawastrona = new JButton(">>");
		btnPrawastrona.addActionListener(this);
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		
		lTytul = new JLabel("UCZELNIA");
		lNazwa = new JLabel("Nazwa:");
		lMiejscowosc = new JLabel("Miejscowosc:");
		lRokZalozenia = new JLabel("Rok zalozenia:");
		lAdres = new JLabel("Adres:");
		lMail = new JLabel("Mail:");
		lTelefon = new JLabel("Telefon:");
		
		tfId = new JTextField(8);
		tfNazwa = new JTextField(8);
		tfMiejscowosc = new JTextField(8);
		tfRokZalozenia = new JTextField(8);
		tfAdres = new JTextField(8);
		tfMail = new JTextField(8);
		tfTelefon = new JTextField(8);
		
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
		btnLewastrona.setBackground(Color.white );
		add(btnLewastrona, gbc);
		btnLewastrona.setFont(new Font("Garamond", Font.BOLD, 20 ));
		    
		gbc.gridx = 1;
		gbc.gridy = 1;
	    tfId.setEditable(false);
	    tfId.setBackground(Color.white );
	    add(tfId, gbc);
	    tfId.setFont(new Font("Garamond", Font.BOLD, 20 ));
	   
	    gbc.gridx = 2;
	    gbc.gridy = 1;
		add(btnPrawastrona, gbc);
		btnPrawastrona.setBackground(Color.white );
		btnPrawastrona.setFont(new Font("Garamond", Font.BOLD, 20 ));
	
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.CENTER;
		add (lNazwa , gbc);
		lNazwa.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNazwa.setForeground(Color.BLACK);
		
		gbc.gridx = 2;
	    gbc.gridy = 3;
	    tfNazwa.setEditable(false);
	    tfNazwa.setBackground(Color.white );
	    add(tfNazwa, gbc);
	    tfNazwa.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    add(lMiejscowosc , gbc);
	    lMiejscowosc.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lMiejscowosc.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 4;
        tfMiejscowosc.setEditable(false);
        tfMiejscowosc.setBackground(Color.white );
        add(tfMiejscowosc, gbc);
        tfMiejscowosc.setFont(new Font("Garamond", Font.BOLD, 20 ));
        
        gbc.gridx = 0;
	    gbc.gridy = 5;
	    add (lRokZalozenia , gbc);
	    lRokZalozenia.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lRokZalozenia.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 5;
        tfRokZalozenia.setEditable(false);
        tfRokZalozenia.setBackground(Color.white );
        add(tfRokZalozenia, gbc);
        tfRokZalozenia.setFont(new Font("Garamond", Font.BOLD, 20 ));
        
        gbc.gridx = 0;
	    gbc.gridy = 6;
	    add(lAdres, gbc);
	    lAdres.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lAdres.setForeground(Color.BLACK);
	    

	    gbc.gridx = 2;
	    gbc.gridy = 6;
        tfAdres.setEditable(false);
        tfAdres.setBackground(Color.white );
        add(tfAdres, gbc);
        gbc.ipadx = 20;
        tfAdres.setFont(new Font("Garamond", Font.BOLD, 20 ));
        
        gbc.gridx = 0;
	    gbc.gridy = 7;
	    add(lMail, gbc);
	    lMail.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lMail.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 7;
        tfMail.setEditable(false);
        tfMail.setBackground(Color.white );
        add(tfMail, gbc);
        gbc.ipadx = 20;
        tfMail.setFont(new Font("Garamond", Font.BOLD, 20 ));
        
        gbc.gridx = 0;
	    gbc.gridy = 8;
	    add(lTelefon, gbc);
	    lTelefon.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    lTelefon.setForeground(Color.BLACK);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 8;
        tfTelefon.setEditable(false);
        tfTelefon.setBackground(Color.white );
        add(tfTelefon, gbc);
        gbc.ipadx = 20;
        tfTelefon.setFont(new Font("Garamond", Font.BOLD, 20 ));
        
    	gbc.gridx = 0;
		gbc.gridy = 10;
		btnInsert.setBackground(Color.white );
		gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnInsert, gbc);
	    btnInsert.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
		gbc.gridx = 1;
		gbc.gridy = 10;
		btnUpdate.setBackground(Color.white );
	    gbc.anchor = GridBagConstraints.PAGE_END;
	    add(btnUpdate, gbc);
	    btnUpdate.setFont(new Font("Garamond", Font.BOLD, 20 ));
	    
	    
		gbc.gridx = 2;
		gbc.gridy = 10;
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
		    
		
		uczelnie = BazaDanych.selectUczelnie();
		idx = 0; 
		fillTextFields();
	}
	
	private void fillTextFields()
	{
		if(uczelnie == null || uczelnie.isEmpty())
		{
			tfId.setText("");
			tfNazwa.setText("");
			tfMiejscowosc.setText("");
			tfRokZalozenia.setText("");
			tfAdres.setText("");
			tfMail.setText("");
			tfTelefon.setText("");
		}
		else
		{
			tfId.setText(uczelnie.get(idx).getId() + "");
			tfNazwa.setText(uczelnie.get(idx).getNazwa());
			tfMiejscowosc.setText(uczelnie.get(idx).getMiejscowosc());
			tfRokZalozenia.setText(uczelnie.get(idx).getRokZalozenia() + "");
			tfAdres.setText(uczelnie.get(idx).getAdres());
			tfMail.setText(uczelnie.get(idx).getMail());
			tfTelefon.setText(uczelnie.get(idx).getTelefon() + "");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		Object source = a.getSource();
		if (source == btnLewastrona)
		{
			idx--;
			if (idx < 0)
			{
				idx = uczelnie.size()-1;
			}
			fillTextFields();
		}
		else if (source == btnPrawastrona)
		{
			idx++;
			if (idx >= uczelnie.size())
			{
				idx = 0;
			}
		    fillTextFields();
		}
		
		else if (source == btnInsert)
		{
			JFrame frame = new JFrame("INSERT UCZELNIA");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			PanelInsertUczelnia panel = new PanelInsertUczelnia();
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			uczelnie = BazaDanych.selectUczelnie();
		}
		else if (source == btnDelete)
		{
			BazaDanych.deleteUczelnia(uczelnie.get(idx).getId());
			uczelnie = BazaDanych.selectUczelnie();
		}
		else if (source == btnUpdate)
		{
			JFrame frame = new JFrame("UPDATE UCZELNIA");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			
			PanelUpdateUczelnia panel = new PanelUpdateUczelnia(uczelnie.get(idx));
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			uczelnie = BazaDanych.selectUczelnie();	
	     }

	}
}


