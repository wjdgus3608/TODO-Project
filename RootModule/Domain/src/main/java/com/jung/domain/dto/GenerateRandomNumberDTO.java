package com.jung.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GenerateRandomNumberDTO {
    @NotBlank(message = "부모 ID 값이 없습니다.")
    private String parentId;
    @NotBlank(message = "자식 ID 값이 없습니다.")
    private String childId;
    private String randomNumber;
}
