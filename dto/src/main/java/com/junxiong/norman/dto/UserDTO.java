package com.junxiong.norman.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@Data
public class UserDTO {

    @NotNull
    private String name;

    @Data
    public static class Summary {
        private Long id;
        private String name;
        private String opId;
        private String unId;
    }

    @Data
    public static class Detail extends Summary {
        private String userEmail;
    }

    @Data
    public static class AddUser {
        private String name;
        private String opId;
        private String unId;
        private String userEmail;
        private Date time = new Date();
        private String nickName;
        private String mobile;
    }
}
