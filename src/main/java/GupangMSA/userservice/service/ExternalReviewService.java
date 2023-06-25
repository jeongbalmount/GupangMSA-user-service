package GupangMSA.userservice.service;

import GupangMSA.userservice.domain.UserReview;
import GupangMSA.userservice.service.port.ExternalReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*
        1. UserReviewReceiver를 통해 UserReview들을 가져온다.
        2. 이 서비스에서 그냥 Resttemplate로 리뷰들 가져온다.
        -> 1번 선택, 왜냐하면 service의 인터페이스를 만들지 않겠다고 선언했기 때문에
        UserReviewReceiver라는 인터페이스의 도움을 받아 데이터를 받아야 한다.
     */
@Service
@RequiredArgsConstructor
public class ExternalReviewService {

    private final ExternalReviewRepository externalReviewRepository;

    public List<UserReview> getUserReviews(Long id) {
        return externalReviewRepository.getUserReviews(id);
    }



}
