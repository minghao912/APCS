public class RoShamBetter {
	private String playChoice;
	private String compChoice;

	public RoShamBetter() {
		playChoice = compChoice = "";
	}

	public RoShamBetter(String player) {
		playChoice = player;

		//Determine computer choice randomly
		int random = (int) (Math.random() * 3);
		switch (random) {
			case 0: compChoice = "Rock";
					break;
			case 1: compChoice = "Paper";
					break;
			case 2: compChoice = "Scissors";
					break;
			default: compChoice = "";
		}
	}

	public String determineWinner() {
		boolean computerWon = false;
		int thingForDumbVerbs = -1;
		String[] stupidPlayerVerbs = {"Breaks", "Covers", "Cuts"};		//Verbs for when the player wins
		String[] stupidComputerVerbs = {"Covers", "Cuts", "Breaks"};	//Verbs for when the computer wins

		//Logic
		if (playChoice.equals(compChoice)) {
			return "> Draw";
		}

		if (playChoice.equals("Rock")) {
			thingForDumbVerbs = 0;
			if (compChoice.equals("Scissors")) computerWon = false;
			else computerWon = true;
		}
		else if (playChoice.equals("Paper")) {
			thingForDumbVerbs = 1;
			if (compChoice.equals("Rock")) computerWon = false;
			else computerWon = true;
		}
		//else if (playChoice.equals("Scissors")) {
		else {
			thingForDumbVerbs = 2;
			if (compChoice.equals("Paper")) computerWon = false;
			else computerWon = true;
		}
		
		//Form output
		String winner;
		if (computerWon) {
			winner = "Computer Wins! <<" + compChoice + " " + stupidComputerVerbs[thingForDumbVerbs] + " " + playChoice + ">>";
		} else {
			winner = "Player Wins! <<" + playChoice + " " + stupidPlayerVerbs[thingForDumbVerbs] + " " + compChoice + ">>";
		}

		return winner;
	}

	public String toString() {
		return "Player chose " + playChoice + "\nComputer chose " + compChoice;
	}
}

//16/01/2019 16:48