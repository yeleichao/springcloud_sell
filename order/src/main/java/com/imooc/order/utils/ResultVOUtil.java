package com.imooc.order.utils;

import com.imooc.order.vo.ResultVO;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setObject(object);
        return resultVO;
    }
}
