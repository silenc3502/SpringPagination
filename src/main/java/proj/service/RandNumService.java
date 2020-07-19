package proj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.RandNumMessage;
import proj.repository.RandNumRepository;

@Service
public class RandNumService {
    static final Logger log = LoggerFactory.getLogger(RandNumService.class);

    @Autowired
    private RandNumRepository repository;

    @Transactional(readOnly = true)
    public RandNumMessage getRandom() {
        log.info("Service getRandom()");

        return repository.getRandom();
    }
}