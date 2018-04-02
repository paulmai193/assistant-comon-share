package logia.assistant.share.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractUuidEntity extends AbstractAuditingEntity {

    @Size(min = 1, max = 10)
    @Column(length = 10, unique = true, nullable = false)
    private String uuid;
    
    public AbstractUuidEntity() {
    }
    
    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
    
    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
}
