package com.gu.feign.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String username;
    private String address;
}