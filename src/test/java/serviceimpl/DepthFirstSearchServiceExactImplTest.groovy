package serviceimpl

import spock.lang.Specification

/*  A - E - B - C - E
    A - B - C - D - E
    A - D - C - D - E*/
class DepthFirstSearchServiceExactImplTest extends Specification {
    def "Given a threshold number of stops and whether to do maximum routes or exact routes, return the correct value"(){
        given:
        def graph = new DirectedGraphServiceImpl((String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service =  new DepthFirstSearchServiceExactImpl(graph.getGraph())

        when:
        def actualResult = service.getNumberOfStops(startingStation, endingStation, numberOfStops)

        then:
        actualResult == expectedResult

        where:
        startingStation      | endingStation     | numberOfStops        | expectedResult
        'C' as char          | 'A' as char       | 3                 | "0"
        'A' as char          | 'E' as char       | 4                 | "3"
        'A' as char          | 'C' as char       | 4                 | "3"
        'A' as char          | 'C' as char       | 5                 | "Please choose max or exact."
        'C' as char          | 'C' as char       | 3                 | "2"
    }
}
