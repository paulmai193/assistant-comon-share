package logia.assistant.share.common.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import logia.assistant.share.common.utils.UuidBuilder;

/**
 * The Interface UuidService.
 *
 * @author Dai Mai
 * @param <T> the generic type
 */
public interface UuidService<T> {

    /**
     * Find by UUID.
     *
     * @param uuid the UUID
     * @return the by UUID
     */
    Optional<T> findByUuid(String uuid);
    
    /**
     * Creates the UUID. UUID will be created by next value of auto generated ID
     *
     * @param entity the entity
     * @return the t
     */
    T createUuid(T entity);
    
    /**
     * Creates the UUID base on materials.
     *
     * @param materials the materials
     * @return the string
     */
    default String createUuid(Object... materials) {
        UuidBuilder builder = new UuidBuilder();
        builder.setMaterials(Stream.of(materials).map(material -> material.toString()).collect(Collectors.toList()));
        return builder.build();
    }
    
}
