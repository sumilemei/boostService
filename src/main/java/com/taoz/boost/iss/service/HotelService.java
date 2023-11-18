package com.taoz.boost.iss.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taoz.boost.iss.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author taozheng
 * @date 2023/11/14 - 23:23
 * @introduce:
 */
@Service
public class HotelService implements IHotelService{
    @Override
    public boolean saveBatch(Collection<Hotel> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Hotel> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Hotel> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Hotel entity) {
        return false;
    }

    @Override
    public Hotel getOne(Wrapper<Hotel> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Hotel> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Hotel> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Hotel> getBaseMapper() {
        return null;
    }
}
