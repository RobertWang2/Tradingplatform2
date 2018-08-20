package com.com.dao;

import com.spittr.Spittle;

import java.util.List;

/**
 * @program: Tradingplatform
 * @description:
 * @author: Robert_Wang
 * @create: 2018-08-17 20:33
 **/
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
