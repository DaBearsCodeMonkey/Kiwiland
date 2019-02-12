package utility;

import java.util.HashSet;
import java.util.Set;

public class BuildTrainStationHelper {

    public int getNumberOfUniqueTrainStations(String[] trainStations){
        Set<Character> uniqueCharacters = new HashSet<>();

        for(String trainStation : trainStations){
            uniqueCharacters.add(trainStation.charAt(0));
            uniqueCharacters.add(trainStation.charAt(1));
        }

        return uniqueCharacters.size();
    }
}
