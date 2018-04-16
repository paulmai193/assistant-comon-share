package logia.assistant.share.common.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import logia.assistant.share.common.utils.UuidUtils;

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
    @Column(length = 10, unique = true, nullable = true)
    private String uuid;
    
    /**
     * Instantiates a new abstract uuid entity.
     */
    public AbstractUuidEntity() {
        this.uuid = UuidUtils.newSecureUUIDString();
    }
    
    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        if (Objects.isNull(this.uuid)) {
            this.setUuid(UuidUtils.newSecureUUIDString());
        }
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
