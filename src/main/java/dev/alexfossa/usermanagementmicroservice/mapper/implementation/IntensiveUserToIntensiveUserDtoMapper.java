package dev.alexfossa.usermanagementmicroservice.mapper.implementation;

import dev.alexfossa.usermanagementmicroservice.mapper.EntityToDtoMapper;
import dev.alexfossa.usermanagementmicroservice.model.IntensiveUserCredential;
import dev.alexfossa.usermanagementmicroservice.service.dto.IntensiveUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IntensiveUserToIntensiveUserDtoMapper extends EntityToDtoMapper<IntensiveUserCredential, IntensiveUserDto> {

    @Mapping(target = "userUuid", source = "intensiveUserEntity.userUuid")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "firstname", source = "intensiveUserEntity.firstname")
    @Mapping(target = "surname", source = "intensiveUserEntity.surname")
    @Mapping(target = "lastname", source = "intensiveUserEntity.lastname")
    @Mapping(target = "dateOfBirth", source = "intensiveUserEntity.dateOfBirth")
    @Mapping(target = "location", source = "intensiveUserEntity.location")
    @Override
    IntensiveUserDto mapEntityToDto(IntensiveUserCredential entity);

}
