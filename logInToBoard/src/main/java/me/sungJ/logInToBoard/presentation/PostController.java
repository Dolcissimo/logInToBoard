package me.sungJ.logInToBoard.presentation;


import lombok.RequiredArgsConstructor;
import me.sungJ.logInToBoard.application.PostService;
import me.sungJ.logInToBoard.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    //게시글 목록 페이지
    @GetMapping
    public String list(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts",posts);
        return "posts/list";
    }


    //글 작성 페이지
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("post", new PostForm());
        return "posts/create";
    }


    //글 작성
    @PostMapping
    public String create (@ModelAttribute PostForm postForm) {
        Post post = Post.builder().title(postForm.getTitle())
                .content((postForm.getContent()))
                .author(postForm.getAuthor())
                .build();
        postService.save(post);
        return "redirect:/posts";
    }

    //글 보기
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "posts/detail"; // -> templates/posts/detail.html
    }
}
