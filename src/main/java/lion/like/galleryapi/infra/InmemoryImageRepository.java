package lion.like.galleryapi.infra;

import lion.like.galleryapi.domain.Image;
import lion.like.galleryapi.domain.ImageRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InmemoryImageRepository implements ImageRepository {

    private Map<String, Image> store = new HashMap<>();

    ArrayList<String> imageIds = new ArrayList<>(Arrays.asList("image1", "image2", "image3", "image4", "image5", "image6", "image7", "image8"));
    ArrayList<String> imageUrls = new ArrayList<>(Arrays.asList(
            "https://user-images.githubusercontent.com/72567631/248823029-6706e21a-a160-4576-adde-d8ae5235f303.jpg",
            "https://user-images.githubusercontent.com/72567631/248823048-67485812-0a0f-4309-8658-2f75d06ee94e.jpg",
            "https://user-images.githubusercontent.com/72567631/248823060-30c68f36-def9-44d5-8a8f-0051979a20ba.jpg",
            "https://user-images.githubusercontent.com/72567631/248823070-a9ddafc5-abbc-4cef-9ffd-ee658dfd2bcf.jpg",
            "https://user-images.githubusercontent.com/72567631/248823080-b2dd7413-eb1e-4993-bea6-37a8695a4634.jpg",
            "https://user-images.githubusercontent.com/72567631/248823087-37351c99-6c5e-4bef-b6b2-062121b76c19.jpg",
            "https://user-images.githubusercontent.com/72567631/248823091-021849ec-ba08-4ab8-abce-e136b55b1927.jpg",
            "https://user-images.githubusercontent.com/72567631/248823095-87d3817c-2357-4f5e-b080-e7e2386a8460.jpg"
    ));
    ArrayList<String> imageNames = new ArrayList<>(Arrays.asList(
            "멋쟁이 사자처럼 Coming Soon",
            "멋쟁이 사자처럼 at 인하대학교 11기 모집",
            "멋쟁이 사자처럼 at 인하대학교 동아리 소개",
            "멋쟁이 사자처럼 at 11기 커리큘럽 - 프론트엔드",
            "멋쟁이 사자처럼 at 11기 커리큘럽 - 백엔드",
            "서류 제출 D-3",
            "서류 제출 D-1",
            "서류 제출 D-DAY"
    ));
    ArrayList<String> imageTexts = new ArrayList<>(Arrays.asList(
            "멋쟁이 사자처럼 11기 Coming Soon",
            "1년간 즐겁게 활동할 아기사자들을 모집합니다!",
            "예비 아기사자들을 위해 소개글을 준비했습니다!",
            "프론트엔드 커리큘럽 소개",
            "백엔드 커리큘럼 소개",
            "서류 마감일이 얼마 남지 않았습니다",
            "서류 마감 전날입니다",
            "늦지 않게 제출 부탁 드려요!"

    ));
    int arraySize = imageUrls.size();

    public List<Image> imageAll(){
        for (int i = 0; i < arraySize; i++){
            Image image = new Image(imageIds.get(i), imageUrls.get(i), imageNames.get(i), imageTexts.get(i));
            store.put(image.getId(), image);
        }

        return store.values()
                .stream()
                .toList();
    }

    public Image findByImageId(String imageId){
        return store.get(imageId);
    }

    public int imageSize(){
        return arraySize;
    }

    public void clearStore(){
        store.clear();
    }
}
