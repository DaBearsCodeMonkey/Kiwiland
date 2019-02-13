package serviceimpl

import spock.lang.Specification

class DijkstraServiceImplTest extends Specification {
    def "Returns the shortest path (String) when given two points. Does a check to see if source == destination"(){
        given:
        def graph = new DirectedGraphServiceImpl((String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DijkstraServiceImpl(graph.getGraph())

        when:
        def actualResult = service.getShortestRoute(startingStation, endingStation)

        then:
        actualResult == expectedResult

        where:
        startingStation | endingStation | expectedResult
        'A' as char     | 'C' as char   | "9"
        'D' as char     | 'B' as char   | "9"
        'A' as char     | 'E' as char   | "7"
        'E' as char     | 'D' as char   | "15"
    }

    def "Returns the shortest part (int) when given two points"(){
        given:
        def graph = new DirectedGraphServiceImpl((String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DijkstraServiceImpl(graph.getGraph())

        when:
        def actualResult = service.dijkstraShortestPath(startingStation, endingStation)

        then:
        actualResult == expectedResult

        where:
        startingStation | endingStation | expectedResult
        0               | 2             | 9
        3               | 1             | 9
        0               | 4             | 7
        4               | 3             | 15
    }

    def "Find the vertex with minimum distance value and return the index of the array"(){
        def graph = new DirectedGraphServiceImpl((String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DijkstraServiceImpl(graph.getGraph())

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
