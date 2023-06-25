package GupangMSA.userservice.domain;

import lombok.Getter;

import java.util.List;

/*
        <UserReview>
        - 리뷰 작성자 id
        - 리뷰 상품 id
        - 리뷰 타이틀
        - 리뷰 내용
        - 리뷰 사진 url들
        - 리뷰 작성 시간
     */
@Getter
public class UserReview {

    private final Long reviewUserId;
    private final Long reviewItemId;
    private final String title;
    private final String description;
    private final List<String> photoUrls;
    private final Long createdAt;

    public UserReview(Long reviewUserId, Long reviewItemId, String title,
                      String description, List<String> photoUrls, Long createdAt) {
        this.reviewUserId = reviewUserId;
        this.reviewItemId = reviewItemId;
        this.title = title;
        this.description = description;
        this.photoUrls = photoUrls;
        this.createdAt = createdAt;
    }
}
