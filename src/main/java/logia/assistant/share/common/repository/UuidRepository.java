package logia.assistant.share.common.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The Interface UuidRepository.
 *
 * @author Dai Mai
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface UuidRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    
    /**
     * Find one by uuid.
     *
     * @param uuid the uuid
     * @return the optional
     */
    Optional<T> findOneByUuid(String uuid);
    
}
