package com.clock.clockconverter.service;

import org.springframework.stereotype.Service;

import com.clock.clockconverter.TimeConverter;

@Service
public class TimeConversionService {

	public String GenerateTime(String time) {
		int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        String words = TimeConverter.convertTimeToWords(hours, minutes);
        return "it's " + words;
		
	}
	
}
