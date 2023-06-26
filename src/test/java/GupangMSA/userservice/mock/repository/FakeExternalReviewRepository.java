package GupangMSA.userservice.mock.repository;

import GupangMSA.userservice.domain.UserReview;
import GupangMSA.userservice.service.port.ExternalReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class FakeExternalReviewRepository implements ExternalReviewRepository {

    private final List<UserReview> data;

    @Override
    public List<UserReview> getUserReviews(Long id) {
        return data;
    }
}
