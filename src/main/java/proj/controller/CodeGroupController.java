package proj.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proj.entity.CodeGroup;
import proj.service.CodeGroupService;

import java.util.List;

@Log
@RestController
@RequestMapping("/codegroups")
public class CodeGroupController {
    @Autowired
    private CodeGroupService service;

    @RequestMapping(value = "/{groupCode}", method = RequestMethod.GET)
    public ResponseEntity<CodeGroup> read(@PathVariable("groupCode") String groupCode) throws Exception {
        CodeGroup codeGroup = service.read(groupCode);

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CodeGroup>> list() throws Exception {
        log.info("list");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CodeGroup> register(@Validated @RequestBody CodeGroup codeGroup) throws Exception {
        log.info("register");

        service.register(codeGroup);

        log.info("register codeGroup.getCodeGroupNo() = " + codeGroup.getGroupCode());

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }

    @RequestMapping(value = "/{groupCode}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(@PathVariable("groupCode") String groupCode) throws Exception {
        service.remove(groupCode);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{groupCode}", method = RequestMethod.PUT)
    public ResponseEntity<CodeGroup> modify(@PathVariable("groupCode") String groupCode, @Validated @RequestBody CodeGroup codeGroup) throws Exception {
        codeGroup.setGroupCode(groupCode);
        service.modify(codeGroup);

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }
}