package serviceimpl

import spock.lang.Specification
import utility.BuildTrainStationHelper

class DifferentRoutesServiceImplTest extends Specification {
    def "Number of different routes from src to dest with a distance of less than the given amount"() {
        given:
        def graph = new DirectedGraphServiceImpl(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DifferentRoutesServiceImpl(graph.adjListArray)

        when:
        def actualResult = service.differentRoutes(startingStation, endingStation)

        then:
        actualResult == expectedResult

        where:
        startingStation | endingStation | expectedResult
        'C' as char     | 'C' as char   | "7"
    }
}
