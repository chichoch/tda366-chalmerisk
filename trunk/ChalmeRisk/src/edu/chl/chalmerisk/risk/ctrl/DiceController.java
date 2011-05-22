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
	private int result;

	/** Takes Attacking/defending troops and returns number of dice.
	 * This method exist to make it easier,
	 * if you want to change the rules of the game.
	**/
	public int getResult(int attckingTroops, int defendingTroops) {

		if(attckingTroops>3 && defendingTroops==1){
			attNumberOfDice = 3;
			defNumberOfDice = 1;
		}
		if(attckingTroops==3 && defendingTroops==1){
			attNumberOfDice = 2;
			defNumberOfDice = 1;
		}
		if(attckingTroops==2 && defendingTroops==1){
			attNumberOfDice = 1;
			defNumberOfDice = 1;
		}
		if(attckingTroops>3 && defendingTroops>=2){
			attNumberOfDice = 3;
			defNumberOfDice = 2;
		}
		if(attckingTroops==3 && defendingTroops>=2){
			attNumberOfDice = 2;
			defNumberOfDice = 2;

		}
		if(attckingTroops==2 && defendingTroops>=2){
			attNumberOfDice = 1;
			defNumberOfDice = 2;

		}
		return battle(attNumberOfDice, defNumberOfDice);
	}

	/** (In)Takes number of dice and (out)returns the outcome of the battle into 5 different cases.
	 * Where (1) means attacker killed 1.
	 * (2) defender killed 1
	 * (3) one of each.
	 * (4) attacker killed 2
	 * (5) defender killed 2 
	 **/

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
}
