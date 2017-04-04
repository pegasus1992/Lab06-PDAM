package co.edu.pdam.eci.persistenceapiintegration.data.entity;

import com.j256.ormlite.field.DatabaseField;

/**
 * @author Santiago Carrillo
 */

//TODO add database annotations and proper model structure
public class Team extends BaseEntity {
    @DatabaseField
    String name;
    @DatabaseField
    String shortName;
    @DatabaseField
    String imageUrl;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
