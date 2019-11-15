package com.it.academy.webapp.controller;

import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.domain.Device;
import com.it.academy.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/addDevice")
public class AddDeviceController {

    @Autowired
    DeviceService deviceService;

    Logger log =Logger.getLogger("AddDeviceController");

    @GetMapping
    public String getAddPage(){
        log.info("Showing the addProductPage");
        return "addDevice";
    }


    @PostMapping
    public String addNewDevice(@ModelAttribute DeviceEntity device){
        log.info("Adding DEVICE");
        deviceService.save(device);
        return "redirect:/home";
    }

}
