package GupangMSA.userservice.service.port;

import GupangMSA.userservice.domain.UserReview;

import java.util.List;

public interface ExternalReviewRepository {

    List<UserReview> getUserReviews(Long id);

}
