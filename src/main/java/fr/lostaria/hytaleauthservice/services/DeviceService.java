package fr.lostaria.hytaleauthservice.services;

import fr.lostaria.hytaleauthservice.entities.Device;
import fr.lostaria.hytaleauthservice.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateToken() {
        String deviceId = UUID.randomUUID().toString();

        byte[] bytes = new byte[32];
        RANDOM.nextBytes(bytes);
        String secret = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);

        return deviceId + ":" + secret;
    }

    public boolean validateToken(String token, String ip) {
        return deviceRepository.findById(token)
                .filter(Device::isEnable)
                .filter(device ->
                        "0.0.0.0".equals(device.getIp()) || device.getIp().equals(ip)
                )
                .isPresent();
    }

}
