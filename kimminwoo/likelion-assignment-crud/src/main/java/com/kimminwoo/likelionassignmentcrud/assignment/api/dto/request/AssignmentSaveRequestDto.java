package com.kimminwoo.likelionassignmentcrud.assignment.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AssignmentSaveRequestDto(

        @NotBlank(message = "제목은 필수입니다.")
        @Size(min = 2, max = 100, message = "제목은 2~100자여야 합니다.")
        String title,

        @NotBlank(message = "내용은 필수입니다.")
        @Size(min = 5, max = 1000, message = "내용은 5~1000자여야 합니다.")
        String content,

        @NotNull(message = "학생 ID는 필수입니다.")
        Long studentId

) {}
