package protasewicz.piotr.panele;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelGlowny extends JPanel implements ActionListener{
	//przelaczanie okienek polega na wprowadzeniu nowego layouta
	//CardLayout - specjlany layout do przelaczania pomiedzy panelami
	
	private PanelStudent panelStudent;
	private PanelUczelnia panelUczelnia;
	private PanelWpis panelWpis;
	private PanelStatystyka panelStatystyka;
	private PanelTabela panelTabela;
	private PanelLogowanie panelLogowanie;
	
	public PanelGlowny(boolean czyAdmin)
	{
		super(new CardLayout());
		panelStudent = new PanelStudent();
		panelUczelnia = new PanelUczelnia();
		panelWpis = new PanelWpis();
		panelStatystyka = new PanelStatystyka();
		panelTabela = new PanelTabela();
		panelLogowanie = new PanelLogowanie();
		
		//teraz do tego layoutu dodajesz kolejne panele
		add(panelStudent, "STUDENT");
		add(panelUczelnia, "UCZELNIA");
		if (czyAdmin)
		{
			add(panelWpis, "WPIS");
		}
		add(panelStatystyka, "STATYSTYKA");
		add(panelTabela , "TABELA");
		add(panelTabela , "LOGOWANIE");
	}
	
	public JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuOkna = new JMenu("OKNA");
		//musze menu item listenery skonfigurowac tak zeby program wiedziel o ich wcisnieciu nawet
		//jezeli nie ebde mogl sie do tych itemow odwolac bezposrednio w action performed
		JMenuItem menuItemStudent = new JMenuItem("STUDENT");
		menuItemStudent.addActionListener(this);
		menuItemStudent.setActionCommand("STUDENT");
		
		JMenuItem menuItemUczelnia = new JMenuItem("UCZELNIA");
		menuItemUczelnia.addActionListener(this);
		menuItemUczelnia.setActionCommand("UCZELNIA");
		
		JMenuItem menuItemWpis = new JMenuItem("WPIS");
		menuItemWpis.addActionListener(this);
		menuItemWpis.setActionCommand("WPIS");
		
		JMenuItem menuItemStatystyka = new JMenuItem("STATYSTYKA");
		menuItemStatystyka.addActionListener(this);
		menuItemStatystyka.setActionCommand("STATYSTYKA");
		
		JMenuItem menuItemTabela = new JMenuItem("TABELA");
		menuItemTabela.addActionListener(this);
		menuItemTabela.setActionCommand("TABELA");
		
		JMenuItem menuItemLogowanie = new JMenuItem("LOGOWANIE");
		menuItemTabela.addActionListener(this);
		menuItemTabela.setActionCommand("LOGOWANIE");
		
		menuOkna.add(menuItemStudent);
		menuOkna.add(menuItemUczelnia);
		menuOkna.add(menuItemWpis);
		menuOkna.add(menuItemStatystyka);
		menuOkna.add(menuItemTabela);
		menuOkna.add(menuItemLogowanie);
		menuBar.add(menuOkna);
		
		JMenu menuOpcje = new JMenu("OPCJE");
		JMenuItem menuItemCzcionkaRozmiar = new JMenuItem("ROZMIAR CZCIONKI");
		JMenuItem menuItemCzcionkaKolor = new JMenuItem("CZCIONKA KOLOR");
		menuOpcje.add(menuItemCzcionkaKolor);
		menuOpcje.add(menuItemCzcionkaRozmiar);
		menuBar.add(menuOpcje);
		
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("STUDENT"))
		{
			//1. pobierz layout ktory masz ustawiony w twoim - w naszym przypadku tym layoutem jest CardLayou
			//metoda getLayout zwraca obiekt Object i ten obiekt trzeba przerzutowac na CardLayout
		    //zebys mogl z niego normalnie korzystac
			CardLayout cardLayout = (CardLayout)getLayout();
			//2. wybrac panel ktory Cie interesuje
			//jako pierwszy argument dajesz this bo musisz poinformwoac w ktorym panelu chcesz ustawic kolejny przelaczany 
			//panel, jako drugi argument podajesz napis powiazany z danym panelem
			cardLayout.show(this, "STUDENT");
		}
		
		else if (e.getActionCommand().equals("UCZELNIA"))
		{
			CardLayout cardLayout = (CardLayout)getLayout();
			cardLayout.show(this, "UCZELNIA");
		}
		
		else if (e.getActionCommand().equals("WPIS"))
		{
			CardLayout cardLayout = (CardLayout)getLayout();
			cardLayout.show(this, "WPIS");
		}
		
		else if (e.getActionCommand().equals("STATYSTYKA"))
		{
			panelStatystyka.generujStatystyka();
			CardLayout cardLayout = (CardLayout)getLayout();
			cardLayout.show(this, "STATYSTYKA");
		}
		
		else if (e.getActionCommand().equals("TABELA"))
		{
			panelTabela.odswiezTabela();
			CardLayout cardLayout = (CardLayout)getLayout();
			cardLayout.show(this, "TABELA");
		}
		else if (e.getActionCommand().equals("LOGOWANIE"))
		{
			CardLayout cardLayout = (CardLayout)getLayout();
			cardLayout.show(this, "LOGOWANIE");
		}
		
	}

}
