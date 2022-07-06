package com.obc.atv_rest.service;

import com.obc.atv_rest.payload.CommentDTO;
import com.obc.atv_rest.payload.PostDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getPostInfo(int cCode, String cName);
}
