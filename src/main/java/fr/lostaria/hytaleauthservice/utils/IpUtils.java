package fr.lostaria.hytaleauthservice.utils;

import jakarta.servlet.http.HttpServletRequest;

public final class IpUtils {

    public static String getClientIp(HttpServletRequest request) {
        String xf = request.getHeader("X-Forwarded-For");

        if (xf != null && !xf.isBlank()) {
            return xf.split(",")[0].trim();
        }

        return request.getRemoteAddr();
    }

}
