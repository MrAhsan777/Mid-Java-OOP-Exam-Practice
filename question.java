class Player {
    private String name;
    private int runsScored;
    private int wicketsTaken;

    public Player(String name, int runsScored, int wicketsTaken) {
        this.name = name;
        this.runsScored = runsScored;
        this.wicketsTaken = wicketsTaken;
    }

    public String getName() {
        return name;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', runsScored=" + runsScored + ", wicketsTaken=" + wicketsTaken + "}";
    }
}

class CricketMatch {
    private Player[] team1;
    private Player[] team2;

    public CricketMatch(Player[] team1, Player[] team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public int calculateTotalScore(Player[] team) {
        int totalScore = 0;
        for (Player player : team) {
            totalScore += player.getRunsScored();
        }
        return totalScore;
    }

    public String declareWinningTeam() {
        int team1Score = calculateTotalScore(team1);
        int team2Score = calculateTotalScore(team2);

        if (team1Score > team2Score) {
            return "Team 1 wins with a score of " + team1Score + " against " + team2Score;
        } else if (team2Score > team1Score) {
            return "Team 2 wins with a score of " + team2Score + " against " + team1Score;
        } else {
            return "The match is a tie with both teams scoring " + team1Score;
        }
    }

    public void printMatchSummary() {
        System.out.println("Match Summary:");
        System.out.println("Team 1:");
        for (Player player : team1) {
            System.out.println(player);
        }
        System.out.println("Team 1 Total Score: " + calculateTotalScore(team1));

        System.out.println("Team 2:");
        for (Player player : team2) {
            System.out.println(player);
        }
        System.out.println("Team 2 Total Score: " + calculateTotalScore(team2));

        System.out.println(declareWinningTeam());
    }

    public static void main(String[] args) {
        Player[] team1 = {
            new Player("Player 1", 50, 2),
            new Player("Player 2", 30, 1),
            new Player("Player 3", 70, 0)
        };

        Player[] team2 = {
            new Player("Player 4", 40, 3),
            new Player("Player 5", 60, 1),
            new Player("Player 6", 50, 2)
        };

        CricketMatch match = new CricketMatch(team1, team2);
        match.printMatchSummary();
    }
}