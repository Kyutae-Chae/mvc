package com.codestates.mvc.coffee;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class CoffeePostDto {
    @NotBlank(message = "필수 입력사항입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$", message = "한글만 입력가능합니다.")
    private String korName;

    @NotBlank(message = "필수 입력사항입니다.")
    @Pattern(regexp = "^[a-zA-Z]*\\s?[a-zA-Z]*$", message = "영어만 입력가능합니다.")
    private String engName;


    @NotNull
    @Min(100)
    @Max(50000)
    private int price;
}
