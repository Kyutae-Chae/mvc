package com.codestates.mvc.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private List<FieldError> fieldErrors;
    private List<ConstraintViolationExceptionError> violationExceptionErrors;

    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationExceptionError> violationExceptionErrors) {
        this.fieldErrors = fieldErrors;
        this.violationExceptionErrors = violationExceptionErrors;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationExceptionError.of(violations));
    }

    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationExceptionError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationExceptionError(String propertyPath, Object rejectedValue, String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationExceptionError> of(Set<ConstraintViolation<?>> violations) {
            return violations.stream()
                    .map(v -> new ConstraintViolationExceptionError(
                            v.getPropertyPath().toString(), v.getInvalidValue().toString(), v.getMessage()
                    )).collect(Collectors.toList());
        }
    }


}
