package uz.alif.authentication_news_app.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.CommDto;
import uz.alif.authentication_news_app.dtos.CommentDto;
import uz.alif.authentication_news_app.entity.Comment;
import uz.alif.authentication_news_app.entity.Post;
import uz.alif.authentication_news_app.exception.NewsAppResourceNotFoundException;
import uz.alif.authentication_news_app.repository.CommentRepository;
import uz.alif.authentication_news_app.repository.PostRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getALl() {
        return commentRepository.findAll();
    }

    public Comment add(CommentDto commentDto) {
        Post post = postRepository.findById(commentDto.getPostId()).orElseThrow(() -> new NewsAppResourceNotFoundException("post not found"));
        return commentRepository.save(new Comment(commentDto.getTitle(), post);
    }

    public Comment edit(Long id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NewsAppResourceNotFoundException("comment not found"));
        comment.setTitle(commentDto.getTitle());
        return commentRepository.save(comment);
    }

    public ApiResponse delete(Long id) {
        try {
            commentRepository.deleteById(id);
            return new ApiResponse("deleted", true, 410, null);
        } catch (Exception e) {
            return new ApiResponse("not found", false, 404, null);
        }
    }

}
