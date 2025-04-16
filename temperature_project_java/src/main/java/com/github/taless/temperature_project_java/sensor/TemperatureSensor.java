package com.github.taless.temperature_project_java.sensor;

/**
 * 温度传感器接口
 */
public interface TemperatureSensor {
    
    /**
     * 获取当前温度
     * @return 当前温度（摄氏度）
     */
    double getCurrentTemperature();
} 