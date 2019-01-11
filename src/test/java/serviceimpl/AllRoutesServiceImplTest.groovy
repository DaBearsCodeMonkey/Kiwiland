package serviceimpl

import spock.lang.Specification
import utility.BuildTrainStationHelper

                                /*  A - E - B - C - E
                                    A - B - C - D - E
                                    A - D - C - D - E*/
class AllRoutesServiceImplTest extends Specification {
    def "Given a threshold number of stops and whether to do maximum routes or exact routes, return the correct value"(){
        given:
        def graph = new DirectedGraphServiceImpl(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service =  new AllRoutesServiceImpl(graph.getAdjListArray())

        when:
        def actualResult = service.getNumberOfStops(startingStation, endingStation, numberOfStops, path)

        then:
        actualResult == expectedResult

        where:
        startingStation      | endingStation     | numberOfStops     | path             | expectedResult
        'C' as char          | 'A' as char       | 3                 | "exact"          | "0"
        'A' as char          | 'E' as char       | 4                 | "exact"          | "3"
        'A' as char          | 'C' as char       | 4                 | "exact"          | "3"
        'A' as char          | 'C' as char       | 5                 | "thoughtworks"   | "Please choose max or exact."
        'C' as char          | 'C' as char       | 3                 | "max"            | "2"
    }
}
