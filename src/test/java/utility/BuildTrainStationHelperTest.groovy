package utility

import spock.lang.Specification

class BuildTrainStationHelperTest extends Specification {
    def "This should return the number of unique trains given a command line argument"() {
        given: "A new Helper class object"
        def myObj = new BuildTrainStationHelper()

        when: "I call the method that returns number of unique trains"
        def actualResult = myObj.getNumberOfUniqueTrainStations(args)

        then:
        actualResult == expectedResult

        where:
        args                                                              | expectedResult
        (String[])["AB5","BC5","CD8","DC8","DE6","AD5","CE2","EB3","AE7"] | 5
        (String[])["AB5","Bc5","CD8"]                                     | 4
        (String[])["ab3","Bc5"]                                           | 3
    }
}
