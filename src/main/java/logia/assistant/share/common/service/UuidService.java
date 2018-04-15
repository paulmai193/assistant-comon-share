package logia.assistant.share.common.service;


/**
 * The Interface UuidService.
 *
 * @author Dai Mai
 * @param <T> the generic type
 */
public interface UuidService<T> {

    /**
     * Gets the by uuid.
     *
     * @param Uuid the uuid
     * @return the by uuid
     */
    public T getByUuid(String Uuid);
    
}
