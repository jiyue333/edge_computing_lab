package com.github.taless.temperature_project_java.service;

import com.github.taless.temperature_project_java.model.TemperatureData;
import com.github.taless.temperature_project_java.sensor.TemperatureSensor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 温度服务
 * 负责定期读取温度数据并存储
 */
@Service
@Slf4j
public class TemperatureService {

    private final TemperatureSensor temperatureSensor;
    
    // 存储最近100条温度记录
    private final List<TemperatureData> recentTemperatures = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_HISTORY_SIZE = 100;

    @Autowired
    public TemperatureService(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    /**
     * 每5秒读取一次温度数据
     */
    @Scheduled(fixedRate = 5000)
    public void readTemperature() {
        double temperature = temperatureSensor.getCurrentTemperature();
        TemperatureData data = new TemperatureData(temperature, LocalDateTime.now());
        
        // 添加到历史记录
        recentTemperatures.add(data);
        
        // 如果超过最大容量，移除最早的记录
        if (recentTemperatures.size() > MAX_HISTORY_SIZE) {
            recentTemperatures.remove(0);
        }
        
        log.info("当前温度: {}°C", temperature);
    }

    /**
     * 获取最近的温度历史记录
     * @return 温度历史记录列表
     */
    public List<TemperatureData> getRecentTemperatures() {
        return Collections.unmodifiableList(recentTemperatures);
    }
} 