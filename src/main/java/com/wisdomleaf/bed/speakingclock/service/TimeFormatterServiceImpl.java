package com.wisdomleaf.bed.speakingclock.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TimeFormatterServiceImpl implements TimeFormatterService{

    private static final String[] oneToNine = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] tenToNinteen = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "ten", "twenty", "thirty", "forty", "fifty"
    };

    @Override
    public String getTimeFormattedInWords(String timeInDigits) {

        final Pattern pattern = Pattern.compile("^\\d\\d:\\d\\d$", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(timeInDigits);

        if(!matcher.matches()) {
            return "It's invalid format";
        }

        StringBuilder timeInWords = new StringBuilder("It's ");
        String[] parts = timeInDigits.split(":");
        String hours = parts[0];
        String minutes = parts[1];

        int intHours = Integer.parseInt(hours);
        int intMinutes = Integer.parseInt(minutes);

        if(intHours < 0 || intHours > 23) return "It's Invalid time";
        if(intMinutes < 0 || intMinutes > 59) return "It's Invalid time";

        if(intHours == 0 && intMinutes == 0) return "It's midnight";
        if(intHours == 12 && intMinutes == 0) return "It's midday";

        timeInWords.append(generate1To59(intHours, true));
        timeInWords.append(" ");
        timeInWords.append(generate1To59(intMinutes, false));

        return timeInWords.toString();
    }

    public String generate1To59(int number, boolean isMidnight) {
        if (number == 0 && isMidnight)
            return "midnight past";
        else if(number == 0)
            return "";

        if (number <= 9)
            return oneToNine[number - 1];
        else if (number <= 19)
            return tenToNinteen[number % 10];
        else {
            return tens[number / 10 - 1] + " " + generate1To59(number % 10, false);
        }
    }
}
