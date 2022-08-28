package dev.alexfossa.usermanagementmicroservice.controller.implementation;

import dev.alexfossa.usermanagementmicroservice.config.aop.ControllerExceptionHandlerAdvice;
import dev.alexfossa.usermanagementmicroservice.controller.IAdministrationManagementController;
import dev.alexfossa.usermanagementmicroservice.service.IUserAdministrationService;
import dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
public class AdministrationManagementController extends ControllerExceptionHandlerAdvice implements IAdministrationManagementController {

    private final IUserAdministrationService iUserAdministrationService;

    @Override
    public ResponseEntity<List<IntensiveUserDto>> findAllUsersGetRequest() throws ServiceException {
        return new ResponseEntity<>(iUserAdministrationService.findAllUsers(), OK);
    }

    @Override
    public ResponseEntity<IntensiveUserDto> registerNewUserPostRequest(IntensiveUserDto intensiveUserDto) throws ServiceException {
        return new ResponseEntity<>(iUserAdministrationService.registerNewUser(intensiveUserDto), OK);
    }

    @Override
    public ResponseEntity<IntensiveUserDto> updateUserInfoPatchRequest(IntensiveUserDto intensiveUserDto) throws ServiceException {
        return new ResponseEntity<>(iUserAdministrationService.updateUserInfo(intensiveUserDto), OK);
    }

    @Override
    public ResponseEntity<IntensiveUserDto> deleteUserPostRequest(IntensiveUserDto intensiveUserDto) throws ServiceException {
        return new ResponseEntity<>(iUserAdministrationService.deleteUser(intensiveUserDto), OK);
    }

}
