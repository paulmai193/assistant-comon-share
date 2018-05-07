package logia.assistant.share.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Base64Utils;

/**
 * The Class UuidBuilder.
 *
 * @author Dai Mai
 */
public class UuidBuilder {
    
    /** The materials. */
    private List<String> materials = new ArrayList<>();
    
    
    /**
     * Sets the materials.
     *
     * @param materials the materials to set
     */
    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    /**
     * Append.
     *
     * @param material the material
     * @return the uuid builder
     */
    public UuidBuilder appendMaterial(Object material) {
        this.materials.add(material.toString());
        return this;
    }
    
    /**
     * Builds the.
     *
     * @return the string
     */
    public String build() {
        StringBuilder s = new StringBuilder();
        this.materials.forEach(m -> s.append(m + "-"));
        try {
            String encode = EncryptionUtils.encode(s.toString(), this.materials.get(0));
            String base = Base64Utils.encodeToUrlSafeString(encode.getBytes());
            return base;
        }
        catch (Exception e) {
            return "null";
        }
    }
}
