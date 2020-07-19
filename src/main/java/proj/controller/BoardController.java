package proj.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import proj.entity.Board;
import proj.service.BoardService;

import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {
    @Autowired
    private BoardService service;

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
    public ResponseEntity<Board> read(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("read: " + boardNo);

        Board board = service.read(boardNo);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Board>> list() throws Exception {
        log.info("list");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Board> register(
            @Validated @RequestBody Board board,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("register");

        service.register(board);

        log.info("register board.getBoardNo() = " + board.getBoardNo());

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") String boardNo) throws Exception {
        log.info("remove");

        service.remove(Long.parseLong(boardNo));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
    public ResponseEntity<Board> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody Board board) throws Exception {
        log.info("modify");

        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
