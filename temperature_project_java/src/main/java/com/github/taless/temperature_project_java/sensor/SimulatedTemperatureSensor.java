package com.github.taless.temperature_project_java.sensor;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 模拟温度传感器实现
 * 通过随机数模拟温度变化
 */
@Component
public class SimulatedTemperatureSensor implements TemperatureSensor {
    
    private final Random random = new Random();
    private double lastTemperature = 25.0; // 初始温度为25摄氏度
    
    @Override
    public double getCurrentTemperature() {
        // 模拟温度在上一次的基础上有小幅度变化 (-0.5到+0.5度之间)
        double change = (random.nextDouble() - 0.5);
        lastTemperature += change;
        
        // 保留两位小数
        lastTemperature = Math.round(lastTemperature * 100.0) / 100.0;
        
        // 限制温度范围在10-40度之间
        if (lastTemperature < 10.0) lastTemperature = 10.0;
        if (lastTemperature > 40.0) lastTemperature = 40.0;
        
        return lastTemperature;
    }
} 