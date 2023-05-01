package com.clock.clockconverter.controller;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clock.clockconverter.InvalidTimeException;
import com.clock.clockconverter.TimeConverter;
import com.clock.clockconverter.service.TimeConversionService;

@RestController
public class ClockController {
	
	@Autowired
	private TimeConversionService timeSrv;
	
	@GetMapping("/time-to-words")
    public String timeToWords(@RequestParam(value = "time") String time) {
		

        try {
        	LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        	return timeSrv.GenerateTime(time);
        
		} catch (DateTimeParseException e) {
            throw new InvalidTimeException("Invalid time format, expected format is HH:mm");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return "Invalid time format. Please enter time in HH:mm format.";
        } catch (Exception e) {
            return "An error occurred while converting time to words.";
        }
    }

	
}
