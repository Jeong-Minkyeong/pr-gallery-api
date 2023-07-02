package lion.like.galleryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lion.like.galleryapi.domain.Comment;
import lion.like.galleryapi.domain.Image;
import lion.like.galleryapi.dto.CommentRequest;
import lion.like.galleryapi.dto.CommentResponse;
import lion.like.galleryapi.service.GalleryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "GalleryController")
@RestController
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @Operation(summary="특정 이미지 댓글 생성", description="특정 이미지의 댓글을 생성합니다.")
    @ApiResponse(code = 200, message="ok")
    @PostMapping("/{imageId}/comments")
    public CommentResponse save(@PathVariable String imageId, @RequestBody CommentRequest request){
        String commentBody = request.getCommentBody();

        Comment comment = galleryService.save(imageId, commentBody);
        return new CommentResponse(comment);
    }

    @Operation(summary="특정 이미지 댓글 조회", description="특정 이미지의 댓글을 조회합니다.")
    @GetMapping("/{imageId}/comments")
    public List<CommentResponse> CommentAll(@PathVariable String imageId){
        return galleryService.CommentAll(imageId)
                .stream()
                .map(comment -> new CommentResponse(comment))
                .toList();
    }

    @Operation(summary="특정 이미지 특정 댓글 삭제", description="특정 이미지의 특정 댓글을 삭제합니다.")
    @DeleteMapping("/{imageId}/comments/{id}")
    public void deleteCommentById(@PathVariable String imageId, @PathVariable Long id){
        galleryService.deleteCommentById(imageId, id);
    }

    @Operation(summary="모든 이미지 불러오기", description="모든 이미지를 불러옵니다.")
    @GetMapping("/imageAll")
    public List<Image> imageAll(){
        return galleryService.imageAll();
    }

    @Operation(summary="이미지 갯수 조회", description="게시된 이미지 갯수를 불러옵니다.")
    @GetMapping("/imageSize")
    public int imageSize(){
        return galleryService.imageSize();
    }
}
