package com.notimplement.happygear.util;

import org.springframework.http.HttpStatus;

import com.notimplement.happygear.entities.ApiError;
import com.notimplement.happygear.entities.ApiResponse;

public class ResponseUtils {
    public static ApiResponse success(Object results, String message) {
        ApiError meta = new ApiError( 
            HttpStatus.OK.value(),
            message, 
            ""
        );
        return new ApiResponse(results, meta);
    }

    public static ApiResponse error(HttpStatus status, String message, String error) {
        ApiError meta = new ApiError( 
            status.value(),
            message, 
            error 
        );
        return new ApiResponse(null, meta);
    }
}
