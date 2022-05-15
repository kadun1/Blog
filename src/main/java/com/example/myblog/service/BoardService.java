package com.example.myblog.service;

import com.example.myblog.dto.ReplySaveRequestDto;
import com.example.myblog.model.Board;
import com.example.myblog.model.Reply;
import com.example.myblog.model.RoleType;
import com.example.myblog.model.User;
import com.example.myblog.repository.BoardRepository;
import com.example.myblog.repository.ReplyRepsitory;
import com.example.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepsitory replyRepsitory;

    @Transactional
    public void 글쓰기(Board board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다");
        });
    }

    @Transactional
    public void 글삭제하기(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다");
                }); // 영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 flush
    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {

//        User user = userRepository.findById(replySaveRequestDto.getUserId())
//                .orElseThrow(() -> {
//                    return new IllegalArgumentException("댓글 쓰기 실패 : 유저 id를 찾을 수 없습니다");
//                }); // 영속화 완료
//
//        Board board = boardRepository.findById(replySaveRequestDto.getBoardId())
//                .orElseThrow(() -> {
//                    return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다");
//                }); // 영속화 완료
//
//        Reply reply = Reply.builder()
//                .user(user)
//                .board(board).content(replySaveRequestDto.getContent())
//                .build();

//        replyRepsitory.save(reply);
        int result = replyRepsitory.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println(result); // 오브젝트를 출력하게 되면 자동으로 toString()이 호출됨.

    }

    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepsitory.deleteById(replyId);
    }
}
