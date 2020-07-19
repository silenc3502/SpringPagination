package proj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Member;
import proj.entity.MemberAuth;
import proj.repository.MemberAuthRepository;

@Service
public class MemberAuthService {
    static final Logger log = LoggerFactory.getLogger(MemberAuthService.class);

    @Autowired
    MemberAuthRepository authRepository;

    public MemberAuth read(Long userNo) throws Exception {
        log.info("MemberAuth Service read()");
        return authRepository.checkAuth(userNo);
    }
}
