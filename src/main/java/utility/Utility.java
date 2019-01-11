package utility;

public class Utility {

    // a = 0, b = 1, c = 2... etc
    public int getIntValueOfChar(char currentChar){
        return Character.toLowerCase(currentChar) - 97; // 97 is the ASCII value for 'a'
    }

    public String removeDashesFromString(String trainStations){
        return trainStations.replace("-", "");
    }
}
