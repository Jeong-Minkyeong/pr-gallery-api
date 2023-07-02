package lion.like.galleryapi.dto;

import lion.like.galleryapi.domain.Comment;
import lion.like.galleryapi.domain.Image;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {

    private Long id;
    private String imageId;
    private final String commentBody;
    private final LocalDateTime createdAt;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.imageId = comment.getImage().getId();
        this.commentBody = comment.getCommentBody();
        this.createdAt = comment.getCreatedAt();
    }
}
