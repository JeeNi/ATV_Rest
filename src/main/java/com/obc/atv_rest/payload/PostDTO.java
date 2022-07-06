package com.obc.atv_rest.payload;

import com.obc.atv_rest.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class PostDTO {
//    private Long id;
    private int cCode;
    private String cName;
    private List<Comment> cContList;
}
