/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   14172
 * Date:     2019/12/11 9:17
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.erp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 14172
 * @create 2019/12/11
 * @since 1.0.0
 */
@RestController
public class UserController {

    @RequestMapping("/hello")
    public String getHello(){
        return "hello springboot ...";
    }
}
