package com.member.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @ApiParam(value = "name", required = true)
    private String name;

    @ApiParam(value = "email", required = true)
    private String email;

    @ApiParam(value = "phoneNumber", required = true)
    private String phoneNumber;

    @ApiParam(value = "nickName", required = true)
    private List<String> nickNames;
}
