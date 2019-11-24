/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyWatcher
 * Author:   14172
 * Date:     2019/11/23 13:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.two.zkconfig.zkUtil;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author 14172
 * @create 2019/11/23
 * @since 1.0.0
 */
public interface IMyWatcher extends Watcher, AsyncCallback.DataCallback, AsyncCallback.StatCallback {

}
