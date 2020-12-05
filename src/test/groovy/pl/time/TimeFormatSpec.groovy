package pl.time

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Subject
class TimeFormatSpec extends Specification {

    def "should throw exception when seconds do not meet requirement"() {
        when:
        TimeFormat.toHumanReadable(seconds)

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == expectedMessage
        where:
        seconds << [-1, 360000]
        expectedMessage << ["Seconds should be bigger than or equal 0", "Seconds should be smaller than 359999"]
    }

    @Unroll
    def "should map #seconds to #expectedResult"() {
        when:
        def result = TimeFormat.toHumanReadable(seconds)
        then:
        result == expectedResult
        where:
        seconds || expectedResult
        359999  || "99:59:59"
        0       || "00:00:00"
        1       || "00:00:01"
        30      || "00:00:30"
        90      || "00:01:30"
        3600    || "01:00:00"
        3620    || "01:00:20"
        55524   || "15:25:24"
    }
}
