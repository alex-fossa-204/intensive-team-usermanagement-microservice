package dev.alexfossa.usermanagementmicroservice.controller;

import dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin-management/intensive-user")
public interface IAdministrationManagementController {

    @GetMapping("/all")
    ResponseEntity<List<IntensiveUserDto>> findAllUsersGetRequest() throws ServiceException;

    @PostMapping("/new")
    ResponseEntity<IntensiveUserDto> registerNewUserPostRequest(@RequestBody @Valid IntensiveUserDto intensiveUserDto) throws ServiceException;

    @PatchMapping("/patch/user-info")
    ResponseEntity<IntensiveUserDto> updateUserInfoPatchRequest(@RequestBody @Valid IntensiveUserDto intensiveUserDto) throws ServiceException;

    @DeleteMapping("delete/user-info")
    ResponseEntity<IntensiveUserDto> deleteUserPostRequest(@RequestBody @Valid IntensiveUserDto intensiveUserDto) throws ServiceException;

}
