package logia.assistant.share.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface EntityService.
 *
 * @author Dai Mai
 * @param <D> the generic type
 * @param <E> the element type
 * @param <K> the ID type
 */
public interface EntityService<D, E, K extends Serializable> {
    
    /**
     * Save the entity.
     *
     * @param dto the entity mapped to DTO
     * @return the saved entity mapped to DTO
     */
    D saveDto(D dto);
    
    /**
     * Save the entity.
     *
     * @param entity the entity
     * @return the saved entity
     */
    E saveEntity(E entity);
    
    /**
     * Find all entities.
     *
     * @return the list entities mapped to DTOs
     */
    List<D> findAllDtos();
    
    /**
     * Find all entities.
     *
     * @return the list entities
     */
    List<E> findAllEntities();
    
    /**
     * Find the "id" entity mapped to DTO.
     *
     * @param id the id
     * @return the DTO
     */
    D findOneDto(K id);
    
    /**
     * Find the "id" entity.
     *
     * @param id the id
     * @return the entity
     */
    E findOneEntity(K id);
    
    /**
     * Delete the "id" entity.
     *
     * @param id the id
     */
    void delete(K id);
    
    /**
     * Search for the entities corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities mapped to DTOs
     */
    List<D> search(String query);
    
    /**
     * Map entity to DTO.
     *
     * @param entity the entity
     * @return the DTO
     */
    D mapToDto(E entity);
    
    /**
     * Map list entities to list DTOs.
     *
     * @param entities the entities
     * @return the list mapped DTOs
     */
    List<D> mapToDtos(List<E> entities);
    
    /**
     * Map DTO to entity.
     *
     * @param dto the DTO
     * @return the entity
     */
    E mapToEntity(D dto);
    
    /**
     * Map list DTOs to list entities.
     *
     * @param dtos the DTOs
     * @return the list mapped entities
     */
    List<E> mapToEntities(List<D> dtos);
}
