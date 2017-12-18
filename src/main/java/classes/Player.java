package classes;

public class Player {

    private String name;
    private int tournamentLevelBeforeTournament;
    private int tournamentLevelAfterTournament;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTournamentLevelBeforeTournament() {
        return tournamentLevelBeforeTournament;
    }

    public void setTournamentLevelBeforeTournament(int tournamentLevelBeforeTournament) {
        this.tournamentLevelBeforeTournament = tournamentLevelBeforeTournament;
    }

    public int getTournamentLevelAfterTournament() {
        return tournamentLevelAfterTournament;
    }

    public void setTournamentLevelAfterTournament(int tournamentLevelAfterTournament) {
        this.tournamentLevelAfterTournament = tournamentLevelAfterTournament;
    }
}
