package com.github.kjkow.workoutpartner.session;

import lombok.NonNull;
import lombok.Value;

@Value
class Result {
    @NonNull
    Status status;
    String reason;

    static Result success() {
        return new Result(Status.SUCCESS, null);
    }

    static Result failure(String reason) {
        return new Result(Status.FAILURE, reason);
    }

    boolean isSuccess() {
        return status == Status.SUCCESS;
    }

    boolean isFailure() {
        return status == Status.FAILURE;
    }

    enum Status {
        SUCCESS,
        FAILURE
    }

}
