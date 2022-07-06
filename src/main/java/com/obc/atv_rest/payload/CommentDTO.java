package com.obc.atv_rest.payload;

import lombok.Data;

@Data
public class CommentDTO {
    private int cont_id;
    private int vir_id;
    private String title;
    private String descript;
    private String extra_text;
    private int price_cash_amt;
    private int price_point_amt;
    private int price_coupon_amt;
    private boolean copyright_yn;
    private String thumbnail_url;
    private String sample_url;
    private int resolution_cd;
    private int item_count;
    private String reg_user;
    private int sectIndex;
    private String sectName;
    private boolean adult_yn;
    private int duration;
    private int available_left;
    private int item_type;
}
