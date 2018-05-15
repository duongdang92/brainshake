package com.vn.brainshake.domain.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "nr", "lastName", "name", "firstName" })
public class UserDto {
  private long nr;
  private String lastName;
  private String name;
  private String firstName;
  private String address;
}