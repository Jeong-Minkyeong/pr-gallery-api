package lion.like.galleryapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Comment {

    public static final int MAX_COMMENT_LENGTH = 50;
    private Long id;
    private Image image;
    private final String commentBody;
    private final LocalDateTime createdAt;

    public Comment(Image image, String commentBody) {
        this.image = image;
        this.commentBody = commentBody;
        this.createdAt = LocalDateTime.now();

        validateCommentBody(commentBody);
    }

    // 예외처리
    private void validateCommentBody(String commentBody){
        if(commentBody == null){
            throw new IllegalArgumentException("댓글을 작성해주세요");
        }

        if (commentBody.length() > MAX_COMMENT_LENGTH){
            throw new IllegalArgumentException("작성할 수 있는 글자수를 초과했습니다(글자수 50)");
        }
    }
}
