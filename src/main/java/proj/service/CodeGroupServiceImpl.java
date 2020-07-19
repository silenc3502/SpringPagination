package proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import proj.entity.CodeGroup;
import proj.repository.CodeGroupRepository;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {
    @Autowired
    private CodeGroupRepository repository;

    @Override
    public void register(CodeGroup codeGroup) throws Exception {
        repository.save(codeGroup);
    }

    @Override
    public CodeGroup read(String groupCode) throws Exception {
        return repository.getOne(groupCode);
    }

    @Override
    public void modify(CodeGroup codeGroup) throws Exception {
        CodeGroup codeGroupEntity = repository.getOne(codeGroup.getGroupCode());

        codeGroupEntity.setGroupName(codeGroup.getGroupName());

        repository.save(codeGroupEntity);
    }

    @Override
    public void remove(String groupCode) throws Exception {
        repository.deleteById(groupCode);
    }

    @Override
    public List<CodeGroup> list() throws Exception {
        return repository.findAll(Sort.by(Direction.DESC, "groupCode"));
    }
}