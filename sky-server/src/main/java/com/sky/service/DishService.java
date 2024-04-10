package com.sky.service;

import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DishService {
    public void saveWithFlavor(DishDTO dishDTO);

    PageResult page(DishPageQueryDTO dishPageQueryDTO);

    void deleteaBatch(List<Long> ids);
}
