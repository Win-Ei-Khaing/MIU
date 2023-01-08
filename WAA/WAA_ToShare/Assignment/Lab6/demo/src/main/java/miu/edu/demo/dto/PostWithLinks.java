package miu.edu.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostWithLinks extends RepresentationModel<Greeting> {

    private final PostDto content;

    @JsonCreator
    public PostWithLinks(@JsonProperty("content") PostDto content) {
        this.content = content;
    }

    public PostDto getContent() {
        return content;
    }
}
