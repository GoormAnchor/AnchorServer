package anchor.book.repository;

import anchor.book.entity.Episode;
import anchor.book.entity.EpisodeId;
import org.springframework.data.jpa.repository.JpaRepository;
/*
data jpa 리포지토리 상속 -> 따로 설정할 필요 x
 */
public interface EpisodeRepository extends JpaRepository<Episode, EpisodeId> {
}