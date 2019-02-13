package serviceimpl

import spock.lang.Specification
import utility.BuildTrainStationHelper

class DistanceServiceImplTest extends Specification {
    def "Returns total distance of all the stations"() {
        given: "A new GRAPH object"
        def graph = new DirectedGraphServiceImpl((String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])
        def service = new DistanceServiceImpl(graph.getGraph())

        when:
        def actualResult = service.getTotalDistance(trainStations)

        then:
        actualResult == expectedResult

        where:
        trainStations        | expectedResult
        "A-B-C"              | "9"
        "A-D"                | "5"
        "A-D-C"              | "13"
        "A-E-B-C-D"          | "22"
        "A-E-D"              | "NO SUCH ROUTE"
    }
}
