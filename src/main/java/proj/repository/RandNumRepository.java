package proj.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proj.entity.RandNumMessage;

import java.util.Random;

@Repository
public class RandNumRepository {
    private final static Logger log = LoggerFactory.getLogger(RandNumRepository.class);
    static Random rand = new Random();

    public RandNumMessage getRandom() {
        log.info("Repo getRandom()");
        return new RandNumMessage();
    }
}
