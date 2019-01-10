package utility;

public class Utility {

    // A = 0, B = 1, C = 2... etc
    public int getIntValueOfChar(char currentChar){
        return currentChar - 97; // 97 is the ASCII value for 'a'
    }

    public String removeDashesFromString(String trainStations){
        return trainStations.replace("-", "");
    }
}
