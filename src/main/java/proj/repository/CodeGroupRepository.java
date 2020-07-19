package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.CodeGroup;

public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {

}