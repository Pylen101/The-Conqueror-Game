package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.*;
import exceptions.*;
import buildings.*;
import units.*;
import view.*;

public class Controller implements ActionListener{
	private View view;
	private Game model;
	private WorldMapView worldMap;
	private JTextField nameField;
	private JComboBox cities;
	private JButton confirmButton;
	
	private CityViewCairo cityViewCairo;
	private CityViewRome cityViewRome;
	private CityViewSparta cityViewSparta;
	
	private JButton cairo;
	private JButton sparta;
	private JButton rome;
	
	private City cairoCity;
	private City romeCity;
	private City spartaCity;
	
	private JComboBox idleArmies;
	private JComboBox marchingArmies;
	private JComboBox besiegingArmies;
	
	
	private JButton exitCityCairo;
	private JButton buildFarmCairo;
	private JButton buildMarketCairo;
	private JButton buildArcheryRangeCairo;
	private JButton buildBarracksCairo;
	private JButton buildStableCairo;
	
	private JButton upgradeFarmCairo;
	private JButton upgradeMarketCairo;
	private JButton upgradeArcheryRangeCairo;
	private JButton upgradeBarracksCairo;
	private JButton upgradeStableCairo;
	
	private JButton recruitArcherCairo;
	private JButton recruitInfantryCairo;
	private JButton recruitCavalryCairo;
	private JComboBox armiesInsideCairo;
	private JComboBox defendingArmyUnitsCairo;
	
	private JButton exitCityRome;
	private JButton buildFarmRome;
	private JButton buildMarketRome;
	private JButton buildArcheryRangeRome;
	private JButton buildBarracksRome;
	private JButton buildStableRome;
	
	private JButton upgradeFarmRome;
	private JButton upgradeMarketRome;
	private JButton upgradeArcheryRangeRome;
	private JButton upgradeBarracksRome;
	private JButton upgradeStableRome;
	
	private JButton recruitArcherRome;
	private JButton recruitInfantryRome;
	private JButton recruitCavalryRome;
	private JComboBox armiesInsideRome;
	private JComboBox defendingArmyUnitsRome;
	
	private JButton exitCitySparta;
	private JButton buildFarmSparta;
	private JButton buildMarketSparta;
	private JButton buildArcheryRangeSparta;
	private JButton buildBarracksSparta;
	private JButton buildStableSparta;
	
	private JButton upgradeFarmSparta;
	private JButton upgradeMarketSparta;
	private JButton upgradeArcheryRangeSparta;
	private JButton upgradeBarracksSparta;
	private JButton upgradeStableSparta;
	
	private JButton recruitArcherSparta;
	private JButton recruitInfantrySparta;
	private JButton recruitCavalrySparta;
	private JComboBox armiesInsideSparta;
	private JComboBox defendingArmyUnitsSparta;
	
	
	private GameOverView gameOverView;
	private JButton endTurn;
	
	public Controller() {
		view = new View();
		JPanel startPanel = view.getStartPanel();
		
		String[] startingCities = {"Cairo","Rome","Sparta"};
		cities = new JComboBox(startingCities);
		cities.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,30));
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Enter Player Name");
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,30)); //set font of text
		
		JLabel cityLabel = new JLabel();
		cityLabel.setText("Select Your Starting City");
		cityLabel.setVerticalAlignment(JLabel.CENTER);
		cityLabel.setHorizontalAlignment(JLabel.CENTER);
		cityLabel.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,30)); //set font of text

		
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(200,30));
		nameField.setFont(new Font("MV Boli",Font.ROMAN_BASELINE,30));
		nameField.setForeground(new Color(175,120,120));
		
		confirmButton = new JButton();
		confirmButton.addActionListener(this);
		confirmButton.setText("Confirm Your Selection and Name");
		confirmButton.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,30));
		
		startPanel.add(nameLabel);
		startPanel.add(nameField);
		startPanel.add(cityLabel);
		startPanel.add(cities);
		startPanel.add(confirmButton);
		
		//---------------------------------------------------------------------------------//
		
		worldMap = new WorldMapView();
		
		cairo = new JButton();
		cairo.addActionListener(this);
		cairo.setText("Cairo");
		cairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,10));
		sparta = new JButton();
		sparta.addActionListener(this);
		sparta.setText("Sparta");
		sparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,10));
		rome = new JButton();
		rome.addActionListener(this);
		rome.setText("Rome");
		rome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,10));
		
		//END TURN
		
		endTurn = new JButton();
		endTurn.addActionListener(this);
		endTurn.setText("End Turn");
		endTurn.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,10));
		
		idleArmies = new JComboBox();
		idleArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		idleArmies.setToolTipText("Idle Armies. Unit Format in (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		marchingArmies = new JComboBox();
		marchingArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		marchingArmies.setToolTipText("Marching Armies. Unit Format in  (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		besiegingArmies = new JComboBox();
		besiegingArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		besiegingArmies.setToolTipText("Mesieging Armies. Unit Format in  (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		worldMap.getIdleArmies().add(idleArmies);
		worldMap.getMarchingArmies().add(marchingArmies);
		worldMap.getBesiegingArmies().add(besiegingArmies);

		
		worldMap.getCityViewPanel().add(cairo);
		worldMap.getCityViewPanel().add(sparta);
		worldMap.getCityViewPanel().add(rome);
		worldMap.getEndTurnPanel().add(endTurn);

		
		//---------------------------------------------------//
		
		cityViewCairo = new CityViewCairo();
		
		exitCityCairo = new JButton();
		exitCityCairo.addActionListener(this);
		exitCityCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		exitCityCairo.setText("Exit View");
		//BUILDING CAIRO
		buildFarmCairo = new JButton();
		buildFarmCairo.addActionListener(this);
		buildFarmCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildFarmCairo.setText("Build Farm in Cairo");
		buildFarmCairo.setToolTipText("Cost: " + "1000");
		
		buildMarketCairo = new JButton();
		buildMarketCairo.addActionListener(this);
		buildMarketCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildMarketCairo.setText("Build Market in Cairo");
		buildMarketCairo.setToolTipText("Cost: " + "1500");
		
		buildArcheryRangeCairo = new JButton();
		buildArcheryRangeCairo.addActionListener(this);
		buildArcheryRangeCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildArcheryRangeCairo.setText("Build ArcheryRange in Cairo");
		buildArcheryRangeCairo.setToolTipText("Cost: " + "1500");
		
		buildBarracksCairo = new JButton();
		buildBarracksCairo.addActionListener(this);
		buildBarracksCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildBarracksCairo.setText("Build Barracks in Cairo");
		buildBarracksCairo.setToolTipText("Cost: " + "2000");
		
		buildStableCairo = new JButton();
		buildStableCairo.addActionListener(this);
		buildStableCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildStableCairo.setText("Build Stable in Cairo");
		buildStableCairo.setToolTipText("Cost: " + "2500");
		//UPGRADING CAIRO
		upgradeFarmCairo = new JButton();
		upgradeFarmCairo.addActionListener(this);
		upgradeFarmCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeFarmCairo.setText("Upgrade Farm in Cairo");
		
		upgradeMarketCairo = new JButton();
		upgradeMarketCairo.addActionListener(this);
		upgradeMarketCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeMarketCairo.setText("Upgrade Market in Cairo");
		
		upgradeArcheryRangeCairo = new JButton();
		upgradeArcheryRangeCairo.addActionListener(this);
		upgradeArcheryRangeCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeArcheryRangeCairo.setText("Upgrade ArcheryRange in Cairo");
		
		upgradeBarracksCairo = new JButton();
		upgradeBarracksCairo.addActionListener(this);
		upgradeBarracksCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeBarracksCairo.setText("Upgrade Barracks in Cairo");
		
		upgradeStableCairo = new JButton();
		upgradeStableCairo.addActionListener(this);
		upgradeStableCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeStableCairo.setText("Upgrade Stable in Cairo");
		//RECRUITING CAIRO
		recruitArcherCairo = new JButton();
		recruitArcherCairo.addActionListener(this);
		recruitArcherCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitArcherCairo.setText("Recruit Archer in Cairo");
		recruitArcherCairo.setToolTipText("Recruitment Cost: " + "400");
		
		recruitInfantryCairo = new JButton();
		recruitInfantryCairo.addActionListener(this);
		recruitInfantryCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitInfantryCairo.setText("Recruit Infantry in Cairo");
		recruitInfantryCairo.setToolTipText("Recruitment Cost: " + "500");
		
		recruitCavalryCairo = new JButton();
		recruitCavalryCairo.addActionListener(this);
		recruitCavalryCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitCavalryCairo.setText("Recruit Cavalry in Cairo");
		recruitCavalryCairo.setToolTipText("Recruitment Cost: " + "600");
		//ARMIES IN CAIRO
		defendingArmyUnitsCairo = new JComboBox();
		defendingArmyUnitsCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		defendingArmyUnitsCairo.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		armiesInsideCairo = new JComboBox();
		armiesInsideCairo.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		armiesInsideCairo.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		cityViewCairo.getClose().add(exitCityCairo);
		cityViewCairo.getFarm().add(buildFarmCairo);
		cityViewCairo.getFarm().add(upgradeFarmCairo);
		cityViewCairo.getMarket().add(buildMarketCairo);
		cityViewCairo.getMarket().add(upgradeMarketCairo);
		cityViewCairo.getArcheryRange().add(buildArcheryRangeCairo);
		cityViewCairo.getArcheryRange().add(upgradeArcheryRangeCairo);
		cityViewCairo.getArcheryRange().add(recruitArcherCairo);
		cityViewCairo.getBarracks().add(buildBarracksCairo);
		cityViewCairo.getBarracks().add(upgradeBarracksCairo);
		cityViewCairo.getBarracks().add(recruitInfantryCairo);
		cityViewCairo.getStable().add(buildStableCairo);
		cityViewCairo.getStable().add(upgradeStableCairo);
		cityViewCairo.getStable().add(recruitCavalryCairo);
		cityViewCairo.getDefendingArmyPanel().add(defendingArmyUnitsCairo);
		cityViewCairo.getDefendingArmyPanel().add(armiesInsideCairo);
		
		//-----------------------------------------------------------ROME------------------------------//
		cityViewRome = new CityViewRome();
		
		exitCityRome = new JButton();
		exitCityRome.addActionListener(this);
		exitCityRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		exitCityRome.setText("Exit View");
		//BUILDING CAIRO
		buildFarmRome = new JButton();
		buildFarmRome.addActionListener(this);
		buildFarmRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildFarmRome.setText("Build Farm in Rome");
		buildFarmRome.setToolTipText("Cost: " + "1000");
		
		buildMarketRome = new JButton();
		buildMarketRome.addActionListener(this);
		buildMarketRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildMarketRome.setText("Build Market in Rome");
		buildMarketRome.setToolTipText("Cost: " + "1500");
		
		buildArcheryRangeRome = new JButton();
		buildArcheryRangeRome.addActionListener(this);
		buildArcheryRangeRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildArcheryRangeRome.setText("Build ArcheryRange in Rome");
		buildArcheryRangeRome.setToolTipText("Cost: " + "1500");
		
		buildBarracksRome = new JButton();
		buildBarracksRome.addActionListener(this);
		buildBarracksRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildBarracksRome.setText("Build Barracks in Rome");
		buildBarracksRome.setToolTipText("Cost: " + "2000");
		
		buildStableRome = new JButton();
		buildStableRome.addActionListener(this);
		buildStableRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildStableRome.setText("Build Stable in Rome");
		buildStableRome.setToolTipText("Cost: " + "2500");
		//UPGRADING CAIRO
		upgradeFarmRome = new JButton();
		upgradeFarmRome.addActionListener(this);
		upgradeFarmRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeFarmRome.setText("Upgrade Farm in Rome");
		
		upgradeMarketRome = new JButton();
		upgradeMarketRome.addActionListener(this);
		upgradeMarketRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeMarketRome.setText("Upgrade Market in Rome");
		
		upgradeArcheryRangeRome = new JButton();
		upgradeArcheryRangeRome.addActionListener(this);
		upgradeArcheryRangeRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeArcheryRangeRome.setText("Upgrade ArcheryRange in Rome");
		
		upgradeBarracksRome = new JButton();
		upgradeBarracksRome.addActionListener(this);
		upgradeBarracksRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeBarracksRome.setText("Upgrade Barracks in Rome");
		
		upgradeStableRome = new JButton();
		upgradeStableRome.addActionListener(this);
		upgradeStableRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeStableRome.setText("Upgrade Stable in Rome");
		//RECRUITING CAIRO
		recruitArcherRome = new JButton();
		recruitArcherRome.addActionListener(this);
		recruitArcherRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitArcherRome.setText("Recruit Archer in Rome");
		recruitArcherRome.setToolTipText("Recruitment Cost: " + "400");
		
		recruitInfantryRome = new JButton();
		recruitInfantryRome.addActionListener(this);
		recruitInfantryRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitInfantryRome.setText("Recruit Infantry in Rome");
		recruitInfantryRome.setToolTipText("Recruitment Cost: " + "500");
		
		recruitCavalryRome = new JButton();
		recruitCavalryRome.addActionListener(this);
		recruitCavalryRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitCavalryRome.setText("Recruit Cavalry in Rome");
		recruitCavalryRome.setToolTipText("Recruitment Cost: " + "600");
		//ARMIES IN CAIRO
		defendingArmyUnitsRome = new JComboBox();
		defendingArmyUnitsRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		defendingArmyUnitsRome.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		armiesInsideRome = new JComboBox();
		armiesInsideRome.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		armiesInsideRome.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		cityViewRome.getClose().add(exitCityRome);
		cityViewRome.getFarm().add(buildFarmRome);
		cityViewRome.getFarm().add(upgradeFarmRome);
		cityViewRome.getMarket().add(buildMarketRome);
		cityViewRome.getMarket().add(upgradeMarketRome);
		cityViewRome.getArcheryRange().add(buildArcheryRangeRome);
		cityViewRome.getArcheryRange().add(upgradeArcheryRangeRome);
		cityViewRome.getArcheryRange().add(recruitArcherRome);
		cityViewRome.getBarracks().add(buildBarracksRome);
		cityViewRome.getBarracks().add(upgradeBarracksRome);
		cityViewRome.getBarracks().add(recruitInfantryRome);
		cityViewRome.getStable().add(buildStableRome);
		cityViewRome.getStable().add(upgradeStableRome);
		cityViewRome.getStable().add(recruitCavalryRome);
		cityViewRome.getDefendingArmyPanel().add(defendingArmyUnitsRome);
		cityViewRome.getDefendingArmyPanel().add(armiesInsideRome);
		
		//-----------------------------------------------------------SPARTA------------------------------//
		
		cityViewSparta = new CityViewSparta();
		
		exitCitySparta = new JButton();
		exitCitySparta.addActionListener(this);
		exitCitySparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		exitCitySparta.setText("Exit View");
		//BUILDING CAIRO
		buildFarmSparta = new JButton();
		buildFarmSparta.addActionListener(this);
		buildFarmSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildFarmSparta.setText("Build Farm in Sparta");
		buildFarmSparta.setToolTipText("Cost: " + "1000");
		
		buildMarketSparta = new JButton();
		buildMarketSparta.addActionListener(this);
		buildMarketSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildMarketSparta.setText("Build Market in Sparta");
		buildMarketSparta.setToolTipText("Cost: " + "1500");
		
		buildArcheryRangeSparta = new JButton();
		buildArcheryRangeSparta.addActionListener(this);
		buildArcheryRangeSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildArcheryRangeSparta.setText("Build ArcheryRange in Sparta");
		buildArcheryRangeSparta.setToolTipText("Cost: " + "1500");
		
		buildBarracksSparta = new JButton();
		buildBarracksSparta.addActionListener(this);
		buildBarracksSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildBarracksSparta.setText("Build Barracks in Sparta");
		buildBarracksSparta.setToolTipText("Cost: " + "2000");
		
		buildStableSparta = new JButton();
		buildStableSparta.addActionListener(this);
		buildStableSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		buildStableSparta.setText("Build Stable in Sparta");
		buildStableSparta.setToolTipText("Cost: " + "2500");
		//UPGRADING CAIRO
		upgradeFarmSparta = new JButton();
		upgradeFarmSparta.addActionListener(this);
		upgradeFarmSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeFarmSparta.setText("Upgrade Farm in Sparta");
		
		upgradeMarketSparta = new JButton();
		upgradeMarketSparta.addActionListener(this);
		upgradeMarketSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeMarketSparta.setText("Upgrade Market in Sparta");
		
		upgradeArcheryRangeSparta = new JButton();
		upgradeArcheryRangeSparta.addActionListener(this);
		upgradeArcheryRangeSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeArcheryRangeSparta.setText("Upgrade ArcheryRange in Sparta");
		
		upgradeBarracksSparta = new JButton();
		upgradeBarracksSparta.addActionListener(this);
		upgradeBarracksSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeBarracksSparta.setText("Upgrade Barracks in Sparta");
		
		upgradeStableSparta = new JButton();
		upgradeStableSparta.addActionListener(this);
		upgradeStableSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		upgradeStableSparta.setText("Upgrade Stable in Sparta");
		//RECRUITING CAIRO
		recruitArcherSparta = new JButton();
		recruitArcherSparta.addActionListener(this);
		recruitArcherSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitArcherSparta.setText("Recruit Archer in Sparta");
		recruitArcherSparta.setToolTipText("Recruitment Cost: " + "400");
		
		recruitInfantrySparta = new JButton();
		recruitInfantrySparta.addActionListener(this);
		recruitInfantrySparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitInfantrySparta.setText("Recruit Infantry in Sparta");
		recruitInfantrySparta.setToolTipText("Recruitment Cost: " + "500");
		
		recruitCavalrySparta = new JButton();
		recruitCavalrySparta.addActionListener(this);
		recruitCavalrySparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,13));
		recruitCavalrySparta.setText("Recruit Cavalry in Sparta");
		recruitCavalrySparta.setToolTipText("Recruitment Cost: " + "600");
		//ARMIES IN CAIRO
		defendingArmyUnitsSparta = new JComboBox();
		defendingArmyUnitsSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		defendingArmyUnitsSparta.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		armiesInsideSparta = new JComboBox();
		armiesInsideSparta.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,15));
		armiesInsideSparta.setToolTipText("Unit details are in: (Unit Type, Level, current Soldier Count, Max Soldier Count)");
		
		cityViewSparta.getClose().add(exitCitySparta);
		cityViewSparta.getFarm().add(buildFarmSparta);
		cityViewSparta.getFarm().add(upgradeFarmSparta);
		cityViewSparta.getMarket().add(buildMarketSparta);
		cityViewSparta.getMarket().add(upgradeMarketSparta);
		cityViewSparta.getArcheryRange().add(buildArcheryRangeSparta);
		cityViewSparta.getArcheryRange().add(upgradeArcheryRangeSparta);
		cityViewSparta.getArcheryRange().add(recruitArcherSparta);
		cityViewSparta.getBarracks().add(buildBarracksSparta);
		cityViewSparta.getBarracks().add(upgradeBarracksSparta);
		cityViewSparta.getBarracks().add(recruitInfantrySparta);
		cityViewSparta.getStable().add(buildStableSparta);
		cityViewSparta.getStable().add(upgradeStableSparta);
		cityViewSparta.getStable().add(recruitCavalrySparta);
		cityViewSparta.getDefendingArmyPanel().add(defendingArmyUnitsSparta);
		cityViewSparta.getDefendingArmyPanel().add(armiesInsideSparta);
		
		gameOverView = new GameOverView();
		
		view.revalidate();
		view.repaint();
	}
	
	public static void main(String[] args) {
		new Controller();
	}

	public void getArmyDetailsIdle() { //UPDATES DATA OF IDLE ARMIES
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentStatus().equals(Status.IDLE)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		for(int i = 0; i< model.getPlayer().getControlledCities().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledCities().get(i).getDefendingArmy();
			if(currentArmy.getCurrentStatus().equals(Status.IDLE)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		idleArmies.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			idleArmies.addItem(i +"- " + x.get(i));
		}
	}
	public void getArmyDetailsMarching() { //UPDATES DATA OF MARCHING ARMIES
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentStatus().equals(Status.MARCHING)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		for(int i = 0; i< model.getPlayer().getControlledCities().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledCities().get(i).getDefendingArmy();
			if(currentArmy.getCurrentStatus().equals(Status.MARCHING)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		marchingArmies.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			marchingArmies.addItem(i +"- " + x.get(i));
		}
	}
	public void getArmyDetailsBesieging() { //UPDATES DATA OF BESIEGING ARMIES
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentStatus().equals(Status.MARCHING)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		for(int i = 0; i< model.getPlayer().getControlledCities().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledCities().get(i).getDefendingArmy();
			if(currentArmy.getCurrentStatus().equals(Status.MARCHING)) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		besiegingArmies.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			besiegingArmies.addItem(i +"- " + x.get(i));
		}
	}
	public void updatePlayerData() { // UPDATES DATA ON DATA LABEL OF FOOD, GOLD & CURRENT TURNCOUNT
		worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString()); //player name, food and gold
	}
	public void updateDefendingArmyCityViewCairo(City c) { //UPDATES DATA ON DEFENDING ARMY
		Army defendingArmy = c.getDefendingArmy();
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i=0; i < defendingArmy.getUnits().size(); i++) {
			s = defendingArmy.getUnits().get(i).toString();
			x.add(s);
			
		}
		defendingArmyUnitsCairo.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			defendingArmyUnitsCairo.addItem(i +"- " + x.get(i));
		}
		
	}
	public void updateArmiesinsideCityCairo(City c) {
		ArrayList<String> x = new ArrayList();
		String s = "";
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentLocation().equalsIgnoreCase(c.getName())) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		armiesInsideCairo.removeAll();
		for(int i = 0; i < x.size(); i++) {
			armiesInsideCairo.addItem(i +"- " + x.get(i));;
		}
	}
	public void updateDefendingArmyCityViewRome(City c) { //UPDATES DATA ON DEFENDING ARMY
		Army defendingArmy = c.getDefendingArmy();
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i=0; i < defendingArmy.getUnits().size(); i++) {
			s = defendingArmy.getUnits().get(i).toString();
			x.add(s);
			
		}
		defendingArmyUnitsRome.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			defendingArmyUnitsRome.addItem(i +"- " + x.get(i));
		}
		
	}
	public void updateArmiesinsideCityRome(City c) {
		ArrayList<String> x = new ArrayList();
		String s = "";
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentLocation().equalsIgnoreCase(c.getName())) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		armiesInsideRome.removeAll();
		for(int i = 0; i < x.size(); i++) {
			armiesInsideRome.addItem(i +"- " + x.get(i));;
		}
	}
	public void updateDefendingArmyCityViewSparta(City c) { //UPDATES DATA ON DEFENDING ARMY
		Army defendingArmy = c.getDefendingArmy();
		String s = "";
		ArrayList<String> x = new ArrayList();
		for(int i=0; i < defendingArmy.getUnits().size(); i++) {
			s = defendingArmy.getUnits().get(i).toString();
			x.add(s);
			
		}
		defendingArmyUnitsSparta.removeAllItems();
		for(int i = 0; i < x.size(); i++) {
			defendingArmyUnitsSparta.addItem(i +"- " + x.get(i));
		}
		
	}
	public void updateArmiesinsideCitySparta(City c) {
		ArrayList<String> x = new ArrayList();
		String s = "";
		for(int i = 0; i < model.getPlayer().getControlledArmies().size(); i++) {
			Army currentArmy = model.getPlayer().getControlledArmies().get(i);
			if(currentArmy.getCurrentLocation().equalsIgnoreCase(c.getName())) {
				s = currentArmy.toString();
				x.add(s);
			}
		}
		armiesInsideSparta.removeAll();
		for(int i = 0; i < x.size(); i++) {
			armiesInsideSparta.addItem(i +"- " + x.get(i));;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e .getSource() == confirmButton) {
			try {
				if(!nameField.getText().equals("")) {
					String selectedCity = (String) cities.getSelectedItem();
					System.out.print(selectedCity);
					model = new Game(nameField.getText(), selectedCity);
					for(int i = 0; i < model.getPlayer().getControlledCities().size(); i++) {
						City c = model.getPlayer().getControlledCities().get(i);
						if (c.getName().equalsIgnoreCase("Cairo")) {
							cairoCity = c;
						}
						else if (c.getName().equalsIgnoreCase("Rome")) {
							romeCity = c;
						}
						else {
							spartaCity = c;
						}
					}
					view.dispose();
					//System.out.print(model.getAvailableCities().get(1).getDefendingArmy().toString());
					worldMap.setVisible(true);
					this.updatePlayerData();
					worldMap.repaint();
					worldMap.revalidate();
				}
			} catch(IOException exception) {}
		}
		//OPENING CITY VIEWS
		
		if(e.getSource() == cairo) {
			//System.out.print(model.getPlayer().getControlledCities().get(0).getName());
			for(int i = 0; i < model.getPlayer().getControlledCities().size(); i++) {
				
				if(model.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("cairo")) {
					cityViewCairo.setVisible(true);
				}
			}
		}
		
		if(e.getSource() == rome) {
			for(int i = 0; i < model.getPlayer().getControlledCities().size(); i++) {
				
				if(model.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
					cityViewRome.setVisible(true);
				}
			}
		}
		if(e.getSource() == sparta) {
			for(int i = 0; i < model.getPlayer().getControlledCities().size(); i++) {
				
				if(model.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("sparta")) {
					cityViewSparta.setVisible(true);
				}
			}
		}
		//ENDING TURNS
		if(e.getSource() == endTurn) {
			model.endTurn();
			this.updatePlayerData();
			if(model.isGameOver()) {
				gameOverView.getGameOver().setText("You Lose!");
				gameOverView.setVisible(true);
				worldMap.setEnabled(false);
				cityViewCairo.setEnabled(false);
				cityViewRome.setEnabled(false);
				cityViewSparta.setEnabled(false);
			}
		}
		//-------------------------------------CAIRO-----------------------------------------//
		//------------------------------------- BUILDING IN CAIRO---------------------------------//
		if(e.getSource() == exitCityCairo) {
			cityViewCairo.setVisible(false);
		}
		
		if(e.getSource() == buildFarmCairo) {
			try {
				model.getPlayer().build("farm", "Cairo");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewCairo.getFarm().add(l);
				upgradeFarmCairo.setToolTipText("Cost: " + "500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		if(e.getSource() == buildMarketCairo) {
			try {
				model.getPlayer().build("Market", "Cairo");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewCairo.getMarket().add(l);
				upgradeMarketCairo.setToolTipText("Cost: " + "700" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildArcheryRangeCairo) {
			try {
				model.getPlayer().build("ArcheryRange", "Cairo");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewCairo.getArcheryRange().add(l);
				upgradeArcheryRangeCairo.setToolTipText("Cost: " + "800" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildBarracksCairo) {
			try {
				model.getPlayer().build("Barracks", "Cairo");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewCairo.getBarracks().add(l);
				upgradeBarracksCairo.setToolTipText("Cost: " + "1000" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildStableCairo) {
			try {
				model.getPlayer().build("Stable", "Cairo");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewCairo.getStable().add(l);
				upgradeStableCairo.setToolTipText("Cost: " + "1500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		//----------------------------------------UPGRADING IN CAIRO-------------------------------------//
		if(e.getSource() == upgradeFarmCairo) {
			try {
				for (int i = 0; i < cairoCity.getEconomicalBuildings().size(); i++) {
					Building b = cairoCity.getEconomicalBuildings().get(i);
					if (b instanceof Farm) {
						model.getPlayer().upgradeBuilding(b);
						upgradeFarmCairo.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}

		if(e.getSource() == upgradeMarketCairo) {
			try {
				for (int i = 0; i < cairoCity.getEconomicalBuildings().size(); i++) {
					Building b = cairoCity.getEconomicalBuildings().get(i);
					if (b instanceof Market) {
						model.getPlayer().upgradeBuilding(b);
						upgradeMarketCairo.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeArcheryRangeCairo) {
			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().upgradeBuilding(b);
						upgradeArcheryRangeCairo.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitArcherCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeBarracksCairo) {
			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().upgradeBuilding(b);
						upgradeBarracksCairo.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitInfantryCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeStableCairo) {
			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().upgradeBuilding(b);
						upgradeStableCairo.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitCavalryCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == recruitArcherCairo) {

			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().recruitUnit("archer", "Cairo");
						recruitArcherCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(cairoCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewCairo(cairoCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitInfantryCairo) {

			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().recruitUnit("infantry", "Cairo");
						recruitInfantryCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(cairoCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewCairo(cairoCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitCavalryCairo) {

			try {
				for (int i = 0; i < cairoCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = cairoCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().recruitUnit("cavalry", "Cairo");
						recruitCavalryCairo.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(cairoCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewCairo(cairoCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewCairo, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		
		//-----------------------------------------------------ROME-------------------------------//
		if(e.getSource() == exitCityRome) {
			cityViewRome.setVisible(false);
		}
		
		if(e.getSource() == buildFarmRome) {
			try {
				model.getPlayer().build("farm", "Rome");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewRome.getFarm().add(l);
				upgradeFarmRome.setToolTipText("Cost: " + "500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		if(e.getSource() == buildMarketRome) {
			try {
				model.getPlayer().build("Market", "Rome");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewRome.getMarket().add(l);
				upgradeMarketRome.setToolTipText("Cost: " + "700" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildArcheryRangeRome) {
			try {
				model.getPlayer().build("ArcheryRange", "Rome");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewRome.getArcheryRange().add(l);
				upgradeArcheryRangeRome.setToolTipText("Cost: " + "800" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildBarracksRome) {
			try {
				model.getPlayer().build("Barracks", "Rome");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewRome.getBarracks().add(l);
				upgradeBarracksRome.setToolTipText("Cost: " + "1000" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildStableRome) {
			try {
				model.getPlayer().build("Stable", "Rome");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewRome.getStable().add(l);
				upgradeStableRome.setToolTipText("Cost: " + "1500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		//----------------------------------------UPGRADING IN CAIRO-------------------------------------//
		if(e.getSource() == upgradeFarmRome) {
			try {
				for (int i = 0; i < romeCity.getEconomicalBuildings().size(); i++) {
					Building b = romeCity.getEconomicalBuildings().get(i);
					if (b instanceof Farm) {
						model.getPlayer().upgradeBuilding(b);
						upgradeFarmRome.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}

		if(e.getSource() == upgradeMarketRome) {
			try {
				for (int i = 0; i < romeCity.getEconomicalBuildings().size(); i++) {
					Building b = romeCity.getEconomicalBuildings().get(i);
					if (b instanceof Market) {
						model.getPlayer().upgradeBuilding(b);
						upgradeMarketRome.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeArcheryRangeRome) {
			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().upgradeBuilding(b);
						upgradeArcheryRangeRome.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitArcherRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeBarracksRome) {
			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().upgradeBuilding(b);
						upgradeBarracksRome.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitInfantryRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeStableRome) {
			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().upgradeBuilding(b);
						upgradeStableRome.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitCavalryRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == recruitArcherRome) {

			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().recruitUnit("archer", "Rome");
						recruitArcherRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(romeCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewRome(romeCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitInfantryRome) {

			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().recruitUnit("infantry", "Rome");
						recruitInfantryRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(romeCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewRome(romeCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitCavalryRome) {

			try {
				for (int i = 0; i < romeCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = romeCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().recruitUnit("cavalry", "Rome");
						recruitCavalryRome.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(romeCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewRome(romeCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewRome, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		//------------------------------------------------SPARTA-----------------------------------//
		if(e.getSource() == exitCitySparta) {
			cityViewSparta.setVisible(false);
		}
		
		if(e.getSource() == buildFarmSparta) {
			try {
				model.getPlayer().build("farm", "Sparta");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewSparta.getFarm().add(l);
				upgradeFarmSparta.setToolTipText("Cost: " + "500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		if(e.getSource() == buildMarketSparta) {
			try {
				model.getPlayer().build("Market", "Sparta");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewSparta.getMarket().add(l);
				upgradeMarketSparta.setToolTipText("Cost: " + "700" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildArcheryRangeSparta) {
			try {
				model.getPlayer().build("ArcheryRange", "Sparta");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewSparta.getArcheryRange().add(l);
				upgradeArcheryRangeSparta.setToolTipText("Cost: " + "800" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildBarracksSparta) {
			try {
				model.getPlayer().build("Barracks", "Sparta");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewSparta.getBarracks().add(l);
				upgradeBarracksSparta.setToolTipText("Cost: " + "1000" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource() == buildStableSparta) {
			try {
				model.getPlayer().build("Stable", "Sparta");
				worldMap.getDataLabel().setText(model.getPlayer().toString() + model.toString());
				JLabel l = new JLabel("Already Built");
				cityViewSparta.getStable().add(l);
				upgradeStableSparta.setToolTipText("Cost: " + "1500" + " Current Level: 1");
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		//----------------------------------------UPGRADING IN CAIRO-------------------------------------//
		if(e.getSource() == upgradeFarmSparta) {
			try {
				for (int i = 0; i < spartaCity.getEconomicalBuildings().size(); i++) {
					Building b = spartaCity.getEconomicalBuildings().get(i);
					if (b instanceof Farm) {
						model.getPlayer().upgradeBuilding(b);
						upgradeFarmSparta.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}

		if(e.getSource() == upgradeMarketSparta) {
			try {
				for (int i = 0; i < spartaCity.getEconomicalBuildings().size(); i++) {
					Building b = spartaCity.getEconomicalBuildings().get(i);
					if (b instanceof Market) {
						model.getPlayer().upgradeBuilding(b);
						upgradeMarketSparta.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeArcheryRangeSparta) {
			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().upgradeBuilding(b);
						upgradeArcheryRangeSparta.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitArcherSparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeBarracksSparta) {
			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().upgradeBuilding(b);
						upgradeBarracksSparta.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitInfantrySparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == upgradeStableSparta) {
			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().upgradeBuilding(b);
						upgradeStableSparta.setToolTipText("Cost: " + b.getUpgradeCost() + " Current Level: " + b.getLevel());
						recruitCavalrySparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
					}
				}
				this.updatePlayerData();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;

			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxLevelException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Max Level Reached!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}
		if(e.getSource() == recruitArcherSparta) {

			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof ArcheryRange) {
						model.getPlayer().recruitUnit("archer", "Sparta");
						recruitArcherSparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(spartaCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewSparta(spartaCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitInfantrySparta) {

			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof Barracks) {
						model.getPlayer().recruitUnit("infantry", "Sparta");
						recruitInfantrySparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(spartaCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewSparta(spartaCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		if(e.getSource() == recruitCavalrySparta) {

			try {
				for (int i = 0; i < spartaCity.getMilitaryBuildings().size(); i++) {
					MilitaryBuilding b = spartaCity.getMilitaryBuildings().get(i);
					if (b instanceof Stable) {
						model.getPlayer().recruitUnit("cavalry", "Sparta");
						recruitCavalrySparta.setToolTipText("Recruitment Cost: " + b.getRecruitmentCost());
						break;
					}
				}
				//System.out.print(spartaCity.getDefendingArmy().getUnits().get(0).toString());
				this.updatePlayerData();
				this.updateDefendingArmyCityViewSparta(spartaCity);
				this.getArmyDetailsIdle();
			} catch (BuildingInCoolDownException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Building In Cooldown!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Reached Recruitment Limit for this Turn!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(cityViewSparta, "Not Enough Gold!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
	}

}