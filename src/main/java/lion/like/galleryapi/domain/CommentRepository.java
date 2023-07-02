package lion.like.galleryapi.domain;

import java.util.List;

public interface CommentRepository {

    public Comment save(Comment comment);

    public List<Comment> CommentAll(String imageId);

    public Comment deleteCommentById(String imageId, Long id);

    public void clearStore();


}
