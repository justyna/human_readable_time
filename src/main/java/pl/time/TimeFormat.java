package pl.time;

public class TimeFormat {
    private static final int MAX_TIME = 359999;

    public static String toHumanReadable(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds should be bigger than or equal 0");
        }

        if (seconds > MAX_TIME) {
            throw new IllegalArgumentException("Seconds should be smaller than 359999");
        }

        int secondsUnit = 3600;
        StringBuffer stringBuffer = new StringBuffer();;
        for(int i = 0; i <3; i++) {
            int time = seconds/secondsUnit;
            seconds = seconds % secondsUnit;
            secondsUnit = secondsUnit/60;
            if (isZeroNeeded(time)) {
                stringBuffer.append("0");
            }
            stringBuffer.append(time);
            if (isNotLastElement(i)) {
                stringBuffer.append(":");
            }

        }
        return stringBuffer.toString();
    }

    private static boolean isNotLastElement(int i) {
        return i < 2;
    }

    private static boolean isZeroNeeded(int time) {
        return time < 10;
    }
}
