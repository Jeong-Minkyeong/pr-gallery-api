package lion.like.galleryapi.infra;

import lion.like.galleryapi.domain.Comment;
import lion.like.galleryapi.domain.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InmemoryCommentRepository implements CommentRepository {

    private Map<Long, Comment> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Comment save(Comment comment){
        comment.setId(++sequence);
        store.put(comment.getId(), comment);
        return comment;
    }

    @Override
    public List<Comment> CommentAll(String imageId){
        return store.values()
                .stream()
                .filter(comment -> comment.getImage().getId().equals(imageId))
                .toList();
    }

    @Override
    public Comment deleteCommentById(String imageId, Long id){
        return store.remove(id);
    }

    @Override
    public void clearStore(){
        store.clear();
    }
}
