/**
 * Copyright(c) 2018 asura
 */
package con.study.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p></p>
 *
 *  数据返回
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/20 12:07 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    //404 Not Found

    private  Integer code;

    private String  message;

    private  T  data;

    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
