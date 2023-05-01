package com.clock.clockconverter;

public class TimeConverter {
	private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty"};

    public static String convertTimeToWords(int hour, int minute) {
        String timeInWords="";
     // Convert hour to words
        if (hour == 0) {
            timeInWords += "MidNight";
        } else if (hour == 12) {
            timeInWords += "Midday";
        } else {
            timeInWords += convertToWords(hour);
            //timeInWords += " o'clock";
        }

        // Convert minute to words
        if (minute != 0) {
            timeInWords += " ";
            timeInWords += convertToWords(minute);
            timeInWords += " minute";
            if (minute != 1) {
                timeInWords += "s";
            }
        }
        
        return timeInWords;
    }
    
    private static String convertToWords(int number) {
        if (number < 20) {
            return ONES[number];
        } else {
            int tensDigit = number / 10;
            int onesDigit = number % 10;
            return TENS[tensDigit] + " " + ONES[onesDigit];
        }
    }

}
