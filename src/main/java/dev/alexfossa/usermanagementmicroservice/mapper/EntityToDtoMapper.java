package dev.alexfossa.usermanagementmicroservice.mapper;

public interface EntityToDtoMapper<E, D> {

    D mapEntityToDto(E entity);

}
