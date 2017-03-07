package com.rain.gameCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.SectionDAO;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionDAO sectionDao;

	public List<SectionEntity> showAllSection() throws Exception {

		return sectionDao.queryAllSections();
	}

}
