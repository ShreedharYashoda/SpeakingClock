package com.wisdomleaf.bed.speakingclock.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TimeFormatterServiceImplTest {

    @Autowired
    TimeFormatterServiceImpl timeFormatterService;

    @Test
    public void invalidFormatTest() {
        String INVALID_FORMAT = "It's invalid format";

        Assertions.assertEquals(INVALID_FORMAT, timeFormatterService.getTimeFormattedInWords("7r:34"));
        Assertions.assertEquals(INVALID_FORMAT, timeFormatterService.getTimeFormattedInWords("-2:34"));
        Assertions.assertEquals(INVALID_FORMAT, timeFormatterService.getTimeFormattedInWords("-12:34"));
        Assertions.assertEquals(INVALID_FORMAT, timeFormatterService.getTimeFormattedInWords("02-34"));

    }

    @Test
    public void invalidHourTest() {
        String INVALID_TIME = "It's Invalid time";

        Assertions.assertEquals(INVALID_TIME, timeFormatterService.getTimeFormattedInWords("24:34"));
    }

    @Test
    public void invalidMinuteTest() {
        String INVALID_TIME = "It's Invalid time";

        Assertions.assertEquals(INVALID_TIME, timeFormatterService.getTimeFormattedInWords("24:60"));
    }

    @Test
    public void validMidNightTest() {
        String VALID_MIDNIGHT = "It's midnight";

        Assertions.assertEquals(VALID_MIDNIGHT, timeFormatterService.getTimeFormattedInWords("00:00"));
    }

    @Test
    public void validMidNightPastMinutesTest() {
        String VALID_MIDNIGHT_PAST_MINUTES = "It's midnight past eighteen";

        Assertions.assertEquals(VALID_MIDNIGHT_PAST_MINUTES, timeFormatterService.getTimeFormattedInWords("00:18"));
    }


    @Test
    public void validMidDayTest() {
        String VALID_MIDDAY = "It's midday";

        Assertions.assertEquals(VALID_MIDDAY, timeFormatterService.getTimeFormattedInWords("12:00"));
    }

    @Test
    public void validTimeFormatTest() {
        String VALID_FORMAT = "It's eleven eleven";

        Assertions.assertEquals(VALID_FORMAT, timeFormatterService.getTimeFormattedInWords("11:11"));
    }

    @Test
    public void generate1To59_ForNonMidnightMinutesTest(){
        String EMPTY_STRING = "";
        Assertions.assertEquals(EMPTY_STRING, timeFormatterService.generate1To59(0, false));
    }

    @Test
    public void generate1To59_ForMidnightPastMinutesTest(){
        String MIDNIGHT_STRING = "midnight past";
        Assertions.assertEquals(MIDNIGHT_STRING, timeFormatterService.generate1To59(0, true));
    }


    @Test
    public void generate1To59oneToNineTest(){
        String FIVE_STRING = "five";
        Assertions.assertEquals(FIVE_STRING, timeFormatterService.generate1To59(5, false));
    }

    @Test
    public void generate1To59tenToNinteenTest(){
        String ELEVEN_STRING = "eleven";
        Assertions.assertEquals(ELEVEN_STRING, timeFormatterService.generate1To59(11, false));
    }

    @Test
    public void generate1To59TensTest(){
        String fifty_STRING = "fifty one";
        Assertions.assertEquals(fifty_STRING, timeFormatterService.generate1To59(51, false));
    }
}
