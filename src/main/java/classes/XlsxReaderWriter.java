package classes;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReaderWriter {

    private static final String FILE_NAME = "/src/main/java/tournamentFiles/Tournament.xlsx";


    public XSSFWorkbook readFile() throws IOException {
        String workingDir = System.getProperty("user.dir");
        FileInputStream excelFile = new FileInputStream(new File(workingDir + FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        return workbook;
    }

    public List<Player> getListOfPlayers(XSSFWorkbook workbook){
        //This method is going to read the first sheet of the Tournament with it's 3 columns: name, tournament level before tournament
        // and tournament level after tournament. Then it returns a list of players with their data
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        List<Player> listOfPlayers = new ArrayList<Player>();

        iterator.next();//skip the title line

        while (iterator.hasNext()) {
            Player player = new Player();
            Row currentRow = iterator.next();
            if(currentRow.getCell(0).toString().isEmpty()){
                break;
            }

            // get the player name
            Cell currentCell = currentRow.getCell(0);
            player.setName(currentCell.getStringCellValue());

            //get the player tournament level before tournament
            currentCell = currentRow.getCell(1);
            player.setTournamentLevelBeforeTournament(currentCell.getNumericCellValue());

            listOfPlayers.add(player);
            }

            return listOfPlayers;
        }

        public List<Match> getListOfMatches(XSSFWorkbook workbook){
            //This method is going to load the list of all the matches played on the tournament
            Sheet datatypeSheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = datatypeSheet.iterator();

            List<Match> listOfMatches = new ArrayList<Match>();
            iterator.next();//skip the title line

            while (iterator.hasNext()) {
                Match match = new Match();
                Row currentRow = iterator.next();

                if(currentRow.getCell(0).toString().isEmpty()){
                    break;
                }

                // get the player name
                Cell currentCell = currentRow.getCell(0);
                match.setPlayer(currentCell.getStringCellValue());

                //get the opponent Name
                currentCell = currentRow.getCell(1);
                match.setOpponent(currentCell.getStringCellValue());

                //get the winning Player
                currentCell = currentRow.getCell(2);
                match.setWinningPlayer(currentCell.getStringCellValue());

                listOfMatches.add(match);
            }

            return listOfMatches;
        }


        public void writeTorunamentPointsEarnedLost(XSSFWorkbook workbook ,  String playerName, double tournamentPointsEarnedLost){
            //Search for the player name in the first sheet of the xlsx and write the tournament level of the player
            Sheet dataTypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = dataTypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Cell currentCell = currentRow.getCell(0);

                if(playerName.equals(currentCell.getStringCellValue())){
                    currentCell = currentRow.getCell(2);
                    currentCell.setCellValue(tournamentPointsEarnedLost);
                    break;
                }
            }
        }

}
