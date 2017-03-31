package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.ShoppingCartDAO;
import com.rain.gameCommunity.entity.ShoppingCartEntity;
import com.rain.gameCommunity.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDAO shoppingCartDao;
	
	@Override
	public List<ShoppingCartEntity> showShoppingCartByUserId(long userId) {
		return shoppingCartDao.queryShoppingCartByUserId(userId);
	}

}
