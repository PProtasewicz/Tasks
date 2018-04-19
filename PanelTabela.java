package protasewicz.piotr.panele;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import protasewicz.piotr.bazadanych.BazaDanych;
import protasewicz.piotr.modele.MyComboBoxModel;
import protasewicz.piotr.modele.MyListModel;
import protasewicz.piotr.modele.MyTableModel;

public class PanelTabela extends JPanel implements ActionListener{
	
	private MyTableModel myTableModel;
	private JTable tabela;
	
	private MyListModel myListModelImiona;
	private JList<String> listaImiona;
	private MyListModel myListModelNazwiska;
	private JList<String> listaNazwiska;
	private MyListModel myListModelMiejscowosci;
	private JList<String> listaMiejscowosci;
	
	private JCheckBox cbImiona;
	private JCheckBox cbNazwiska;
	private JCheckBox cbMiejscowosc;
	private JCheckBox cbWiek;
	private JCheckBox cbRok;
	
	private JButton btnFilter;
	private JButton btnReset;
	
	private JLabel lodWiek;
	private JLabel lodRok;
	private JLabel ldoWiek;
	private JLabel ldoRok;
	private Image lTapeta;
	
	private MyComboBoxModel cbxWiek1Model;
	private MyComboBoxModel cbxWiek2Model;
	private MyComboBoxModel cbxRok1Model;
	private MyComboBoxModel cbxRok2Model;
	private JComboBox<Integer> cbxWiek1;
	private JComboBox<Integer> cbxWiek2;
	private JComboBox<Integer> cbxRok1;
	private JComboBox<Integer> cbxRok2;
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(lTapeta, 0, 0, getWidth(), getHeight(), this);
	        }
	
	
	
	public PanelTabela() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel panelTabela = new JPanel(new GridBagLayout());
		GridBagConstraints gbcTabela = new GridBagConstraints();
		
		
		myTableModel = new MyTableModel(BazaDanych.selectInnerJoin());
		tabela = new JTable(myTableModel);
		
		
		gbcTabela.gridx = 0;
		gbcTabela.gridy = 0;
		gbcTabela.ipadx = 400;
		panelTabela.add(new JScrollPane(tabela) ,gbcTabela);
		
		
		btnFilter = new JButton("FILTRUJ");
		btnFilter.addActionListener(this);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(this);
		
		myListModelImiona = new MyListModel(BazaDanych.selectImionaInnerJoin());
		listaImiona = new JList<>(myListModelImiona);
		listaImiona.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //bede mogl w liscie naraz zazanczyc kilka elementow
		
		myListModelNazwiska = new MyListModel(BazaDanych.selectNazwiskaInnerJoin());
		listaNazwiska = new JList<>(myListModelNazwiska);
		listaNazwiska.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		myListModelMiejscowosci = new MyListModel(BazaDanych.selectMiejscowosciInnerJoin());
		listaMiejscowosci = new JList<>(myListModelMiejscowosci);
		listaMiejscowosci.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		cbImiona = new JCheckBox("IMIONA");
		cbNazwiska = new JCheckBox("NAZWISKA");
		cbMiejscowosc = new JCheckBox("MIEJSCOWOSC");
		cbWiek = new JCheckBox("WIEK");
		cbRok = new JCheckBox("ROK");
		
		cbxWiek1Model = new MyComboBoxModel(BazaDanych.selectWiekStudentowInnerJoin());
		cbxWiek1 = new JComboBox<>(cbxWiek1Model);
		cbxWiek2Model = new MyComboBoxModel(BazaDanych.selectWiekStudentowInnerJoin());
		cbxWiek2 = new JComboBox<>(cbxWiek2Model);
		cbxRok1Model = new MyComboBoxModel(BazaDanych.selectRokStudiowStudentowInnerJoin());
		cbxRok1 = new JComboBox<>(cbxRok1Model);
		cbxRok2Model = new MyComboBoxModel(BazaDanych.selectRokStudiowStudentowInnerJoin());
		cbxRok2 = new JComboBox<>(cbxRok2Model);
		
		lodWiek = new JLabel("OD");
		ldoWiek = new JLabel("DO");
		lodRok = new JLabel("OD");
		ldoRok = new JLabel("DO");
				
		
		JPanel panelParametry = new JPanel(new GridBagLayout());
		GridBagConstraints gbcParametry = new GridBagConstraints();
		
		JPanel panelPrzyciski = new JPanel(new GridBagLayout());
		GridBagConstraints gbcPrzyciski = new GridBagConstraints();
		
		
		gbcParametry.gridx = 0;
		gbcParametry.gridy = 0;
		panelParametry.add(cbImiona , gbcParametry);
		
		gbcParametry.gridx = 1;
		gbcParametry.gridy = 0;
		panelParametry.add(new JScrollPane(listaImiona) ,gbcParametry);
	    
	    gbcParametry.gridx = 2;
		gbcParametry.gridy = 0;
		panelParametry.add(cbNazwiska ,gbcParametry);
	    
	    gbcParametry.gridx = 3;
		gbcParametry.gridy = 0;
		panelParametry.add(new JScrollPane(listaNazwiska) ,gbcParametry);
	    
	    gbcParametry.gridx = 4;
		gbcParametry.gridy = 0;
		panelParametry.add(cbMiejscowosc ,gbcParametry);
		    
		gbcParametry.gridx = 5;
		gbcParametry.gridy = 0;
		panelParametry.add(new JScrollPane(listaMiejscowosci) ,gbcParametry);
		
		gbcParametry.gridx = 1;
		gbcParametry.gridy = 1;
		panelParametry.add(lodWiek ,gbcParametry);
		
		gbcParametry.gridx = 3;
		gbcParametry.gridy = 1;
		panelParametry.add(ldoWiek ,gbcParametry);
		
		gbcParametry.gridx = 1;
		gbcParametry.gridy = 2;
		panelParametry.add(lodRok ,gbcParametry);
		
		gbcParametry.gridx = 3;
		gbcParametry.gridy = 2;
		panelParametry.add(ldoRok ,gbcParametry);
		
		/*------------------ComboBox-------------------------------*/
		
		gbcParametry.gridx = 2;
		gbcParametry.gridy = 1;
		panelParametry.add(cbxWiek1 ,gbcParametry);
		
		gbcParametry.gridx = 2;
		gbcParametry.gridy = 2;
		panelParametry.add(cbxRok1 ,gbcParametry);
		
		gbcParametry.gridx = 4;
		gbcParametry.gridy = 1;
		panelParametry.add(cbxWiek2 ,gbcParametry);
		
		gbcParametry.gridx = 4;
		gbcParametry.gridy = 2;
		panelParametry.add(cbxRok2 ,gbcParametry);
		
		/*---------------------Checkbox-----------------------------------*/
		
		gbcParametry.gridx = 0;
		gbcParametry.gridy = 1;
		panelParametry.add(cbWiek ,gbcParametry);
		
		gbcParametry.gridx = 0;
		gbcParametry.gridy = 2;
		panelParametry.add(cbRok ,gbcParametry);
	    
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(panelTabela, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(panelParametry, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(panelPrzyciski, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPrzyciski.add(btnFilter, gbcPrzyciski);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelPrzyciski.add(btnReset, gbcPrzyciski);
		
		
		try {
			lTapeta = ImageIO.read(new File(("C:\\tapety\\tapeta.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void odswiezTabela()
	{
		myTableModel.update(BazaDanych.selectInnerJoin());
		tabela.updateUI();
		
		myListModelImiona.update(BazaDanych.selectImionaInnerJoin());
		myListModelNazwiska.update(BazaDanych.selectNazwiskaInnerJoin());
		myListModelMiejscowosci.update(BazaDanych.selectMiejscowosciInnerJoin());
		cbxWiek1Model.update(BazaDanych.selectWiekStudentowInnerJoin());
		cbxWiek2Model.update(BazaDanych.selectWiekStudentowInnerJoin());
		cbxRok1Model.update(BazaDanych.selectRokStudiowStudentowInnerJoin());
		cbxRok2Model.update(BazaDanych.selectRokStudiowStudentowInnerJoin());
		
		listaImiona.updateUI();
		listaNazwiska.updateUI();
		listaMiejscowosci.updateUI();
		cbxWiek1.updateUI();
		cbxWiek2.updateUI();
		cbxRok1.updateUI();
		cbxRok2.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnFilter == e.getSource())
		{
			List<String> imiona = listaImiona.getSelectedValuesList();
			List<String> nazwiska = listaNazwiska.getSelectedValuesList();
			List<String> miejscowosci = listaMiejscowosci.getSelectedValuesList();
			
			System.out.println(imiona);
			System.out.println(nazwiska);
			System.out.println(miejscowosci);
			
			int wiekOd = (Integer)cbxWiek1.getSelectedItem();
			int wiekDo = (Integer)cbxWiek2.getSelectedItem();
			int rokOd = (Integer)cbxRok1.getSelectedItem();
			int rokDo = (Integer)cbxRok2.getSelectedItem();
			
			myTableModel.update(
					BazaDanych.filtrowanie(
							cbImiona.isSelected(), cbNazwiska.isSelected(), cbMiejscowosc.isSelected(), cbWiek.isSelected(), cbRok.isSelected(), 
							imiona, nazwiska, miejscowosci, wiekOd, wiekDo, rokOd, rokDo));
			tabela.updateUI();
		}
		else if (btnReset == e.getSource())
		{
			myTableModel.update(BazaDanych.selectInnerJoin());
			tabela.updateUI();
		}
		
	}

}
