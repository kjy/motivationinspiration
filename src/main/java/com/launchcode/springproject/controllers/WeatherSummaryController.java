package com.launchcode.springproject.controllers;

import com.launchcode.springproject.WeatherProperties;
import com.launchcode.springproject.model.Location;
import com.launchcode.springproject.model.WeatherSummary;
import com.launchcode.springproject.service.OpenWeather;
import com.launchcode.springproject.service.OpenWeatherServiceClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Weather summary controller.
 */

@Controller

public class WeatherSummaryController {

    private final OpenWeatherServiceClient weatherService;
    private final WeatherProperties properties;

    /**
     * Constructor.
     *
     * @param weatherService the {@link OpenWeatherServiceClient} instance
     * @param properties     the {@link WeatherProperties} instance
     */
    public WeatherSummaryController(OpenWeatherServiceClient weatherService, WeatherProperties properties) {
        this.weatherService = weatherService;
        this.properties = properties;
    }

    /**
     * Returns weather for a location
     * <p>
     * URI: /weather?selectedLocation=
     *
     * @param selectedLocation the location to retrieve weather for
     * @return {@link ModelAndView} object containing weather summary
     */
    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public ModelAndView getCityWeather(@RequestParam String selectedLocation) {
        Map<String, Object> cityWeather = new LinkedHashMap<>();
        cityWeather.put("summary", getSummary(selectedLocation));
        return new ModelAndView("summary", cityWeather);
    }

    /**
     * Returns all locations.
     *
     * @return {@link ModelAndView} object containing locations
     */
    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public ModelAndView getLocations() {
        Map<String, Object> locationsModel = new LinkedHashMap<>();
        List<Location> locations = new ArrayList<>();
        this.properties.getLocations().forEach(value -> {
            String country = value.split("/")[1];
            String city = value.split("/")[0];
            locations.add(new Location(country, city));
        });
        locationsModel.put("locations", locations);
        return new ModelAndView("locations", locationsModel);
    }

    private Object getSummary(String location) {
        String country = location.split(",")[1];
        String city = location.split(",")[0];
        OpenWeather weather = this.weatherService.getWeather(country, city);
        return new WeatherSummary(country, city, weather);
    }

}
