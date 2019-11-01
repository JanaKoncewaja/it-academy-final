package com.it.academy.webapp;
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
public class CatalogPageController {

private static Logger logger = Logger.getLogger("CatalogPageController");

   @Autowired
   DeviceCatalogService deviceCatalogService;

    @RequestMapping(method = RequestMethod.GET)
    public String showTheHomePage(Model model){
        logger.info("Showing the catalog page");
        List<DeviceEntity> devices = deviceCatalogService.getAllDevices();
        model.addAttribute("devices", devices);
        return "catalogPage";
    }

}
