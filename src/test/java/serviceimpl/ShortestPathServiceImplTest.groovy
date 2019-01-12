package serviceimpl

import spock.lang.Specification
import utility.BuildTrainStationHelper

class ShortestPathServiceImplTest extends Specification {
    def "Returns the shortest part when given two points"(){
        given:
        def graph = new DirectedGraphServiceImpl(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new ShortestPathServiceImpl(graph.getGraph())

        when:
        def actualResult = service.getShortestRoute(startingStation, endingStation)

        then:
        actualResult == expectedResult

        where:
        startingStation | endingStation | expectedResult
        'A' as char     | 'C' as char   | "9"
//        'C' as char     | 'C' as char   | "9"
    }

    def "Find the vertex with minimum distance value and return the index of the array"(){
        def graph = new DirectedGraphServiceImpl(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new ShortestPathServiceImpl(graph.getGraph())

        when:
        def actualResult = service.getMinDistance(distanceArr, booleanArr)

        then:
        actualResult == expectedResult

        where:
        distanceArr                | booleanArr                                                     | expectedResult
        (int[])[3,5,7,2,1]         | (boolean[])[false,false,false,false,true]                      | 3
        (int[])[36,2,25,4,3]       | (boolean[])[false,false,false,false, false]                    | 1
    }
}
