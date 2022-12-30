package com.wisdomleaf.bed.speakingclock.controller;

import com.wisdomleaf.bed.speakingclock.service.TimeFormatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/timeFormatter")
public class SpeakingClockController {

    @Autowired
    private TimeFormatterService  timeFormatterService;

    @GetMapping("/getTimeInWords")
    public ResponseEntity<String> getTimeInWords(@RequestParam("timeInDigits") String date) {

        String result = timeFormatterService.getTimeFormattedInWords(date);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
