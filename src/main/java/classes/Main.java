package classes;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String [] args) throws IOException {
        Player player = new Player();
        Match match = new Match();
        XlsxReaderWriter xlsxReaderWriter = new XlsxReaderWriter();


        XSSFWorkbook xssfWorkbook = xlsxReaderWriter.readFile(); //find the workbook
        List<Player> listOfPlayers = xlsxReaderWriter.getListOfPlayers(xssfWorkbook); //get the list of players
        List<Match> listOfMatches = xlsxReaderWriter.getListOfMatches(xssfWorkbook); //get the list of matches






    }
}
