package dtos;

import java.util.Objects;

public class DrinkDTO {
    int id;
    String name;
    String tagLine;
    Float abv;

    String description;

    String image_url;

    public DrinkDTO(int id, String name, String tagLine, Float abv, String description, String image_url) {
        this.id = id;
        this.name = name;
        this.tagLine = tagLine;
        this.abv = abv;
        this.description = description;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public Float getAbv() {
        return abv;
    }

    public void setAbv(Float abv) {
        this.abv = abv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrinkDTO)) return false;
        DrinkDTO drinkDTO = (DrinkDTO) o;
        return getId() == drinkDTO.getId() && getName().equals(drinkDTO.getName());
    }

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", abv=" + abv +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
