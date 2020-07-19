package proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import proj.entity.CodeDetail;
import proj.service.CodeDetailService;

@Log
@RestController
@RequestMapping("/codedetails")
public class CodeDetailController {
    @Autowired
    private CodeDetailService codeDetailService;

    @RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.GET)
    public ResponseEntity<CodeDetail> read(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception {
        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setGroupCode(groupCode);
        codeDetail.setCodeValue(codeValue);

        return new ResponseEntity<>(codeDetailService.read(codeDetail), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CodeDetail>> list() throws Exception {
        log.info("list");

        return new ResponseEntity<>(codeDetailService.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CodeDetail> register(@Validated @RequestBody CodeDetail codeDetail) throws Exception {
        log.info("register");

        codeDetailService.register(codeDetail);

        log.info("register codeDetail.getCodeClassNo() = " + codeDetail.getGroupCode());
        log.info("register codeDetail.getCodeValue() = " + codeDetail.getCodeValue());

        return new ResponseEntity<>(codeDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception {
        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setGroupCode(groupCode);
        codeDetail.setCodeValue(codeValue);

        codeDetailService.remove(codeDetail);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.PUT)
    public ResponseEntity<CodeDetail> modify(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue, @Validated @RequestBody CodeDetail codeDetail) throws Exception {
        codeDetail.setGroupCode(groupCode);
        codeDetail.setCodeValue(codeValue);

        codeDetailService.modify(codeDetail);

        return new ResponseEntity<>(codeDetail, HttpStatus.OK);
    }
}