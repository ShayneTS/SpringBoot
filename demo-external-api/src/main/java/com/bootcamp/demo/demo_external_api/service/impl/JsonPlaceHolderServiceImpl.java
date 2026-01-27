package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.PostRepository;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {

  // private static String url = "https://jsonplaceholder.typicode.com/users";

  @Value("${external-api.jsonplaceholder.domain}")
  private String domain;

  @Value("${external-api.jsonplaceholder.paths.user-path}")
  private String userPath;

  @Value("${external-api.jsonplaceholder.paths.post-path}")
  private String postPath;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "superCat")
  private Cat ijk;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<UserDTO> getUsers() {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.domain) //
        .path(this.userPath) //
        .build() //
        .toUriString(); //
    System.out.println("url=" + url);
    UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);

    // List<UserDTO> -> List<UserEntity>
    // EntityMapper
    List<UserEntity> userEntities = Arrays.asList(userDTOs).stream() //
        .map(e -> this.entityMapper.map(e)) //
        .collect(Collectors.toList());
    // insert DB
    this.userRepository.saveAll(userEntities);

    return Arrays.asList(userDTOs);
  }

  // ! User Login -> userid + Post Object -> call backend
  @Override
  public List<PostDTO> getPosts() {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.domain) //
        .path(this.postPath) //
        .build() //
        .toUriString(); //
    System.out.println("url=" + url);
    PostDTO[] postDtos = this.restTemplate.getForObject(url, PostDTO[].class);
    
    // ! List<PostDTO> -> List<PostEntity>
    List<PostEntity> postEntities = Arrays.asList(postDtos).stream() //
        .map(e -> {
          // Find UserEntity by given user id
          UserEntity userEntity = this.userRepository.findById(e.getUserId())
              .orElseThrow(() -> new IllegalArgumentException());
          PostEntity postEntity = this.entityMapper.map(e);
          postEntity.setUserEntity(userEntity); // ! Set FK
          return postEntity;
        }).collect(Collectors.toList());

    this.postRepository.saveAll(postEntities);

    return Arrays.asList(postDtos);
  }

  @Override
  public Cat getCat() {
    return this.ijk;
  }
}