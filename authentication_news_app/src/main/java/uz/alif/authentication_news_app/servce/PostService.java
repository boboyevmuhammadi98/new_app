package uz.alif.authentication_news_app.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.PostDto;
import uz.alif.authentication_news_app.entity.Post;
import uz.alif.authentication_news_app.exception.NewsAppResourceNotFoundException;
import uz.alif.authentication_news_app.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getALl() {
        return postRepository.findAll();
    }

    public Post add(PostDto postDto) {
        return postRepository.save(new Post(postDto.getName(), postDto.getTitle()));
    }

    public Post edit(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NewsAppResourceNotFoundException("post not found"));
        post.setName(postDto.getName());
        post.setTitle(postDto.getTitle());
        return postRepository.save(post);
    }

    public ApiResponse delete(Long id) {
        try {
            postRepository.deleteById(id);
            return new ApiResponse("deleted", true, 410, null);
        } catch (Exception e) {
            return new ApiResponse("not found", false, 404, null);
        }
    }

}
