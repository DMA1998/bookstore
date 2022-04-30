package com.mykh.bookstore.appuser.admin.service;


import com.mykh.bookstore.appuser.admin.dto.AdminsDTO;
import com.mykh.bookstore.appuser.admin.repository.AppUserAdminRepository;
import com.mykh.bookstore.appuser.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AppUserAdminService {

    private final AppUserAdminRepository appUserAdminRepository;

    @SneakyThrows
    public void setAdmins() {
        AdminsDTO.getAdminDto().getAdmins()
                .forEach(this::enableAdminUser);
    }

    public void enableAdminUser(String email) {
        log.info("Enabling admin for email: {}", email);
        appUserAdminRepository.enableAdminUser(email);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public List<AppUser> findAdmins() {
        log.info("Fetching all admins");
        return appUserAdminRepository.findAllAdmins().get();
    }
}
