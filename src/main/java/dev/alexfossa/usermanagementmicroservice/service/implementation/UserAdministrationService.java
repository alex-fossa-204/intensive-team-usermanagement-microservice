package dev.alexfossa.usermanagementmicroservice.service.implementation;

import dev.alexfossa.usermanagementmicroservice.mapper.implementation.IntensiveUserToIntensiveUserDtoMapper;
import dev.alexfossa.usermanagementmicroservice.model.IntensiveUser;
import dev.alexfossa.usermanagementmicroservice.model.IntensiveUserCredential;
import dev.alexfossa.usermanagementmicroservice.repository.IntensiveUserCredentialRepository;
import dev.alexfossa.usermanagementmicroservice.repository.IntensiveUserRepository;
import dev.alexfossa.usermanagementmicroservice.repository.RoleRepository;
import dev.alexfossa.usermanagementmicroservice.service.IUserAdministrationService;
import dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto;
import dev.alexfossa.usermanagementmicroservice.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserAdministrationService implements IUserAdministrationService {

    private final IntensiveUserCredentialRepository intensiveUserCredentialRepository;

    private final IntensiveUserRepository intensiveUserRepository;

    private final RoleRepository roleRepository;

    private final IntensiveUserToIntensiveUserDtoMapper intensiveUserToIntensiveUserDtoMapper;

    @Override
    public List<IntensiveUserDto> findAllUsers() throws ServiceException {
        List<IntensiveUserCredential> intensiveUserEntityList = intensiveUserCredentialRepository.findAll();
        if(intensiveUserEntityList == null) {
            throw new ServiceException("Empty Result Set for find all users...");
        }
        return intensiveUserEntityList.stream()
                .map(intensiveUser -> intensiveUserToIntensiveUserDtoMapper.mapEntityToDto(intensiveUser))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public IntensiveUserDto registerNewUser(IntensiveUserDto intensiveUserDto) throws ServiceException {
        Optional<IntensiveUserCredential> intensiveUserCredentialOptional = intensiveUserCredentialRepository.findIntensiveUserCredentialByUsername(intensiveUserDto.getUsername());
        if(intensiveUserCredentialOptional.isPresent()) {
            throw new ServiceException(String.format("Username already exists. username = %s", intensiveUserDto.getUsername()));
        }
        IntensiveUser intensiveUser = IntensiveUser.builder()
                .firstname(intensiveUserDto.getFirstname())
                .surname(intensiveUserDto.getFirstname())
                .lastname(intensiveUserDto.getFirstname())
                .dateOfBirth(intensiveUserDto.getDateOfBirth())
                .location(intensiveUserDto.getLocation())
                .userUuid(UUID.randomUUID())
                .build();
        IntensiveUserCredential intensiveUserCredential = IntensiveUserCredential.builder()
                .username(intensiveUserDto.getUsername())
                .password("")
                .registrationDate(LocalDate.now())
                .isNonLocked(true)
                .isActive(true)
                .isCredentialNonExpired(true)
                .intensiveUserEntity(intensiveUser)
                .roles(Set.of(roleRepository.findRoleByRoleName("TRAINEE-USER").orElseThrow(() -> new ServiceException(String.format("Role not found. roleName = %s", "TRAINEE-USER")))))
                .build();
        intensiveUserCredential = intensiveUserCredentialRepository.save(intensiveUserCredential);
        return intensiveUserToIntensiveUserDtoMapper.mapEntityToDto(intensiveUserCredential);
    }

    @Override
    public IntensiveUserDto updateUserInfo(IntensiveUserDto intensiveUserDto) throws ServiceException {
        IntensiveUserCredential intensiveUserCredential = intensiveUserCredentialRepository.findIntensiveUserCredentialByUsername(intensiveUserDto.getUsername())
                .orElseThrow(() -> new ServiceException(String.format("User Credential not found: username = %s", intensiveUserDto.getUsername())));
        intensiveUserCredential.setIntensiveUserEntity(populateIntensiveUserFields(intensiveUserCredential.getIntensiveUserEntity(), intensiveUserDto));
        intensiveUserCredential = intensiveUserCredentialRepository.save(intensiveUserCredential);
        return intensiveUserToIntensiveUserDtoMapper.mapEntityToDto(intensiveUserCredential);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public IntensiveUserDto deleteUser(IntensiveUserDto intensiveUserDto) throws ServiceException {
        IntensiveUserCredential intensiveUserCredential = intensiveUserCredentialRepository.findIntensiveUserCredentialByUsername(intensiveUserDto.getUsername())
                .orElseThrow(() -> new ServiceException(String.format("User Credential not found: username = %s", intensiveUserDto.getUsername())));
        intensiveUserRepository.deleteById(intensiveUserCredential.getIntensiveUserEntity().getId());
        return intensiveUserToIntensiveUserDtoMapper.mapEntityToDto(intensiveUserCredential);
    }

    private IntensiveUser populateIntensiveUserFields(IntensiveUser intensiveUser, IntensiveUserDto intensiveUserDto) {
        intensiveUser.setFirstname(intensiveUserDto.getFirstname());
        intensiveUser.setSurname(intensiveUserDto.getSurname());
        intensiveUser.setLastname(intensiveUserDto.getLastname());
        intensiveUser.setDateOfBirth(intensiveUserDto.getDateOfBirth());
        intensiveUser.setLocation(intensiveUserDto.getLocation());
        return intensiveUser;
    }
}
