package com.kimminwoo.likelionassignmentcrud.student.api;

import com.kimminwoo.likelionassignmentcrud.common.error.SuccessCode;
import com.kimminwoo.likelionassignmentcrud.common.template.ApiResTemplate;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.request.StudentSaveRequestDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.request.StudentUpdateRequestDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentInfoResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.api.dto.response.StudentListResponseDto;
import com.kimminwoo.likelionassignmentcrud.student.application.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Create
    @PostMapping
    public ApiResTemplate<Void> saveStudent(@RequestBody @Valid StudentSaveRequestDto requestDto) {
        studentService.saveStudent(requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.STUDENT_SAVE_SUCCESS);
    }

    // Read All
    @GetMapping
    public ApiResTemplate<StudentListResponseDto> getAllStudents() {
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, studentService.getAllStudents());
    }

    // Read One
    @GetMapping("/{studentId}")
    public ApiResTemplate<StudentInfoResponseDto> getStudentById(@PathVariable Long studentId) {
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, studentService.getStudentById(studentId));
    }

    // Update
    @PutMapping("/{studentId}")
    public ApiResTemplate<Void> updateStudent(
            @PathVariable Long studentId,
            @RequestBody @Valid StudentUpdateRequestDto requestDto) {
        studentService.updateStudent(studentId, requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.STUDENT_UPDATE_SUCCESS);
    }

    // Delete
    @DeleteMapping("/{studentId}")
    public ApiResTemplate<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ApiResTemplate.successWithNoContent(SuccessCode.STUDENT_DELETE_SUCCESS);
    }
}
