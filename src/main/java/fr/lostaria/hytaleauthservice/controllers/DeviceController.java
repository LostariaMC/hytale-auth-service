package fr.lostaria.hytaleauthservice.controllers;

import fr.lostaria.hytaleauthservice.services.DeviceService;
import fr.lostaria.hytaleauthservice.utils.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/generate")
    public ResponseEntity generateToken(
            @RequestParam(name = "deviceToken") String deviceToken,
            HttpServletRequest request
    ) {
        String ip = IpUtils.getClientIp(request);

        if(!deviceService.validateToken(deviceToken, ip)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.generateToken());
    }

}
