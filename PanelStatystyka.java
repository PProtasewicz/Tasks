package protasewicz.piotr.panele;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import protasewicz.piotr.bazadanych.BazaDanych;

public class PanelStatystyka extends JPanel {

	private JButton btnGeneruj;

	private JLabel lTytul;
	private JLabel lSredniWiekStudentow;
	private JLabel lNajstarszyStudent;
	private JLabel lNajmlodszyStudent;
	private JLabel lNajstarszaUczelnia;
	private JLabel lNajmlodszaUczelnia;
	private Image lTapeta;

	private JTextField tfSredniWiek;
	private JTextField tfNajstarszyStudent;
	private JTextField tfNajmlodszyStudent;
	private JTextField tfNajstarszaUczelnia;
	private JTextField tfNajmlodszaUczelnia;

	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }

	public PanelStatystyka() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		btnGeneruj = new JButton("Generuj");

		lTytul = new JLabel("STATYSTYKA");
		lSredniWiekStudentow = new JLabel("Sredni Wiek Studentow:");
		lNajstarszyStudent = new JLabel("Najstarszy Student:");
		lNajmlodszyStudent = new JLabel("Najmlodszy Student:");
		lNajstarszaUczelnia = new JLabel("Najstarsza Uczelnia:");
		lNajmlodszaUczelnia = new JLabel("Najmlodsza Uczelnia:");
	

		tfSredniWiek = new JTextField(5);
		tfNajstarszyStudent = new JTextField(15);
		tfNajmlodszyStudent = new JTextField(15);
		tfNajstarszaUczelnia = new JTextField(48);
		tfNajmlodszaUczelnia = new JTextField(48);

	
		
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 20;
		gbc.fill = GridBagConstraints.CENTER;
		add(lTytul, gbc);
		lTytul.setFont(new Font("Garamond", Font.BOLD, 28 ));
		lTytul.setForeground(Color.BLACK);

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 20;
		gbc.fill = GridBagConstraints.CENTER;
		add(lSredniWiekStudentow, gbc);
		lSredniWiekStudentow.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lSredniWiekStudentow.setForeground(Color.BLACK);

		gbc.gridx = 1;
		gbc.gridy = 1;
		tfSredniWiek.setEditable(false);
		tfSredniWiek.setBackground(Color.white);
		add(tfSredniWiek, gbc);
		tfSredniWiek.setFont(new Font("Garamond", Font.BOLD, 20 ));
		
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(lNajstarszyStudent, gbc);
		lNajstarszyStudent.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNajstarszyStudent.setForeground(Color.BLACK);

		gbc.gridx = 1;
		gbc.gridy = 2;
		tfNajstarszyStudent.setEditable(false);
		tfNajstarszyStudent.setBackground(Color.white);
		add(tfNajstarszyStudent, gbc);
		tfNajstarszyStudent.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lNajmlodszyStudent, gbc);
		lNajmlodszyStudent.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNajmlodszyStudent.setForeground(Color.BLACK);

		gbc.gridx = 1;
		gbc.gridy = 3;
		tfNajmlodszyStudent.setEditable(false);
		tfNajmlodszyStudent.setBackground(Color.white);
		add(tfNajmlodszyStudent, gbc);
		tfNajmlodszyStudent.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(lNajstarszaUczelnia, gbc);
		lNajstarszaUczelnia.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNajstarszaUczelnia.setForeground(Color.BLACK);
		

		gbc.gridx = 1;
		gbc.gridy = 4;
		tfNajstarszaUczelnia.setEditable(false);
		tfNajstarszaUczelnia.setBackground(Color.white);
		add(tfNajstarszaUczelnia, gbc);
		tfNajstarszaUczelnia.setFont(new Font("Garamond", Font.BOLD, 20 ));

		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(lNajmlodszaUczelnia, gbc);
		lNajmlodszaUczelnia.setFont(new Font("Garamond", Font.BOLD, 20 ));
		lNajmlodszaUczelnia.setForeground(Color.BLACK);

		gbc.gridx = 1;
		gbc.gridy = 5;
		tfNajmlodszaUczelnia.setEditable(false);
		tfNajmlodszaUczelnia.setBackground(Color.white);
		add(tfNajmlodszaUczelnia, gbc);
		tfNajmlodszaUczelnia.setFont(new Font("Garamond", Font.BOLD, 20 ));

		

		try {
			lTapeta = ImageIO.read(new File(("C:\\tapety\\tapeta.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generujStatystyka()
	{
		tfSredniWiek.setText(BazaDanych.sredniWiekStudentow() + "");
		tfNajmlodszaUczelnia.setText(BazaDanych.najmlodszaUczelnia() + "");
		tfNajstarszaUczelnia.setText(BazaDanych.najstarszaUczelnia() + "");
		tfNajstarszyStudent.setText(BazaDanych.najstarszyStudent() + "");
		tfNajmlodszyStudent.setText(BazaDanych.najmlodszyStudent() + "");
	}

}
