package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.model.Section;

import java.util.List;


@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {

    @Query(" select b from Block b join Section s where s.capacity > 0")
    List<Block> findAvailableBlocks();
}
