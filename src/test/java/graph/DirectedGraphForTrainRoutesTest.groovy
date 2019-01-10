package graph

import spock.lang.Specification
import utility.BuildTrainStationHelper

class DirectedGraphForTrainRoutesTest extends Specification {
    def "Returns total distance of all the stations"() {
        given: "A new graph object"
        def graph = new DirectedGraphForTrainRoutes(5)
        def graphHelper = new BuildTrainStationHelper()
        graphHelper.buildGraph(graph, (String[])["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"])

        when:
        def actualResult = graph.getTotalDistance(args)

        then:
        actualResult == expectedResult

        where:
        args        | expectedResult
        "A-B-C"     | "Output #1: 9"
        "A-D"       | "Output #2: 5"
        "A-D-C"     | "Output #3: 13"
        "A-E-B-C-D" | "Output #4: 22"
        "A-E-D"     | "NO SUCH ROUTE"
    }
}
