public class RockPaperScissors {
	private String playChoice;
	private String compChoice;

	public RockPaperScissors() {
		playChoice = compChoice = "";
	}

	public RockPaperScissors(String player) {
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
		int thing = -1;
		String[] stupidPlayerVerbs = {"Breaks", "Covers", "Cuts"};
		String[] stupidComputerVerbs = {"Covers", "Cuts", "Breaks"};

		if (playChoice.equals(compChoice)) {
			return "> Draw";
		}

		//Logic
		if (playChoice.equals("Rock")) {
			thing = 0;
			if (compChoice.equals("Scissors")) computerWon = false;
			else computerWon = true;
		}
		else if (playChoice.equals("Paper")) {
			thing = 1;
			if (compChoice.equals("Rock")) computerWon = false;
			else computerWon = true;
		}
		else if (playChoice.equals("Scissors")) {
			thing = 2;
			if (compChoice.equals("Paper")) computerWon = false;
			else computerWon = true;
		}
		
		//Form output
		String winner;
		if (computerWon) {
			winner = "Computer Wins! <<" + compChoice + " " + stupidComputerVerbs[thing] + " " + playChoice + ">>";
		} else {
			winner = "Player Wins! <<" + playChoice + " " + stupidPlayerVerbs[thing] + " " + compChoice + ">>";
		}

		return winner;
	}

	public String toString() {
		return "Player chose " + playChoice + "\nComputer chose " + compChoice;
	}
}

//15/01/2019 14:24