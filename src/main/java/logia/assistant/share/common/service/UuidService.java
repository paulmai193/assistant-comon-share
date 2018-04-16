package logia.assistant.share.common.service;

import java.util.Optional;

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
    public Optional<T> findByUuid(String uuid);
    
}
