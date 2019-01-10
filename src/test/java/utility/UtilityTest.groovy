package utility


import spock.lang.Specification

class UtilityTest extends Specification {
    def "This should convert the char into an int"(){
        given: "A new Helper class object"
        def myObj = new Utility()

        when: "I call the method that converts a char to an int"
        def actualResult = myObj.getIntValueOfChar(character)

        then:
        actualResult == expectedResult

        where:
        character | expectedResult
        (char)'a'       | 0
        (char)'b'       | 1
        (char)'c'       | 2
        (char)'z'       | 25
    }

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
