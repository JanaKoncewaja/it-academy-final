package com.it.academy.webapp;

import com.it.academy.data.dao.DeviceDao;
import com.it.academy.data.dao.LightOnSensorDao;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.LightOnSensorService;
import com.it.academy.service.catalog.DeviceCatalogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.it.academy")
public class SpringBootApplication2 extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootApplication2.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication2.class, args);

    }

    @Bean
    LightOnSensorDao lightOnSensorDao(){
        return new LightOnSensorDao();
    }

    @Bean
    DeviceDao deviceDao(){
        return new DeviceDao();
    }

    @Bean
    DeviceService deviceService(){
        return new DeviceService(deviceDao());
    }

    @Bean
    LightOnSensorService lightOnSensorService(){
        return new LightOnSensorService();
    }

 @Bean
   DeviceCatalogService deviceCatalogService(){
     return new DeviceCatalogService(deviceService(),lightOnSensorService());

   }





}


