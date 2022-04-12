package anchor.book.repository;

import anchor.book.entity.Episode;
import anchor.book.entity.EpisodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, EpisodeId> {
}