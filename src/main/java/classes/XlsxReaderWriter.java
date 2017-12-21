package classes;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReaderWriter {

    private static final String FILE_NAME = "tournamentFiles/Tournament.xlsx";


    public XSSFWorkbook readFile() throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        return workbook;
    }

    public List<Player> getListOfPlayers(XSSFWorkbook workbook){
        //This method is going to read the first sheet of the Tournament with it's 3 columns: name, tournament level before tournament
        // and tournament level after tournament. Then it returns a list of players with their data
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        List<Player> listOfPlayers = new ArrayList<Player>();

        while (iterator.hasNext()) {
            Player player = new Player();
            Row currentRow = iterator.next();

            // get the player name
            Cell currentCell = currentRow.getCell(0);
            player.setName(currentCell.getStringCellValue());

            //get the player tournament level before tournament
            currentCell = currentRow.getCell(1);
            player.setTournamentLevelBeforeTournament(Integer.parseInt(currentCell.getStringCellValue()));

            listOfPlayers.add(player);
            }

            return listOfPlayers;
        }

        public List<Match> getListOfMatches(XSSFWorkbook workbook){
            //This method is going to load the list of all the matches played on the tournament
            Sheet datatypeSheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = datatypeSheet.iterator();

            List<Match> listOfMatches = new ArrayList<Match>();

            while (iterator.hasNext()) {
                Match match = new Match();
                Row currentRow = iterator.next();

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



}
