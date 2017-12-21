package classes;

public class Formula {

   Integer getTorunamentLevelAfterMach(Player player, Player opponent, String winningPlayer){
        int tournamentlevelEarnedLost = 0;

        if(winningPlayer.equals(player.getName())){
            //If the Player won the match it will earn points depending on the formula applied
            if(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament() > 0){
                tournamentlevelEarnedLost = getPointsWinningPlayerHasMoreLevel(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament());
            }else {
                tournamentlevelEarnedLost = getPointsWinningPlayerHasLessLevel(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament());
            }

        }else {
            //If the player lost the match it will lost points depending on the formula applied
            if(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament() > 0){
                tournamentlevelEarnedLost = getPointsWinningPlayerHasMoreLevel(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament());
            }else {
                tournamentlevelEarnedLost = getPointsWinningPlayerHasLessLevel(player.getTournamentLevelBeforeTournament() - opponent.getTournamentLevelBeforeTournament());
            }
            tournamentlevelEarnedLost = - tournamentlevelEarnedLost;
        }

        return tournamentlevelEarnedLost;

    }

    public int getPointsWinningPlayerHasMoreLevel(int differencePlayerLevel){
       //Formula to apply if the winning player has more level than the looser
       if(differencePlayerLevel < 25){
           return 18;
       }else if(differencePlayerLevel < 50){
            return 16;
        }else if(differencePlayerLevel < 100){
           return 14;
        }else if(differencePlayerLevel < 150){
           return 12;
       }else if(differencePlayerLevel < 200){
        return 10;
        }else if(differencePlayerLevel < 300){
           return 8;
       }else if(differencePlayerLevel < 400){
           return 6;
       }else if(differencePlayerLevel < 500){
           return 4;
       }else if(differencePlayerLevel < 1000){
           return 4;
       }else {
           return 0;
        }
    }


    public int getPointsWinningPlayerHasLessLevel(int differencePlayerLevel){
        //Formula to apply if the winning player has less level than the looser
        if(differencePlayerLevel < 25){
            return 18;
        }else if(differencePlayerLevel < 50){
            return 22;
        }else if(differencePlayerLevel < 100){
            return 26;
        }else if(differencePlayerLevel < 150){
            return 30;
        }else if(differencePlayerLevel < 200){
            return 36;
        }else if(differencePlayerLevel < 300){
            return 42;
        }else if(differencePlayerLevel < 400){
            return 48;
        }else if(differencePlayerLevel < 500){
            return 56;
        }else if(differencePlayerLevel < 1000){
            return 64;
        }else {
            return 80;
        }
    }

}
