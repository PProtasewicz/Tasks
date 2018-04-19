package protasewicz.piotr.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Login;
import protasewicz.piotr.klasy.Student;

public class PanelLogowanie extends JPanel implements ActionListener {
	
	private JButton btnLogin;
	private JButton btnCancel;
	private JButton btnRejestruj;
	
	private JLabel lUser;
	private JLabel lPassword;
	private JLabel lConfirm;
	private Image lTapeta;
	
	private JPasswordField pfPassword;
	private JPasswordField pfConfirm;
	
	private JTextField tfUser;
	
	private List<Login> login;
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }
	
public PanelLogowanie() {
	
	super(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();

	btnLogin = new JButton("LOGIN");
	btnLogin.addActionListener(this);
	btnCancel = new JButton("CANCEL");
	btnCancel.addActionListener(this);
	btnRejestruj = new JButton("REJESTRUJ");
	btnRejestruj.addActionListener(this);
	
	lUser = new JLabel("USER");
	lConfirm = new JLabel("CONFIRM");
	lPassword = new JLabel("PASSWORD");
	
	pfPassword = new JPasswordField(10);
	pfConfirm = new JPasswordField(10);
	
	tfUser = new JTextField(10);
	
	
	gbc.weighty = 0.1;
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.ipadx = 20;
	add(lUser, gbc);
	lUser.setFont(new Font("Garamond", Font.BOLD, 20 ));
	lUser.setForeground(Color.WHITE);
	
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.ipadx = 20;
	add(tfUser, gbc);
	tfUser.setFont(new Font("Garamond", Font.BOLD, 20 ));
	tfUser.setForeground(Color.BLACK);
	
	gbc.weighty = 0.1;
	gbc.gridx = 0;
	gbc.gridy = 2;
	add(lPassword, gbc);
	lPassword.setFont(new Font("Garamond", Font.BOLD, 20 ));
	lPassword.setForeground(Color.WHITE);
	
	gbc.weighty = 0.1;
	gbc.gridx = 1;
	gbc.gridy = 2;
	add(pfPassword, gbc);
	pfPassword.setFont(new Font("Garamond", Font.BOLD, 20 ));
	pfPassword.setForeground(Color.BLACK);
	
	gbc.weighty = 0.1;
	gbc.gridx = 0;
	gbc.gridy = 3;
	add(lConfirm, gbc);
	lConfirm.setFont(new Font("Garamond", Font.BOLD, 20 ));
	lConfirm.setForeground(Color.WHITE);
	
	gbc.gridx = 1;
	gbc.gridy = 3;
	add(pfConfirm, gbc);
	pfConfirm.setFont(new Font("Garamond", Font.BOLD, 20 ));
	pfConfirm.setForeground(Color.BLACK);
	
	gbc.weighty = 0.1;
	gbc.gridx = 0;
	gbc.gridy = 4;
	add(btnLogin, gbc);
	btnLogin.setFont(new Font("Garamond", Font.BOLD, 20 ));
	btnLogin.setForeground(Color.BLACK);
	
	gbc.weighty = 0.1;
	gbc.gridx = 1;
	gbc.gridy = 4;
	add(btnCancel, gbc);
	btnCancel.setFont(new Font("Garamond", Font.BOLD, 20 ));
	btnCancel.setForeground(Color.BLACK);
	
	gbc.weighty = 0.1;
	gbc.gridx = 2;
	gbc.gridy = 4;
	add(btnRejestruj, gbc);
	btnRejestruj.setFont(new Font("Garamond", Font.BOLD, 20 ));
	btnRejestruj.setForeground(Color.BLACK);
	
	try {
		lTapeta = ImageIO.read(new File(("C:\\tapety\\logowanie.jpg")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void createWindow(boolean czyAdmin)
{
	JFrame frame = new JFrame("PIERWSZE OKNO");
	JFrame horizontalFrame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	PanelGlowny panel = new PanelGlowny(czyAdmin);
	panel.setVisible(true);
	frame.setContentPane(panel);
	frame.setVisible(true);
	frame.setJMenuBar(panel.createMenuBar());
	frame.setResizable(true);
	frame.setLocationRelativeTo(null);
	frame.setSize(new Dimension(1200, 800));
	frame.setLocation(200, 200);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(btnLogin == e.getSource())
	{
		String user = tfUser.getText();
		String pass = String.valueOf(pfPassword.getPassword());
		String confirm = String.valueOf(pfConfirm.getPassword());
		
		if (pass.equals(confirm))
		{
			List<Login> login = BazaDanych.selectLogowanie();
			boolean czyZalogowany = false;
			boolean czyAdmin = false;
			for (Login l : login)
			{
				if (l.getUser().equals(user) && l.getPassword().equals(pass))
				{
					czyZalogowany = true;
					if (l.getRola().equals("ADMIN"))
					{
						czyAdmin = true;
					}
					break;
				}
			}
			if(czyZalogowany)
			{
				createWindow(czyAdmin);
				JFrame frame = (JFrame)getRootPane().getParent();
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "B£¥D LOGOWANIA");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "B£¥D HAS£A");
		}
 	}	
	else if (btnCancel == e.getSource())
	{
		JFrame frame = (JFrame)getRootPane().getParent();
		frame.dispose();
	}
	else if (btnRejestruj == e.getSource())
	{
		String user = tfUser.getText();
		String pass = String.valueOf(pfPassword.getPassword());
		String confirm = String.valueOf(pfConfirm.getPassword());
		
		if(!user.isEmpty() && !pass.isEmpty() && pass.equals(confirm))
		{
			//dla uproszczenia w konsoli bedziemy pytac o role
			Scanner sc = new Scanner(System.in);
			System.out.println("Podaj role: ADMIN / USER");
			String rola = sc.nextLine();
			while(!rola.equals("ADMIN") && !rola.equals("USER"))
			{
				System.out.println("Podaj role: ADMIN / USER");
				rola = sc.nextLine();
			}
			
			BazaDanych.rejestrujLogowanie(new Login(1,user, pass, rola));
			JOptionPane.showMessageDialog(null, "POPRAWNIE ZAREJESTROWANO U¯YTKOWNIKA");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "BLAD HAS£A LUB PUSTE POLA");
		}
	}
	
	
}
}
