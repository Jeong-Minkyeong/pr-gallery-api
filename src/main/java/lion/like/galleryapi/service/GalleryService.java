package lion.like.galleryapi.service;

import lion.like.galleryapi.domain.Comment;
import lion.like.galleryapi.domain.CommentRepository;
import lion.like.galleryapi.domain.Image;
import lion.like.galleryapi.domain.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class GalleryService {

    private final CommentRepository CommentRepository;
    private final ImageRepository ImageRepository;

    public Comment save(String imageId, String commentBody){
        Image image = ImageRepository.findByImageId(imageId);
        if (image == null) {
            throw new NoSuchElementException("게시되지 않은 사진입니다");
        }

        Comment comment = new Comment(image, commentBody);
        return CommentRepository.save(comment);
    }

    public List<Comment> CommentAll(String imageId){
        if (ImageRepository.findByImageId(imageId) == null){
            throw new NoSuchElementException("게시되지 않은 사진입니다");
        }
        return CommentRepository.CommentAll(imageId);
    }

    public void deleteCommentById(String imageId, Long id){
        CommentRepository.deleteCommentById(imageId, id);
    }

    public List<Image> imageAll(){
        return ImageRepository.imageAll();
    }

    public int imageSize(){
        return ImageRepository.imageSize();
    }
}
