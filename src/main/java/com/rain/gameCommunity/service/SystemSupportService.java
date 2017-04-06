package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rain.gameCommunity.entity.SystemSupportEntity;

@Component
public interface SystemSupportService {

	public List<SystemSupportEntity> showAllSystemSupportService() throws Exception;
	
	public SystemSupportEntity showSystemSupportById(long id) throws Exception;
}
