package proj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Member;
import proj.entity.MemberAuth;
import proj.repository.MemberRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        Member memberEntity = new Member();
        memberEntity.setUserId(member.getUserId());
        memberEntity.setUserPw(member.getUserPw());
        memberEntity.setUserName(member.getUserName());
        memberEntity.setJob(member.getJob());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memberEntity.addAuth(memberAuth);

        repository.save(memberEntity);

        member.setUserNo(memberEntity.getUserNo());
    }

    @Override
    public Member read(Long userNo) throws Exception {
        log.info("Member Service read()");
        return repository.getOne(userNo);
    }

    @Override
    public void modify(Member member) throws Exception {
        Member memberEntity = repository.getOne(member.getUserNo());
        memberEntity.setUserName(member.getUserName());
        memberEntity.setJob(member.getJob());

        List<MemberAuth> memberAuthList = memberEntity.getAuthList();
        List<MemberAuth> authList = member.getAuthList();
        for(int i = 0; i < authList.size(); i++) {
            MemberAuth auth = authList.get(i);

            if(i < memberAuthList.size()) {
                MemberAuth memberAuth = memberAuthList.get(i);
                memberAuth.setAuth(auth.getAuth());
            }
        }

        repository.save(memberEntity);
    }

    @Override
    public void remove(Long userNo) throws Exception {
        repository.deleteById(userNo);
    }

    @Override
    public List<Member> list() throws Exception {
        List<Object[]> valueArrays = repository.listAllMember();

        List<Member> memberList = new ArrayList<Member>();
        for(Object[] valueArray : valueArrays) {
            Member member = new Member();

            member.setUserNo((Long)valueArray[0]);
            member.setUserId((String)valueArray[1]);
            member.setUserPw((String)valueArray[2]);
            member.setUserName((String)valueArray[3]);
            member.setJob((String)valueArray[4]);
            member.setCoin((int)valueArray[5]);
            member.setRegDate((Date)valueArray[6]);

            memberList.add(member);
        }

        return memberList;
    }

    @Override
    public long countAll() throws Exception {
        return repository.count();
    }

    @Override
    public void setupAdmin(Member member) throws Exception {
        Member memberEntity = new Member();
        memberEntity.setUserId(member.getUserId());
        memberEntity.setUserPw(member.getUserPw());
        memberEntity.setUserName(member.getUserName());
        memberEntity.setJob(member.getJob());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_ADMIN");

        memberEntity.addAuth(memberAuth);

        repository.save(memberEntity);
    }
}
