package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.SystemSupportDAO;
import com.rain.gameCommunity.entity.SystemSupportEntity;
import com.rain.gameCommunity.service.SystemSupportService;

@Service
public class SystemSupportServiceImpl implements SystemSupportService {

	@Autowired
	private SystemSupportDAO systemSupportDao;
	
	@Override
	public List<SystemSupportEntity> showAllSystemSupportService() throws Exception {
		return systemSupportDao.queryAllSystemSupport();
	}

	@Override
	public SystemSupportEntity showSystemSupportById(long id) throws Exception {
		return systemSupportDao.querySystemSupportById(id);
	}

	@Override
	public long addSystemSupport(SystemSupportEntity systemSupport) throws Exception {
		
		return systemSupportDao.addSystemSupport(systemSupport);
	}

}
