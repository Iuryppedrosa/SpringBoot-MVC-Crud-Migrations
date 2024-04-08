package com.crud.entities;

import lombok.NonNull;

public record RequestProduct(
        String id,
        @NonNull
        String name,
        @NonNull
        Integer price_in_cents) {

}
