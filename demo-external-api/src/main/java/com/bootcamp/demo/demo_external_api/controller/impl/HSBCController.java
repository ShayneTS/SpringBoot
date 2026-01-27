package com.bootcamp.demo.demo_external_api.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.controller.HSBCOperation;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.mapper.DtoMapper;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class HSBCController implements HSBCOperation {
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;

  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<UserDto> getUsers() {
    // List<UserDTO> -> List<UserDto>
    return this.jsonPlaceHolderService.getUsers().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<PostDto> getPosts() {
    List<PostDto> postDtos = new ArrayList<>();
    List<PostDTO> serviceResults = this.jsonPlaceHolderService.getPosts();
    for (PostDTO postDTO : serviceResults) {
      PostDto postDto = this.dtoMapper.map(postDTO);
      postDtos.add(postDto);
    }
    return postDtos;
  }

  @Override
  public Cat getCat() {
    return this.jsonPlaceHolderService.getCat();
  }
}