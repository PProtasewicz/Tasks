package protasewicz.piotr.main;

import java.awt.Dimension;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.klasy.Student;
import protasewicz.piotr.klasy.StudentUczelnia;
import protasewicz.piotr.klasy.Uczelnia;
import protasewicz.piotr.klasy.Wpis;
import protasewicz.piotr.panele.PanelGlowny;
import protasewicz.piotr.panele.PanelLogowanie;
import protasewicz.piotr.panele.PanelStudent;
import protasewicz.piotr.panele.PanelTabela;

public class Main {
	
	public static void createAndShowGui()
	{
		JFrame frame = new JFrame("PIERWSZE OKNO");
		JFrame horizontalFrame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//PanelStudent panel = new PanelStudent();
		//PanelUczelnia panel = new PanelUczelnia();
		//PanelWpis panel = new PanelWpis();
		//PanelGlowny panel = new PanelGlowny();
		PanelLogowanie panel = new PanelLogowanie();
		panel.setVisible(true);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) {
		
		//komunikacje z baza danych muisz nawiazac zanim okno ruszy
		BazaDanych.connect();
		BazaDanych.createTables();
		/*BazaDanych.insertWpis(new Wpis(0, 8, 2));
		BazaDanych.insertWpis(new Wpis(0, 9, 24));
		BazaDanych.insertWpis(new Wpis(0, 9, 3));
		BazaDanych.insertWpis(new Wpis(0, 8, 6));*/
		
		System.out.println(BazaDanych.sredniWiekStudentow());
		System.out.println(BazaDanych.najstarszyStudent());
	
		//metoda ktora przygotowalismy wyzej umieszczona jest w specjlanym procesie, ktory po otwarciu
		//okna czeka na wszelkie zdarzenia, ktore sie w nim moga wykonac i zarzadza ich obsluga
		///takie zdarzenia to np. klikniecie myszka w obszarze okna, klikniecie przyciskiem na panelu itd.
		
		 javax.swing.SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run()
					{
						createAndShowGui();
					}
				}
		);
		
		
		

	}

}
