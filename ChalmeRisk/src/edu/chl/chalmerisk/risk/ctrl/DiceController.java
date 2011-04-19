package edu.chl.chalmerisk.risk.ctrl;
import edu.chl.chalmerisk.risk.*;
import edu.chl.chalmerisk.risk.core.Dice;

public class DiceController {

	public int winner;
	private int i;
	private Dice attDice1;
	private Dice attDice2;
	private Dice attDice3;
	private Dice defDice1;
	private Dice defDice2;
	private int attNumberOfDice;
	private int defNumberOfDice;
	
	public DiceController() {
		i = (int) ((Math.random() * 5) + 1);
	}

	public int getResult(int att, int def) {
		if(att>=3 && def==1){
			attNumberOfDice = 3;
			defNumberOfDice = 1;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		if(att==2 && def==1){
			attNumberOfDice = 2;
			defNumberOfDice = 1;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		if(att==1 && def==1){
			attNumberOfDice = 1;
			attNumberOfDice = 1;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		if(att>=3 && def>=2){
			attNumberOfDice = 3;
			defNumberOfDice = 2;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		if(att==2 && def>=2){
			attNumberOfDice = 2;
			defNumberOfDice = 2;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		if(att==1 && def>=2){
			attNumberOfDice = 1;
			defNumberOfDice = 2;
			return battle(attNumberOfDice, defNumberOfDice);
		}
		return (int) ((Math.random() * 2) + 1);
		//return battle(attNumberOfDice, defNumberOfDice);
	}

	private int battle(int attNumberOfDice, int defNumberOfDice) {
		attDice1.tossDice();
		attDice2.tossDice();
		attDice3.tossDice();
		defDice1.tossDice();
		defDice2.tossDice();
		int attDiceMax;
		int attDiceMin;
		int defDiceMax;
		int defDiceMin;

		if(attNumberOfDice==3 && defNumberOfDice==1){
			
			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			attDiceMax = Math.max(attDiceMax, attDice3.getNumber());
			
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}
		}
		if(attNumberOfDice==2 && defNumberOfDice==1){

			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}

		}
		if(attNumberOfDice==1 && defNumberOfDice==1){

			attDiceMax = attDice1.getNumber();
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}

		}
		if(attNumberOfDice==3 && defNumberOfDice==2 ){

			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			attDiceMax = Math.max(attDiceMax, attDice3.getNumber());
		
			
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}

		}
		if(attNumberOfDice==2 && defNumberOfDice==2){

			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			attDiceMax = Math.max(attDiceMax, attDice3.getNumber());
			
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}

		}
		if(attNumberOfDice==1 && defNumberOfDice==2){

			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			attDiceMax = Math.max(attDiceMax, attDice3.getNumber());
			
			if(attDiceMax > defDice1.getNumber() ) {
				return 3;
			}
			else {
				return 4;
			}

		}
		return (int) ((Math.random() * 5) + 1);


	}
	public int getAttNumberOfDices(){
		return attNumberOfDice;
	}

	public int getDefNumberOfDices() {
		return defNumberOfDice;
	}

}
