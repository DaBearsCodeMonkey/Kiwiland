package serviceimpl

import spock.lang.Specification
import utility.BuildTrainStationHelper

class DijkstraServiceImplTest extends Specification {
    def "Returns the shortest part when given two points"(){
        given:
        def graph = new DirectedGraphServiceImpl(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DijkstraServiceImpl()

        when:
        def actualResult = service.getShortestRoute(startingStation, endingStation)

        then:
        actualResult == expectedResult

        where:
        startingStation | endingStation | expectedResult
        'A' as char     | 'C' as char   | "9"
    }
}
