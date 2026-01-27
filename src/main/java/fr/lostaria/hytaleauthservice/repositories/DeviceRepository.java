package fr.lostaria.hytaleauthservice.repositories;

import fr.lostaria.hytaleauthservice.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {}
