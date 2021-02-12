
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface buddyInfoRepository extends CrudRepository<BuddyInfo, Integer>{

    List<BuddyInfo> findByLastName(String lastName);

    BuddyInfo findById(int id);
}
