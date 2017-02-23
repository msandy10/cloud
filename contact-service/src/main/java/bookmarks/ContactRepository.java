package bookmarks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ContactRepository extends JpaRepository<Contact, Long> {

	Contact findByUserIdAndId(String userId, Long id);

    List<Contact> findByUserId(String userId);
}