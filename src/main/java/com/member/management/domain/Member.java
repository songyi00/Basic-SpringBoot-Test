package com.member.management.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Member {
    @ApiParam(value = "name", required = true)
    private String name;

    @ApiParam(value = "email", required = true)
    private String email;

    @ApiParam(value = "phoneNumber", required = true)
    private String phoneNumber;

    @ApiParam(value = "nickNames", required = true)
    private List<String> nickNames;
}