package com.it.academy.webapp;

import com.it.academy.data.dao.DeviceDao;
import com.it.academy.data.dao.LightOnSensorDao;
import com.it.academy.data.dao.TemperatureSensoreDao;
import com.it.academy.data.dao.UserDao;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.LightOnSensorService;
import com.it.academy.service.TemperatureSensorService;
import com.it.academy.service.catalog.DeviceCatalogService;
import com.it.academy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    TemperatureSensoreDao temperatureSensoreDao(){
        return new TemperatureSensoreDao(); }


    @Bean
    DeviceDao deviceDao(){
        return new DeviceDao();
    }

    @Bean
    UserDao userDao() {
        return new UserDao();
    }

    @Bean
    DeviceService deviceService(){
        return new DeviceService(deviceDao());
    }

    @Bean
    LightOnSensorService lightOnSensorService(){
        return new LightOnSensorService(lightOnSensorDao());
    }

    @Bean
    TemperatureSensorService temperatureSensorService(){ return new TemperatureSensorService(temperatureSensoreDao());}

    @Bean
   DeviceCatalogService deviceCatalogService(){
     return new DeviceCatalogService(deviceService(),lightOnSensorService(),temperatureSensorService());
    }

    @Bean
    UserService userService() {
        return new UserService(userDao());
    }


}










