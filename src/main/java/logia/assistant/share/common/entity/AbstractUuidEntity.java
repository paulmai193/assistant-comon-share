package logia.assistant.share.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

/**
 * The Class AbstractUuidEntity.
 *
 * @author Dai Mai
 */
@MappedSuperclass
public abstract class AbstractUuidEntity extends AbstractAuditingEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The uuid. */
    @Size(min = 1, max = 10)
    @Column(length = 10, unique = true, nullable = false)
    private String uuid;
    
    /**
     * Instantiates a new abstract uuid entity.
     */
    public AbstractUuidEntity() {
    }
    
    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
    
    /**
     * Sets the uuid.
     *
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
}
