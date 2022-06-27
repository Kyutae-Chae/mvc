package com.codestates.mvc.coffee;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePatchDto {

    @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$", message = "한글만 입력가능합니다.")
    private String korName;

    @Pattern(regexp = "^[a-zA-Z]*\\s?[a-zA-Z]*$", message = "영어만 입력가능합니다.")
    private String engName;

    @Nullable
    @Range(min=100, max=50000)
    private Integer price;
}
