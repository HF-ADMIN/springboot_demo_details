package com.example.demo_details.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class DetailsDTO {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request implements TInfoDTO {
        private String prodCode;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response implements TInfoDTO {
        private String prodName;
        private String detailsImg;
        private Integer resultCode;
    }
}
