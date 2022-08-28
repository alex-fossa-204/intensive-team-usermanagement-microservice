package dev.alexfossa.usermanagementmicroservice.service;

import dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;

import java.util.List;

public interface IUserAdministrationService {

    List<IntensiveUserDto> findAllUsers() throws ServiceException;

    IntensiveUserDto registerNewUser(IntensiveUserDto intensiveUserDto) throws ServiceException;

    IntensiveUserDto updateUserInfo(IntensiveUserDto intensiveUserDto) throws ServiceException;

    IntensiveUserDto deleteUser(IntensiveUserDto intensiveUserDto) throws ServiceException;


}
