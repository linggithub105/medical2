package cn.ling.medicalview.exception;

import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
public class BussinessException extends RuntimeException{
    private String code;
    private String messageEx;
    private String state;
}
