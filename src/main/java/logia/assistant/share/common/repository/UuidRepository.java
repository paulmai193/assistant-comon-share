package logia.assistant.share.common.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import logia.assistant.share.common.entity.AbstractUuidEntity;


/**
 * The Interface UuidRepository.
 *
 * @author Dai Mai
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface UuidRepository<T extends AbstractUuidEntity, ID extends Number> extends JpaRepository<T, ID> {
    
    /**
     * Find one by uuid.
     *
     * @param uuid the uuid
     * @return the optional
     */
    Optional<T> findOneByUuid(String uuid);
    
    /**
     * Gets the one by uuid.
     *
     * @param uuid the uuid
     * @return the one by uuid
     */
    T getOneByUuid(String uuid);
    
    /**
     * Find by uuid is null.
     *
     * @return the list
     */
    List<T> findByUuidIsNull();
    
    /**
     * Find first order by id desc.
     *
     * @return the t
     */
    List<T> findAllByOrderByIdDesc();
    
}
