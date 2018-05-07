package logia.assistant.share.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

/**
 * The Class AbstractUuidEntity.
 *
 * @author Dai Mai
 * @param <ID>
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractUuidEntity extends AbstractAuditingEntity implements IEntity {

    /** The uuid. */
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = true)
    private String            uuid;

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
        return this.uuid;
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
