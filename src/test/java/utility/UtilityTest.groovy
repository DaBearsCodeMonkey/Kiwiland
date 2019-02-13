package utility


import spock.lang.Specification

class UtilityTest extends Specification {
    def "Removes dashes from String"(){
        given: "A string"
        def myObj = new Utility()

        when:
        def actualResult = myObj.removeDashesFromString(args)

        then:
        actualResult == expectedResult

        where:
        args        | expectedResult
        "A-B-C"     | "ABC"
        "A-D"       | "AD"
        "A-D-C"     | "ADC"
        "A-E-B-C-D" | "AEBCD"
        "A-E-D"     | "AED"
    }
}
