package com.github.taless.temperature_project_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 温度数据模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureData {
    
    /**
     * 温度值（摄氏度）
     */
    private double temperature;
    
    /**
     * 测量时间
     */
    private LocalDateTime timestamp;
} 