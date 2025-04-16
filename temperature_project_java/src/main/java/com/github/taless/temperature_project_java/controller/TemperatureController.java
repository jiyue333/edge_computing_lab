package com.github.taless.temperature_project_java.controller;

import com.github.taless.temperature_project_java.model.TemperatureData;
import com.github.taless.temperature_project_java.sensor.TemperatureSensor;
import com.github.taless.temperature_project_java.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 温度数据控制器
 */
@RestController
@RequestMapping("/api/temperature")
@CrossOrigin(origins = "*") // 允许跨域请求
public class TemperatureController {

    private final TemperatureSensor temperatureSensor;
    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureSensor temperatureSensor, TemperatureService temperatureService) {
        this.temperatureSensor = temperatureSensor;
        this.temperatureService = temperatureService;
    }

    /**
     * 获取当前温度
     * @return 包含温度数据和时间戳的对象
     */
    @GetMapping
    public TemperatureData getCurrentTemperature() {
        return new TemperatureData(
                temperatureSensor.getCurrentTemperature(),
                LocalDateTime.now()
        );
    }
    
    /**
     * 获取历史温度记录
     * @return 温度历史记录列表
     */
    @GetMapping("/history")
    public List<TemperatureData> getTemperatureHistory() {
        return temperatureService.getRecentTemperatures();
    }
} 