package cmpe275.dos.dao;

import cmpe275.dos.entity.MpaaRating;
import org.springframework.data.repository.CrudRepository;

public interface MpaaRatingDao extends CrudRepository<MpaaRating, Integer> {
    MpaaRating findMpaaRatingByMpaaId(Integer mpaaRating);
}
