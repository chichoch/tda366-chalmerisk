package edu.chl.chalmerisk.risk.ctrl;


import edu.chl.chalmerisk.risk.core.Dice;

public class DiceController {


	private Dice attDice1 = new Dice();
	private Dice attDice2 = new Dice();
	private Dice attDice3 = new Dice();
	private Dice defDice1 = new Dice();
	private Dice defDice2 = new Dice();
	
	private int attNumberOfDice;
	private int defNumberOfDice;

	// Takes Attacking/defending troops and returns number of dice.
	public int getResult(int att, int def) {
		
		if(att>3 && def==1){
			attNumberOfDice = 3;
			defNumberOfDice = 1;
		}
		if(att==3 && def==1){
			attNumberOfDice = 2;
			defNumberOfDice = 1;
		}
		if(att==2 && def==1){
			attNumberOfDice = 1;
			defNumberOfDice = 1;
		}
		if(att>3 && def>=2){
			attNumberOfDice = 3;
			defNumberOfDice = 2;
		}
		if(att==3 && def>=2){
			attNumberOfDice = 2;
			defNumberOfDice = 2;
			
		}
		if(att==2 && def>=2){
			attNumberOfDice = 1;
			defNumberOfDice = 2;
			
		}
		return battle(attNumberOfDice, defNumberOfDice);
	}
	
	//Takes number of dice and returns the outcome of the battle.
	
	public int battle(int attNumberOfDice, int defNumberOfDice) {
		
		attDice1.tossDice();
		attDice2.tossDice();	
		attDice3.tossDice();
		defDice1.tossDice();
		defDice2.tossDice();
		
		
		int attDiceMax;
		int attDiceMin;
		int defDiceMax;
		int defDiceMin;
		int result = 5;
		
		if(attNumberOfDice==3 && defNumberOfDice==1){
			

			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());
			attDiceMax = Math.max(attDiceMax, attDice3.getNumber());

			if(attDiceMax > defDice1.getNumber() ) {
				result = 1;
			}
			else {	
				result = 2;
			}
		}
		if(attNumberOfDice==2 && defNumberOfDice==1){
			
			attDiceMax=Math.max(attDice1.getNumber(), attDice2.getNumber());
			
			if( attDiceMax > defDice1.getNumber() ) {
				result = 1;
			}
			else {
				result = 2;
			}

		}
		if(attNumberOfDice==1 && defNumberOfDice==1){
			if(attDice1.getNumber() > defDice1.getNumber() ) {
				result = 1;
			}
			else {
				result = 2;
			}

		}
		if(attNumberOfDice==3 && defNumberOfDice==2 ){
			
			attDiceMax = Math.max(attDice1.getNumber(), attDice2.getNumber());

			if(attDiceMax<=attDice3.getNumber()){
				attDiceMin=attDiceMax;
				attDiceMax=attDice3.getNumber();
			}
			else if(attDiceMax>attDice3.getNumber() && attDice3.getNumber() > attDice1.getNumber()){
				attDiceMin = attDice3.getNumber();
			}
			else if(attDiceMax>attDice3.getNumber() && attDice3.getNumber() > attDice2.getNumber()){
				attDiceMin = attDice3.getNumber();
			}
			else{
				attDiceMin = Math.min(attDice1.getNumber(), attDice2.getNumber());
			}
			
			if(defDice1.getNumber() > defDice2.getNumber()){
				defDiceMax = defDice1.getNumber();
				defDiceMin = defDice2.getNumber();
			}
			else{
				defDiceMax = defDice2.getNumber();
				defDiceMin = defDice1.getNumber();
			}
			
			if(attDiceMax > defDiceMax && attDiceMin > defDiceMin ) {
				result = 3;
			}
			else if((attDiceMax > defDiceMax) || (attDiceMin > defDiceMin) ) {
				result = 5;
			}
			else {
				result = 4;
			}

		}
		if(attNumberOfDice==2 && defNumberOfDice==2){
			
			if (attDice1.getNumber() > attDice2.getNumber()){
				attDiceMax=attDice1.getNumber();
				attDiceMin=attDice2.getNumber();
			}
			else{
				attDiceMax=attDice2.getNumber();
				attDiceMin=attDice1.getNumber();
			}
			if (defDice1.getNumber() > defDice2.getNumber()){
				defDiceMax=defDice1.getNumber();
				defDiceMin=defDice2.getNumber();
			}
			else{
				defDiceMax=defDice2.getNumber();
				defDiceMin=defDice1.getNumber();
			}
			
			if(attDiceMax > defDiceMax && attDiceMin > defDiceMin ) {
				result = 3;
			}
			else if(attDiceMax > defDiceMax || attDiceMin > defDiceMin ) {
				result = 5;
			}
			else {
				result = 4;
			}

		}
		if(attNumberOfDice==1 && defNumberOfDice==2){
			
			defDiceMax = Math.max(defDice1.getNumber(), defDice2.getNumber());
			attDiceMax = attDice1.getNumber();

			if(attDiceMax > defDiceMax) {
				result = 1;
			}
			else {
				result = 2;
			}

		}
		return result;

	}
	//TODO Clean up below! and fix observer or a getmethod for att/def dice!
	
	
	public void printTest(int a, int d){
		System.out.println("\tresult: "+getResult(a, d));		
	}
	
	
	public Dice getAttDice1(){
		return attDice1;	
	}
	
	public Dice getAttDice2(){
		return attDice2;
	}
	
	public Dice getAttDice3(){
		return attDice3;	
	}
	
	public Dice getDefDice1(){
		return defDice1;	
	}
	
	public Dice getDefDice2(){
		return defDice2;	
	}
	
	public int getAttNumberOfDices(){		
		return attNumberOfDice;
		
	}

	public int getDefNumberOfDices() {		
		return defNumberOfDice;
		
	}
	public void diceNotTossed(){
	
	}

}
