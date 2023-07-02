package lion.like.galleryapi.domain;

import java.util.List;

public interface ImageRepository {

    public List<Image> imageAll();

    public Image findByImageId(String imageId);

    public int imageSize();

    public void clearStore();
}
