package com.example.myblog;

import com.example.myblog.model.Reply;
import org.junit.jupiter.api.Test;

public class ReplyObjectTest {

    @Test
    public void 투스트링테스트() {
        Reply reply = Reply.builder()
                .id(1)
                .user(null)
                .board(null)
                .content("안녕")
                .build();

        System.out.println(reply); //오브젝트 호출시에 toString()이 자동으로 호출됨
    }
}
