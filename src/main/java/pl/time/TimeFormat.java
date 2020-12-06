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
        String hoursReadable = calculateHours(seconds);
        String minutesReadable = calculateMinutes(seconds);
        String secondsReadable = calculateSeconds(seconds);

        return String.join(":", new String[]{hoursReadable, minutesReadable, secondsReadable});
    }

    private static String calculateSeconds(int seconds) {
        StringBuilder stringBuilder = new StringBuilder();
        seconds = seconds % 3600;
        seconds = seconds % 60;
        if(isZeroNeeded(seconds)){
            stringBuilder
                    .append("0");
        }
        stringBuilder.append(seconds);
        return stringBuilder.toString();
    }

    private static String calculateHours(int seconds){
        StringBuilder stringBuilder = new StringBuilder();
        int hours = seconds / 3600;
        if (isZeroNeeded(hours)) {
            stringBuilder
                    .append("0");
        }
        stringBuilder
                .append(hours);
        return stringBuilder.toString();
    }

    private static String calculateMinutes(int seconds) {
        StringBuilder stringBuilder = new StringBuilder();
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        if (isZeroNeeded(minutes)) {
            stringBuilder.append("0");
        }
        stringBuilder
                .append(minutes);
        return stringBuilder.toString();
    }

    private static boolean isZeroNeeded(int time) {
        return time < 10;
    }
}
