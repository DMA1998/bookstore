package com.mykh.bookstore.appuser.admin.dto;

import com.mykh.bookstore.util.ObjectMapperHolder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mykh.bookstore.util.Constants;
import lombok.Getter;
import lombok.SneakyThrows;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.mykh.bookstore.util.Constants.ADMINS_JSON_PATH;
import static com.mykh.bookstore.util.ObjectMapperHolder.getObjectMapper;

@Getter
@JsonInclude(NON_NULL)
@JsonIgnoreProperties("comment")
public class AdminsDTO {

    private static AdminsDTO instance = null;

    @JsonProperty("admins")
    private List<String> admins;

    @SneakyThrows
    public static AdminsDTO getAdminDto() {
        if (Objects.isNull(instance)) {
            instance = getObjectMapper().readValue(Paths.get(
                            ADMINS_JSON_PATH).toFile(),
                            AdminsDTO.class);
        }
        return instance;
    }
}
