package com.it.academy.webapp.controller;
import com.it.academy.domain.Device;
import com.it.academy.service.DeviceService;
import com.it.academy.service.catalog.DeviceCatalogService;
import com.it.academy.data.entity.DeviceEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller

public class DeviceCatalogPageController {

private static Logger logger = Logger.getLogger("DeviceCatalogPageController");

  @Autowired
   DeviceCatalogService deviceCatalogService;

    @RequestMapping(value = "/catalogPage",method = RequestMethod.GET)
    public String showTheCatalogPage(Model model){
        logger.info("Showing the catalog page");
        List<Device> devices = deviceCatalogService.getAllDevices();
        model.addAttribute("devices", devices);
        return "catalogPage";
    }

    @RequestMapping(value = "catalogPage/sortedCatalogPage")
    public String showSortedDevices(Model model){
        List<Device> devices = deviceCatalogService.gerSortedDevices();
        model.addAttribute("devices",devices );
        return "catalogPage";
    }


}
