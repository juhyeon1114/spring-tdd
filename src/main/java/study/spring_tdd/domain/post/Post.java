package study.spring_tdd.domain.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static Post create(String title, String content) {
        Post post = new Post();
        post.title = title;
        post.content = content;
        post.createdAt = LocalDateTime.now();
        return post;
    }

}
