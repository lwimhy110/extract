package com.nipsoft.neo4.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBean {

    private String status;
    private String message;


}
