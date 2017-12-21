package classes;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) throws IOException {
        Match match = new Match();
        Formula formula = new Formula();
        XlsxReaderWriter xlsxReaderWriter = new XlsxReaderWriter();


        XSSFWorkbook xssfWorkbook = xlsxReaderWriter.readFile(); //find the workbook
        List<Player> listOfPlayers = xlsxReaderWriter.getListOfPlayers(xssfWorkbook); //get the list of players
        List<Match> listOfMatches = xlsxReaderWriter.getListOfMatches(xssfWorkbook); //get the list of matches


        for(Player player : listOfPlayers){
            // Find all the matches of that player in the tournament
            //Get the total of points earned/lost by the player after all the matches has been processed
            int totalLevelEarnedLost = 0;
            for(Match match1 : listOfMatches){
                if (match1.getPlayer().equals(player.getName())){
                    //Get the opponent
                    Player opponent = new Player();
                    for (Player player2 : listOfPlayers){
                        if(match1.getPlayer().equals(player2.getName())){
                            opponent = player2;
                            break;
                        }
                    }

                    totalLevelEarnedLost = formula.getTorunamentLevelAfterMach(player, opponent, match1.getWinningPlayer());
                    Integer totalOfPoints = player.getTournamentLevelBeforeTournament() + totalLevelEarnedLost;
                    xlsxReaderWriter.writeTorunamentPointsEarnedLost(xssfWorkbook, player.getName(), totalOfPoints);
                }
            }





        }



    }
}
