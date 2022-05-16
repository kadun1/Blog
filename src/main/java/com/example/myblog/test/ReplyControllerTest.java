package com.example.myblog.test;

import com.example.myblog.model.Board;
import com.example.myblog.model.Reply;
import com.example.myblog.repository.BoardRepository;
import com.example.myblog.repository.ReplyRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyControllerTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepsitory replyRepsitory;

    @GetMapping("/test/board/{id}")
    public Board getBoard(@PathVariable int id){
        return boardRepository.findById(id).get(); // jackson 라이브러리 (오브젝트를 json으로 리턴) => 모델의 getter를 호출
    }

    @GetMapping("/test/reply")
    public List<Reply> getReply(){
        return replyRepsitory.findAll(); // jackson 라이브러리 (오브젝트를 json으로 리턴) => 모델의 getter를 호출
    }
}