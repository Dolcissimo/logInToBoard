package me.sungJ.logInToBoard.application;


import lombok.RequiredArgsConstructor;
import me.sungJ.logInToBoard.domain.Post;
import me.sungJ.logInToBoard.domain.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    //등록
    public Post save (Post post) {
        return postRepository.save(post);
    }

    //전체 글 조회
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //단일 글 조회
    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    //삭제
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    //수정
    public void update(Long id, String title, String content) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(title, content);
    }

}
