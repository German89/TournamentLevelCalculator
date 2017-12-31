package classes;

public class Player {

    private String name;
    private double tournamentLevelBeforeTournament;
    private double tournamentLevelAfterTournament;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTournamentLevelBeforeTournament() {
        return tournamentLevelBeforeTournament;
    }

    public void setTournamentLevelBeforeTournament(double tournamentLevelBeforeTournament) {
        this.tournamentLevelBeforeTournament = tournamentLevelBeforeTournament;
    }

    public double getTournamentLevelAfterTournament() {
        return tournamentLevelAfterTournament;
    }

    public void setTournamentLevelAfterTournament(double tournamentLevelAfterTournament) {
        this.tournamentLevelAfterTournament = tournamentLevelAfterTournament;
    }
}
