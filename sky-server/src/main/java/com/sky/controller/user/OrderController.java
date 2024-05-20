package com.sky.controller.user;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderSubmitVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//重新指定Bean名字，防止与客户端重复名字
@RestController("userOrderController")
@Slf4j
@RequestMapping("/user/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单，参数为：{}",ordersSubmitDTO);
        OrderSubmitVO orderSubmitVO =  orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }
}
