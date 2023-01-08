package miu.edu.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
