package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Log
public class UtilExampleApplication {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DemoClass {
        private List<Map<String, Object>> list = new ArrayList<>();
    }

    @Bean
    DemoClass demoClass() {
        return new DemoClass();
    }

    @Bean
    CommandLineRunner demo(DemoClass demo) {
        return args -> {
            Assert.notNull(demo.getList(), "the list cannot be null");
            beans(demo);
        };
    }

    private void beans(DemoClass demo) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(demo.getClass());
        for (PropertyDescriptor pd : propertyDescriptors) {
            log.info("pd: " + pd.getName());
            log.info("pd.readMethod: " + pd.getReadMethod());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(UtilExampleApplication.class, args);
    }
}
