package dataProvider;

import models.Team;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaticProvider {

   @DataProvider
    public static Iterator<Object[]> validTeam() {
        List<Object[]> listOfTeams = new ArrayList<>();
        listOfTeams.add(new Object[]{"test1","description"});
        listOfTeams.add(new Object[]{"test2","description description"});
        listOfTeams.add(new Object[]{"test3","description description description"});
        return listOfTeams.iterator();

    }

    @DataProvider
    public static Iterator<Object[]> validTeamFromCsv() throws IOException {
        List<Object[]> listOfTeams = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teams.csv")));
        String line = reader.readLine();

        while(line != null){
            String[] split = line.split(";");
            listOfTeams.add(new Object[]{new Team().
                    setNameWithTeamName(split[0]).
                    setWithDescription(split[1])});
            line = reader.readLine();
        }

        return listOfTeams.iterator();
    }

}
