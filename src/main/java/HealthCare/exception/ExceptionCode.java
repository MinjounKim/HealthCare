package HealthCare.exception;

import lombok.Getter;

public enum ExceptionCode {
    Member_NOT_FOUND(404, "Member not found"),
    Trainer_NOT_FOUND(404, "Trainer not found"),

    MEMBER_EXISTS(409, "Member exists"),
    TRAINER_EXISTS(409, "Trainer exists"),
    EMAIL_EXISTS(409,"이미 가입된 이메일 입니다."),
    PHONE_EXISTS(409,"이미 가입된 휴대폰 번호입니다."),

    EMAIL_NOT_EXISTS(200, "사용 가능한 이메일 입니다."),
    PHONE_NOT_EXISTS(200, "사용 가능한 휴대폰 번호 입니다.");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}