package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.UserReview;
import GupangMSA.userservice.mock.repository.FakeExternalReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ExternalReviewServiceTest {

    private ExternalReviewService externalReviewService;

    @BeforeEach
    void init() {
        List<UserReview> userReviews = new ArrayList<>();
        UserReview userReview = UserReview.builder()
                .reviewUserId(1L)
                .reviewItemId(1L)
                .title("title")
                .description("description")
                .photoUrls(List.of(new String[]{"url1", "url2", "url3"}))
                .createdAt(10000L)
                .build();
        UserReview userReview2 = UserReview.builder()
                .reviewUserId(1L)
                .reviewItemId(2L)
                .title("title2")
                .description("description2")
                .photoUrls(List.of(new String[]{"url11", "url22", "url33"}))
                .createdAt(20000L)
                .build();
        UserReview userReview3 = UserReview.builder()
                .reviewUserId(1L)
                .reviewItemId(3L)
                .title("title3")
                .description("description3")
                .photoUrls(List.of(new String[]{"url111", "url222", "url333"}))
                .createdAt(30000L)
                .build();
        userReviews.add(userReview);
        userReviews.add(userReview2);
        userReviews.add(userReview3);

        this.externalReviewService = new ExternalReviewService(new FakeExternalReviewRepository(userReviews));
    }

    @Test
    void getUserReviews를_통해_해당_회원이_작성한_리뷰들을_가져올_수_있다() {
        // given

        // when
        List<UserReview> userReviews = externalReviewService.getUserReviews(1L);

        // then
        Assertions.assertThat(userReviews.get(0).getReviewUserId()).isEqualTo(1L);
        Assertions.assertThat(userReviews.get(0).getReviewItemId()).isEqualTo(1L);

        Assertions.assertThat(userReviews.get(1).getReviewUserId()).isEqualTo(1L);
        Assertions.assertThat(userReviews.get(1).getReviewItemId()).isEqualTo(2L);

        Assertions.assertThat(userReviews.get(2).getReviewUserId()).isEqualTo(1L);
        Assertions.assertThat(userReviews.get(2).getReviewItemId()).isEqualTo(3L);
    }

}
