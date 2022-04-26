package anchor.book.service;

import anchor.book.entity.*;
import anchor.book.repository.BookRepository;
import anchor.book.repository.ProgressRepository;
import anchor.book.repository.SeriesRepository;
import anchor.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final ProgressRepository progressRepository;

    public Progress getProgressRate(Long bookId, Long userSeq) {
        Progress progress = progressRepository.getProgressRate(bookId, userSeq);

        return (progressRepository.getProgressRate(bookId, userSeq));
    }
}
