package cmpe275.dos.response;

import static cmpe275.dos.constant.JsonConstant.KEY_ERROR;
import static cmpe275.dos.constant.JsonConstant.KEY_MESSAGE;
import static cmpe275.dos.exception.ErrorCode.ERR_BAD_REQUEST;
import static cmpe275.dos.exception.ErrorCode.*;

import cmpe275.dos.exception.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class JsonResponseHandler {
    protected ResponseEntity<JsonResponse> genericResponse(JsonResponse jsonResponse, HttpStatus httpStatus) {
        return new ResponseEntity<JsonResponse>(jsonResponse, httpStatus);
    }

    protected ResponseEntity<JsonResponse> responseWithCustHeaders(JsonResponse jsonResponse, HttpHeaders headers,
                                                                   HttpStatus httpStatus) {
        return new ResponseEntity<JsonResponse>(jsonResponse, headers, httpStatus);
    }

    protected ResponseEntity<JsonResponse> failure(ErrorCode errorCode, String msg) {
        JsonResponse jsonResponse = new JsonResponse(KEY_ERROR, errorCode.name()).addPair(KEY_MESSAGE, msg);
        return genericResponse(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<JsonResponse> badRequest(String msg) {
        JsonResponse jsonResponse = new JsonResponse(KEY_ERROR, ERR_BAD_REQUEST).addPair(KEY_MESSAGE, msg);
        return genericResponse(jsonResponse, HttpStatus.BAD_REQUEST);
    }
}

