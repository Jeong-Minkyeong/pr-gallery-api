package lion.like.galleryapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Image {

    private String id;
    private final String imageURL;
    private final String imageName;
    private final String imageText;

    public Image(String id, String imageURL, String imageName, String imageText) {
        this.id = id;
        this.imageURL = imageURL;
        this.imageName = imageName;
        this.imageText = imageText;
    }
}
